package com.melodyxxx.rxjavademo.bean;

import com.melodyxxx.rxjavademo.http.result.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hanjie on 2017/4/7.
 */

public class AggregateResult extends BaseResult{

    public List<Aggregate> data;

    @Override
    public String toString() {
        return "AggregateResult{" +
                "data=" + data +
                '}';
    }

    public static class Aggregate implements Serializable {
        public String address;
        public Object createTime;
        public boolean delFlag;
        public String id;
        public double lat;
        public double lng;
        public String title;

        @Override
        public String toString() {
            return "Aggregate{" +
                    "address='" + address + '\'' +
                    ", createTime=" + createTime +
                    ", delFlag=" + delFlag +
                    ", id='" + id + '\'' +
                    ", lat=" + lat +
                    ", lng=" + lng +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

}
