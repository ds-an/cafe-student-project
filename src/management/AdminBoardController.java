package management;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import utility.DataPasser;

import java.time.LocalDate;

public class AdminBoardController {
//    private String adminname = Database.getData("SELECT * FROM access WHERE UserType = 'Admin").getString(2);
    @FXML
    private Text welcomeText;
    @FXML
    private Text currentDate;

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void setCurrentDate() {
        currentDate.setText("The date today is: " + LocalDate.now().toString());
    }

}
