package top.leyton.DBSCAN;

import java.sql.Time;
import java.util.Date;


public class Point {
    private double x;
    private double y;
    private Time time;
    private Date date;
    private boolean isVisit;
    private int cluster;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private boolean isNoised;

    public Point(double x, double y, Time time, Date date) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.date = date;
        this.isVisit = false;
        this.cluster = 0;
        this.isNoised = false;
    }

    public int getTimeInterval(Point point) {
        long from = time.getTime();
        long to = point.time.getTime();
        int min = (int) Math.abs((to - from) / (1000 * 60));
//        System.out.println(min);
        return min;
    }

    public double getDistance(Point point) {

        double lat1 = (Math.PI / 180) * x;
        double lat2 = (Math.PI / 180) * point.x;
        double lon1 = (Math.PI / 180) * y;
        double lon2 = (Math.PI / 180) * point.y;
        double R = 6371;
        double GeoDistance = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
//        System.out.println(GeoDistance);
        return GeoDistance;
        // return Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y));
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setVisit(boolean isVisit) {
        this.isVisit = isVisit;
    }

    public boolean getVisit() {
        return isVisit;
    }

    public int getCluster() {
        return cluster;
    }

    public void setNoised(boolean isNoised) {
        this.isNoised = isNoised;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public boolean getNoised() {
        return this.isNoised;
    }

    @Override
    public String toString() {
        return x + " " + y + " " +date+" "+ time + " " + cluster + " " + (isNoised ? 1 : 0);
    }

}
