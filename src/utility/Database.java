package utility;
import java.sql.*;

public class Database {

//    private static Connection connection = null;
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
//            if (connection == null) {
//                conn = DriverManager.getConnection(url);
//                return conn;
//            } else {
//                return conn;
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static ResultSet getData(String query) throws SQLException {
        Connection connection = connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public static void inputData(String query) throws SQLException {
        Connection connection = connect();
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.executeUpdate(); //.executeUpdate
        stmt.close();
        connection.close();
    }

    public static void deleteData(String query) throws SQLException {
        PreparedStatement stmt = connect().prepareStatement("BEGIN TRANSACTION; " + query + " COMMIT;");
        stmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        ResultSet resultSet1 = getData("SELECT FirstName\n" +
                "FROM baristas\n" +
                "WHERE BaristaId = 11;");
        System.out.println(resultSet1.getString(1));
        resultSet1.close();
        ResultSet resultSet2 = getData("SELECT FirstName\n" +
                "FROM baristas\n" +
                "WHERE BaristaId = 12;");
        System.out.println(resultSet2.getString(1));
        resultSet2.close();
        inputData("UPDATE baristas SET FirstName = 'Jerryupdated'\n" +
                "WHERE BaristaId = 11;");
        ResultSet resultSet3 = getData("SELECT FirstName\n" +
                "FROM baristas\n" +
                "WHERE BaristaId = 11;");
        System.out.println(resultSet3.getString(1));
        resultSet3.close();
        inputData("UPDATE baristas SET FirstName = 'Jerry'\n" +
                "WHERE BaristaId = 11;");
    }
}

