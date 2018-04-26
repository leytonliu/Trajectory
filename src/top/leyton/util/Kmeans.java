package top.leyton.util;

import top.leyton.model.CheckinTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Kmeans {
    Point[] point;
    Point[] center_old;
    Point[] center_new;

    Scanner scanner = new Scanner(System.in);
    CheckinUtil checkinUtil = new CheckinUtil();
    List<CheckinTable> checkinTableList = checkinUtil.getCheckinByUserId(2);
    Iterator<CheckinTable> iterator = checkinTableList.iterator();

    public void initPoint() {
        int size = checkinTableList.size();
        point = new Point[size];
        int i = 0;

        while (iterator.hasNext()) {
            CheckinTable checkinTable = iterator.next();
            point[i] = new Point();
            point[i].setX(checkinTable.getLatitude());
            point[i].setY(checkinTable.getLongitude());
            point[i].setDate(checkinTable.getDate());
            point[i].setTime(checkinTable.getTime());
            i++;
        }
//        for (int j = 0; j < i; j++) {
//            System.out.println(point[j].x + "," + point[j].y);
//        }

        System.out.println("请输入初始化聚类中心个数：");
        int count = scanner.nextInt();
        this.center_old = new Point[count];
        this.center_new = new Point[count];

        for (int j = 0; j < count; j++) {
            center_old[j] = new Point();
            center_old[j].x = point[j].x;
            center_old[j].y = point[j].y;
        }
        System.out.println("初始聚类中心：");
        for (int k = 0; k < count; k++) {
            System.out.println("(" + center_old[k].x + "," + center_old[k].y + ")");
        }
    }

    //计算两个点之间的欧几里得距离
    public double distance(Point p1, Point p2) {

        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    //遍历每个点，寻找其所属聚点
    public void searchCenter() {

        for (int i = 0; i < point.length; i++) {
            int belong = 0;
            double minDistance = distance(point[i], center_old[0]);
            for (int j = 1; j < center_old.length; j++) {
                if (distance(point[i], center_old[j]) < minDistance) {
                    minDistance = distance(point[i], center_old[j]);
                    belong = j;
                }
            }
            point[i].flag = belong;
        }

    }


    //计算每个聚类中每个点到聚点距离的均值
    public void calAverage() {
        for (int i = 0; i < center_old.length; i++) {
//            System.out.println("以(" + center_old[i].x + "," + center_old[i].y + ")为聚类中心的点有：");
            double count = 0;
            Point newcenter = new Point();
            for (int j = 0; j < point.length; j++) {
                if (point[j].flag == i) {
//                    System.out.println("(" + point[j].x + "," + point[j].y + ")");
                    count += 1;
                    newcenter.x += point[j].x;
                    newcenter.y += point[j].y;
                }
            }
            center_new[i] = new Point();
            center_new[i].x = newcenter.x / count;
            center_new[i].y = newcenter.y / count;
            center_new[i].flag = -1;
            System.out.println("新的聚类中心：(" + center_new[i].x + "," + center_new[i].y + ")");

        }

    }

    public void replace(Point[] point_old, Point[] point_new) {
        for (int i = 0; i < point_old.length; i++) {
            point_old[i].x = point_new[i].x;
            point_old[i].y = point_new[i].y;
            point_old[i].flag = -1;
        }
    }

    public void moveCenter() {
        this.searchCenter();
        this.calAverage();
        double moveDistance;

        int sign = -1;
        for (int i = 0; i < center_old.length; i++) {
            moveDistance = distance(center_old[i], center_new[i]);
            System.out.println("聚类中心移动距离：" + moveDistance);
            if (moveDistance == 0) {
                sign = 0;

            } else {
                sign = 1;
                break;
            }
        }
        if (sign == 0) {
            System.out.println("迭代完毕");

            for (int i = 0; i < center_old.length; i++) {
                System.out.println("以(" + center_old[i].x + "," + center_old[i].y + ")为聚类中心的点有：");
                for (int j = 0; j < point.length; j++) {
                    if (point[j].flag == i) {
                        System.out.println(j + "\t" + point[j].x + "\t" + point[j].y + "\t" + point[j].getDate() + "\t" + point[j].getTime());

                    }
                }
                System.out.println();
            }

            int[] count;
            count = new int[center_old.length];
            for (int i = 0; i < center_old.length; i++) {

                for (int j = 0; j < point.length; j++) {
                    if (point[j].flag == i) {
                        count[i]++;
                    }
                }


            }
            int max = count[0];
            int maxId = 0;
            for (int k = 0; k < count.length; k++) {

                if (count[k] >= max) {
                    max = count[k];
                    maxId = k;
                }
                System.out.println(count[k]);
            }
            System.out.println(maxId);

            for (int m = 0; m < point.length; m++) {
//                System.out.print(center_old[maxId].x + "," + center_old[maxId].y + "和" + point[m].x + "," + point[m].y + "之间的距离：");
//                System.out.println(getGeoDistance(center_old[maxId], point[m]) + "千米");
            }


        } else {
            replace(center_old, center_new);
            moveCenter();
        }
    }

    public double getGeoDistance(Point start, Point end) {
        double lat1 = (Math.PI / 180) * start.x;
        double lat2 = (Math.PI / 180) * end.x;
        double lon1 = (Math.PI / 180) * start.y;
        double lon2 = (Math.PI / 180) * end.y;
        double R = 6371;
        double GeoDistance = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
        return GeoDistance;
    }

    public static void main(String[] args) {
        Kmeans kmeans = new Kmeans();
        kmeans.initPoint();
        kmeans.moveCenter();

    }
}
