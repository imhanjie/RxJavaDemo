package com.melodyxxx.rxjavademo.http;

import com.melodyxxx.rxjavademo.http.result.SignDetailResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by hanjie on 2017/4/5.
 */

public interface ApiService {

    String BASE_URL = "http://dev.api.gomrwind.com:5000/";

    @GET("WindMission/mission/attendance/getSignDetail")
    Observable<SignDetailResult> getSignDetail(
            @Query("missionId") String missionId,
            @Query("userId") String userId
    );

    @GET
    Observable<String> get(
            @Url String url,
            @QueryMap Map<String, String> map);

}
