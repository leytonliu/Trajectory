package top.leyton.util;

import java.sql.Date;
import java.sql.Time;


class Point {
    public double x = 0;
    public double y = 0;
    public Date date;
    public Time time;
    public int flag = -1;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setY(double y) {
        this.y = y;
    }

}