package com.melodyxxx.rxjavademo.bean;

import java.util.List;

/**
 * Created by hanjie on 2017/4/5.
 */

public class SignDetailBean {

    /**
     * missionInfo : {"rangeRadius":500,"missionId":"wdP45mpGncQC6Bugkcu3tJPQ","attendanceLng":120.214567328559,"arrivalEndTime":"2017-04-02T23:00:00+0800","attendanceAddress":"浙江省杭州市滨江区西兴街道宏飞路星耀城1期","arrivalTime":"2017-04-02T13:24:54+0800","description":null,"statusName":"已到达","attendanceLat":30.2142138671875,"signType":"1","currentStatus":"ARRIVAL","messageDetail":"1.在规定到达时间前位置签到"}
     * missionLog : [{"id":"wdAVwFKUfgR3m7LN02yKSUIg","time":"2017-04-02T13:35:03+0800","status":"ARRIVAL","name":"到达"}]
     */

    public MissionInfo missionInfo;
    public List<MissionLog> missionLog;

    public static class MissionInfo {
        /**
         * rangeRadius : 500
         * missionId : wdP45mpGncQC6Bugkcu3tJPQ
         * attendanceLng : 120.214567328559
         * arrivalEndTime : 2017-04-02T23:00:00+0800
         * attendanceAddress : 浙江省杭州市滨江区西兴街道宏飞路星耀城1期
         * arrivalTime : 2017-04-02T13:24:54+0800
         * description : null
         * statusName : 已到达
         * attendanceLat : 30.2142138671875
         * signType : 1
         * currentStatus : ARRIVAL
         * messageDetail : 1.在规定到达时间前位置签到
         */

        public int rangeRadius;
        public String missionId;
        public double attendanceLng;
        public String arrivalEndTime;
        public String attendanceAddress;
        public String arrivalTime;
        public Object description;
        public String statusName;
        public double attendanceLat;
        public String signType;
        public String currentStatus;
        public String messageDetail;
    }

    public static class MissionLog {
        /**
         * id : wdAVwFKUfgR3m7LN02yKSUIg
         * time : 2017-04-02T13:35:03+0800
         * status : ARRIVAL
         * name : 到达
         */

        public String id;
        public String time;
        public String status;
        public String name;

    }

}
