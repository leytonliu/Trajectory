package top.leyton.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/gowalla?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            String user = "root";
            String password = "leyton";
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getMetaData().getURL());
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
