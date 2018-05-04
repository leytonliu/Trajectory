package top.leyton.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.leyton.model.CheckinTable;

import java.util.Iterator;
import java.util.List;

public class Out {
    public static void main(String[] args) {

//        String sql="select * from checkin WHERE user_id='2'AND date='2010-09-10' ORDER BY id DESC ";
        String sql="select * from checkin WHERE user_id='2'";
        String sql2="SELECT * FROM `checkin` WHERE user_id = '2' AND time>'03:30:00'AND time <'05:47:00' ORDER BY id DESC";
        //String sql="select * from checkin HAVING COUNT(user_id)>100";
        CheckinUtil checkinUtil = new CheckinUtil();
        List<CheckinTable> checkinTableList = checkinUtil.QueryCheckin(sql2);
        Iterator<CheckinTable> iterator = checkinTableList.iterator();
        while (iterator.hasNext()) {
            CheckinTable checkinTable = iterator.next();
            System.out.println("{lat:"+checkinTable.getLatitude()+",lng:"+checkinTable.getLongitude()+"},");
//            System.out.println(checkinTable.getId()+"\t"+checkinTable.getLatitude()+"\t"+checkinTable.getLongitude()+"\t"+checkinTable.getDate()+"\t"+checkinTable.getTime());

//            GsonBuilder gsonBuilder=new GsonBuilder();
//            gsonBuilder.setPrettyPrinting();
//            gsonBuilder.setDateFormat("YYYY-MM-dd");
//            Gson gson=gsonBuilder.create();
//            System.out.println(gson.toJson(checkinTable));
        }
    }
}
