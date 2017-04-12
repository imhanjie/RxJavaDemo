package com.melodyxxx.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.reflect.TypeToken;
import com.melodyxxx.rxjavademo.bean.AggregateResult;
import com.melodyxxx.rxjavademo.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get();
    }

    private void get() {
        Map<String, String> params = new HashMap<>();
        params.put("lat", "30.21398172");
        params.put("lng", "120.2159214");
        params.put("range", "2");
        RetrofitClient.getInstance(this).get("Schedule/gatherManage/select/near/myPosition", params, new TypeToken<AggregateResult>() {
        }, new BaseObserver<AggregateResult>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AggregateResult aggregateResult) {
                L.e("~onNext:" + aggregateResult.toString());
            }

            @Override
            public void onError(Throwable e) {
                L.e("~onError:" + e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
