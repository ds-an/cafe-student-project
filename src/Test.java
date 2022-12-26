import objects.users.Client;
import utility.*;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
////        Client client1 = new Client(100, "Baba", "Ganoush",
////                "05888888888", "somemail", 0);
////        client1.insertClient();
//        System.out.println(Database.getData("SELECT FirstName FROM clients WHERE ClientId = 100;").getString(1));
        System.out.println(Database.getData("SELECT FirstName FROM baristas WHERE BaristaId = 3;").getString(1));
    }
}
