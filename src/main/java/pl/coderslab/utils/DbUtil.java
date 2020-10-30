package pl.coderslab.utils;

import java.sql.*;

public class DbUtil {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/webappShop?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "coderslab";
    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection conWorkshop() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException exc) {  // brak klasy sterownika
            System.out.println("Brak klasy sterownika");
            System.out.println(exc);
            System.exit(1);
        } catch (SQLException exc) {  // nieudane połączenie
            System.out.println("Nieudane połączenie z " + DB_URL);
            System.out.println(exc);
            System.exit(1);
        }
        return con;
    }
    public static Connection conWork2() {
        Connection conn = null;
        return conn;
    }
    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(tableName);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
