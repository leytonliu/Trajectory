package top.leyton.util;

import top.leyton.conn.Conn;
import top.leyton.model.CheckinTable;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 签到表工具类
 */
public class CheckinUtil {

    public static void main(String[] args) {
        CheckinUtil checkinUtil = new CheckinUtil();
        Date date = new Date(15228);
        System.out.println(date.getTime());


        List<CheckinTable> checkinTableList = checkinUtil.getCheckinByUserId(1);
        Iterator<CheckinTable> iterator = checkinTableList.iterator();
        while (iterator.hasNext()) {
            CheckinTable checkinTable = iterator.next();
            System.out.print(checkinTable.getLatitude() + "\t");
            System.out.print(checkinTable.getDate() + "\t");
            System.out.println(checkinTable.getTime());
        }
    }

    /**
     * 根据user_id查询该用户所有的签到记录
     *
     * @param id
     * @return
     */
    public List<CheckinTable> getCheckinByUserId(int id) {
        List<CheckinTable> checkinTableList = new ArrayList<CheckinTable>();

        try {
            Conn conn = new Conn();
            PreparedStatement pstmt;
            String sql = "select * from checkin where user_id=?";
            pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setInt(1, id);
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

    public CheckinTable getCheckinById(int id) {
        CheckinTable checkinTable = new CheckinTable();

        try {
            Conn conn = new Conn();
            PreparedStatement pstmt;
            String sql = "select * from checkin where id=?";
            pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                checkinTable.setId(rs.getInt(1));
                checkinTable.setUser_id(rs.getInt(2));
                checkinTable.setLatitude(rs.getDouble(3));
                checkinTable.setLongitude(rs.getDouble(4));
                checkinTable.setLocation_id(rs.getInt(5));
                checkinTable.setDate(rs.getDate(6));
                checkinTable.setTime(rs.getTime(7));
            }
            return checkinTable;
        } catch (SQLException e) {
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