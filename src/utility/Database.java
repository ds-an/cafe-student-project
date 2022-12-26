package utility;
import java.sql.*;

public class Database {
    private static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:sqlite:cafedb.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static ResultSet getData(String query) throws SQLException {
        Statement stmt = connect().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public static void inputData(String query) throws SQLException {
        PreparedStatement stmt = connect().prepareStatement(query);
        stmt.executeUpdate();
    }

    public static void deleteData(String query) throws SQLException {
        PreparedStatement stmt = connect().prepareStatement(query);
        stmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getData("SELECT FirstName\n" +
                "FROM baristas\n" +
                "WHERE BaristaId = 2;").getString(1));
        System.out.println(getData("SELECT FirstName\n" +
                "FROM baristas\n" +
                "WHERE BaristaId = 3;").getString(1));
        inputData("UPDATE baristas SET FirstName = 'Jerryupdated'\n" +
                "WHERE BaristaId = 2;");
        System.out.println(getData("SELECT FirstName\n" +
                "FROM baristas\n" +
                "WHERE BaristaId = 2;").getString(1));
        inputData("UPDATE baristas SET FirstName = 'Jerry'\n" +
                "WHERE BaristaId = 2;");
    }
}

