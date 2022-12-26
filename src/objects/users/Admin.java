package objects.users;

import utility.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends User {
    public Admin() throws SQLException {
        super();
        ResultSet admin = Database.getData("select * from admin");
        setId(admin.getInt(1));
        setLastName(admin.getString(3));
        setFirstName(admin.getString(2));
        setPhoneNumber(admin.getString(4));
        setEmail(admin.getString(5));
        admin.close();
    }

    public static void main(String[] args) throws SQLException {
        Admin admin1 = new Admin();
        System.out.println(admin1.getId());
        System.out.println(admin1.getFirstName());
    }
}
