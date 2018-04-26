package top.leyton.test;

import top.leyton.conn.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) {
        Conn conn = new Conn();
        PreparedStatement pstmt;
       // String sql1 = "select * from admin where admin_name=? and admin_password=?";
        String sql2 = "select * from checkin where user_id='1'";
        try {
            pstmt = conn.getConn().prepareStatement(sql2);
            //pstmt.setString(1, "lld");
            //pstmt.setString(2, "lld");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
