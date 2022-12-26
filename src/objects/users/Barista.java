package objects.users;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Barista extends User{
    private String Shift;
    private String Rank;
    private int ShiftManager;

    public Barista() {
        super();
        Shift = null;
        Rank = null;
        ShiftManager = 0;
    }

    public Barista(int id, String firstName, String lastName, String shift,
                   String rank, int shiftManager, String phoneNumber,
                  String email) {
        super(id, firstName, lastName, phoneNumber, email);
        this.Shift = shift;
        this.Rank = rank;
        this.ShiftManager = shiftManager;
    }

    public Barista(int id) throws SQLException {
        super();
        ResultSet barista = Database.getData("select * from baristas");
        setId(barista.getInt(1));
        setLastName(barista.getString(3));
        setFirstName(barista.getString(2));
        this.Shift = barista.getString(4);
        this.Rank = barista.getString(5);
        this.ShiftManager = barista.getInt(6);
        setPhoneNumber(barista.getString(7));
        setEmail(barista.getString(8));
        barista.close();
    }

    public void insertBarista() throws SQLException {
        String query = String.format("INSERT INTO baristas VALUES (%d, '%s', '%s', '%s', '%s', '%d', '%s', '%s')",
                super.getId(), super.getFirstName(), super.getLastName(),
                this.Shift, this.Rank, this.ShiftManager, super.getPhoneNumber(),
                super.getEmail());
        Database.inputData(query);
    }

    public void insertBarista(int id, String firstName, String lastName, String shift,
                              String rank, int shiftManager, String phoneNumber,
                              String email) throws SQLException {
        String query = String.format("INSERT INTO baristas VALUES (%d, '%s', '%s', '%s', '%s', '%d', '%s', '%s')",
         id, firstName,  lastName, shift,
                rank,  shiftManager, phoneNumber,
                 email);
        Database.inputData(query);
    }

}
