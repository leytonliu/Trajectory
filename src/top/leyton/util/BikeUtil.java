package top.leyton.util;

import top.leyton.conn.Conn;
import top.leyton.model.BikeTable;
import top.leyton.model.CheckinTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeUtil {


    public List<BikeTable> QueryBike(String sql){
        List<BikeTable> bikeTableList =new ArrayList<BikeTable>();
        try {
            Conn conn = new Conn();
            PreparedStatement pstmt;
            pstmt = conn.getConn().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BikeTable bikeTable=new BikeTable();
//                bikeTable.setStart_lat(rs.getDouble());
            }
            return bikeTableList;
            }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public List<CheckinTable> QueryCheckin(String sql) {
        List<CheckinTable> checkinTableList = new ArrayList<CheckinTable>();
        try {
            Conn conn = new Conn();
            PreparedStatement pstmt;
            pstmt = conn.getConn().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CheckinTable checkinTable = new CheckinTable();
                checkinTable.setId(rs.getInt(1));
                checkinTable.setUser_id(rs.getInt(2));
                checkinTable.setLatitude(rs.getDouble(3));
                checkinTable.setLongitude(rs.getDouble(4));
                checkinTable.setLocation_id(rs.getInt(5));
                checkinTable.setDate(rs.getDate(6));
                checkinTable.setTime(rs.getTime(7));
                checkinTableList.add(checkinTable);
            }
            return checkinTableList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
