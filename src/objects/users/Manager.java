package objects.users;

import utility.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager extends User {
    public Manager() {
        super();
//        ResultSet admin = Database.getData("select * from admin");
//        setId(admin.getInt(1));
//        setLastName(admin.getString(3));
//        setFirstName(admin.getString(2));
//        setPhoneNumber(admin.getString(4));
//        setEmail(admin.getString(5));
//        admin.close();
    }

    public static void main(String[] args) throws SQLException {
        Manager manager1 = new Manager();
        System.out.println(manager1.getId());
        System.out.println(manager1.getFirstName());
    }
}
