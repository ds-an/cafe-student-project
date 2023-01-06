package management;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.DataPasser;
import utility.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Button loginclosebutton;
    @FXML
    private Button loginbutton;
    @FXML
    private Button ordernowbutton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private ResultSet users = Database.getData("SELECT * FROM access");
    private Stage stage;
    private Scene scene;
    private Parent root;

    public LoginController() throws SQLException {
    }

    @FXML
    public void close(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    public void changeSceneToUser(ActionEvent event) throws SQLException, IOException {
        // Как обеспечить повторный ввод в форму логина/пароля? Сейчас можно залогиниться
        // либо с первого раза, либо никак - после неудачной попытки залогиниться не удается.
        String username = usernameField.getText();
        String password = usernameField.getText();
        while (users.next()) {
            if (users.getString(2).equals(username) || users.getString(3).equals(username)
                    && users.getString(4).equals(password)
                    && users.getString(5).equals("Admin")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminBoard.fxml"));
                root = loader.load();
                AdminBoardController adminBoardController = loader.getController();
                loader.setController(adminBoardController);
                adminBoardController.setNameLabel(username);
                adminBoardController.setCurrentDate();
//                root = FXMLLoader.load(getClass().getResource("AdminBoard.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
    public void changeSceneToClient(ActionEvent event) {

    }

//    public static void main(String[] args) throws SQLException {
//        ResultSet users = Database.getData("SELECT * FROM access");
//        String login = "StanleyAdmin";
//        String password = "qwerty";
//            if (users.getString(2).equals(login) || users.getString(3).equals(login)
//                    && users.getString(4).equals(password)) {
//                System.out.println("You got it!");
//        }
//        System.out.println(users.getString(2).equals(login));
//        System.out.println(login);
//    }
}
