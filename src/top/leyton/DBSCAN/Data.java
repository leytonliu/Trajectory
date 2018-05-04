package top.leyton.DBSCAN;

import top.leyton.model.CheckinTable;
import top.leyton.util.CheckinUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Jason on 2016/4/17.
 */
public class Data {
    private static DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();

//    public static ArrayList<Point> generateSinData(int size) {
//        ArrayList<Point> points = new ArrayList<Point>(size);
//        Random rd = new Random(size);
//        for (int i = 0; i < size / 2; i++) {
//            double x = format(Math.PI / (size / 2) * (i + 1));
//            double y = format(Math.sin(x));
//            points.add(new Point(x, y));
//        }
//        for (int i = 0; i < size / 2; i++) {
//            double x = format(1.5 + Math.PI / (size / 2) * (i + 1));
//            double y = format(Math.cos(x));
//            points.add(new Point(x, y));
//        }
//        return points;
//    }

    public static ArrayList<Point> generateSpecialData() {
        CheckinUtil checkinUtil = new CheckinUtil();
//        List<CheckinTable> checkinTableList = checkinUtil.QueryCheckin("SELECT * FROM `checkin` WHERE user_id = '2' AND date = '2010-08-27' ORDER BY id DESC");
//         List<CheckinTable> checkinTableList = checkinUtil.QueryCheckin("SELECT * FROM `checkin` WHERE user_id = '2' AND time>'16:30:00'AND time <'17:30:00' ORDER BY id DESC");
//        List<CheckinTable> checkinTableList = checkinUtil.QueryCheckin("SELECT * FROM `checkin` WHERE user_id = '2' AND time>'01:00:00'AND time <'02:30:00' ORDER BY id DESC");
//        List<CheckinTable> checkinTableList = checkinUtil.QueryCheckin("SELECT * FROM `checkin` WHERE user_id = '22' AND time>'02:00:00'AND time <'05:00:00' ORDER BY id DESC");
        List<CheckinTable> checkinTableList = checkinUtil.QueryCheckin("SELECT * FROM `checkin` WHERE user_id = '2'ORDER BY id DESC");
        Iterator<CheckinTable> iterator = checkinTableList.iterator();

        ArrayList<Point> points = new ArrayList<Point>();

        while (iterator.hasNext()) {
            CheckinTable checkinTable = iterator.next();
            points.add(new Point(checkinTable.getLatitude(), checkinTable.getLongitude(), checkinTable.getTime(), checkinTable.getDate()));
        }
        return points;
    }

    public static void writeData(ArrayList<Point> points, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Point point : points) {
                bw.write(point.toString() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double format(double x) {
        return Double.valueOf(df.format(x));
    }

}