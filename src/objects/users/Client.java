package objects.users;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client extends User{
    private int CoffeeOrders;

    public Client() {
        super();
        CoffeeOrders = 0;
    }

    public Client(int id) throws SQLException {
        super();
        String query = String.format("select * from clients where ClientId = %d", id);
        ResultSet client = Database.getData(query);
        setId(id);
        setLastName(client.getString(3));
        setFirstName(client.getString(2));
        setPhoneNumber(client.getString(4));
        setEmail(client.getString(5));
        this.CoffeeOrders = client.getInt(6);
        client.close();
    }

    public Client(int id, String firstName, String lastName, String phoneNumber,
                  String email, int coffeeOrders) {
        super(id, firstName, lastName, phoneNumber, email);
        this.CoffeeOrders = coffeeOrders;
    }

    public void insertClient() throws SQLException {
        String query = String.format("INSERT INTO clients (FirstName, LastName, PhoneNumber, Email, CoffeeOrders) VALUES ('%s', '%s', '%s', '%s', 0)",
                super.getFirstName(), super.getLastName(), super.getPhoneNumber(),
                super.getEmail());
        Database.inputData(query);
    }

//    public void insertClient(int id, String firstName, String lastName,
//                             String phoneNumber, String email, int coffeeOrders) throws SQLException {
//        String query = String.format("INSERT INTO clients VALUES (%d, '%s', '%s', '%s', '%s', '%d')",
//                id, firstName, lastName, phoneNumber, email, coffeeOrders);
//        Database.inputData(query);
//    }

    public static void main(String[] args) throws SQLException {
        Client client1 = new Client(100);
        System.out.println(client1.getEmail());
    }

}
