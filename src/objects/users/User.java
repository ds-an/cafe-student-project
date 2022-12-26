package objects.users;
import utility.*;

public abstract class User {
    private int id;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Email;

    public User() {
        this.id = 0;
        this.FirstName = null;
        this.LastName = null;
        this.PhoneNumber = null;
        this.Email = null;
    }

    public User(int id, String firstName, String lastName, String phoneNumber,
                String email) {
        this.id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}
