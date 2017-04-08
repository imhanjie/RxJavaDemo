package com.melodyxxx.rxjavademo.http;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melodyxxx.rxjavademo.L;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by hanjie on 2017/4/6.
 */

public class RetrofitClient {

    private static final int DEFAULT_TIMEOUT = 5;

    public static String BASE_URL = ApiService.BASE_URL;

    private static Context sContext;

    private static RetrofitClient INSTANCE;

    private ApiService mApiService;

    private OkHttpClient mOkHttpClient;

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient(sContext);
    }

    public static RetrofitClient getInstance(Context context) {
        if (context != null) {
            sContext = context.getApplicationContext();
        }
        return SingletonHolder.INSTANCE;
    }

    public static RetrofitClient getInstance(Context context, String url) {
        INSTANCE = new RetrofitClient(context, url);
        return INSTANCE;
    }

    private RetrofitClient(Context context) {

        this(context, null);
    }

    private RetrofitClient(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            url = BASE_URL;
        }
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(LOGGING_INTERCEPTOR)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    private static final Interceptor LOGGING_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            L.e(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            L.e(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    };


    public <T> void get(final String url, Map<String, String> parameters, final TypeToken<T> token, Observer<T> observer) {
        mApiService.get(url, parameters)
                .subscribeOn(Schedulers.io())
                .map(new Function<String, T>() {
                    @Override
                    public T apply(@NonNull String s) throws Exception {
                        return new Gson().fromJson(s, token.getType());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public <T> void get(final String url, Map<String, String> parameters, Observer<T> observer) {
        mApiService.get(url, parameters)
                .subscribeOn(Schedulers.io())
                .map(new Function<String, T>() {
                    @Override
                    public T apply(@NonNull String s) throws Exception {
                        return new Gson().fromJson(s, new TypeToken<T>(){}.getType());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
