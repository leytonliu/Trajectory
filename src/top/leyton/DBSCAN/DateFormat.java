package top.leyton.DBSCAN;

import top.leyton.model.CheckinTable;
import top.leyton.util.CheckinUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DateFormat {
    Date date=new Date();

    public static String getDistanceTime(long  time1,long time2 ) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long diff ;
        String flag;
        if(time1<time2) {
            diff = time2 - time1;
            flag="前";
        } else {
            diff = time1 - time2;
            flag="后";
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        if(day!=0)return day+"天"+flag;
        if(hour!=0)return hour+"小时"+flag;
        if(min!=0)return min+"分钟"+flag;
        return "刚刚";
    }
    public  static  void main(String args[]){

//        CheckinUtil checkinUtil = new CheckinUtil();
//        List<CheckinTable> checkinTableList = checkinUtil.getCeckinByUserId(1);
//        Iterator<CheckinTable> iterator = checkinTableList.iterator();
//        while (iterator.hasNext()) {
//            CheckinTable checkinTable = iterator.next();
//            System.out.println(checkinTable.getDate());
//            System.out.println(checkinTable.getTime().getTime());
//        }
        System.out.println(getDistanceTime(999990000,15660000));
}

}
