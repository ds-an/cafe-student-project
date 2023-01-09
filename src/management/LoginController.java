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
    private ResultSet users;
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
        users = Database.getData("select * from full_login_info;");
        String username = usernameField.getText();
        String password = passwordField.getText();
            while (users.next()) {
                if ((users.getString(2).equals(username) || users.getString(4).equals(username))
                        && users.getString(3).equals(password) && (users.getInt(1) > 0 &&
                        users.getInt(1) < 10)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminBoard.fxml"));
                    root = loader.load();
                    AdminBoardController adminBoardController = loader.getController();
                    loader.setController(adminBoardController);
                    adminBoardController.setNameLabel(username);
                    adminBoardController.setCurrentDate();
                    adminBoardController.populateItemTypeBox();
                    adminBoardController.populateComboBoxes();
                    adminBoardController.populateTables();
//                root = FXMLLoader.load(getClass().getResource("AdminBoard.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                }else if ((users.getString(2).equals(username) || users.getString(4).equals(username))
                        && users.getString(3).equals(password) && (users.getInt(1) > 9 &&
                        users.getInt(1) < 100)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("BaristaBoard.fxml"));
                    root = loader.load();
                    BaristaBoardController baristaBoardController = loader.getController();
                    loader.setController(baristaBoardController);
                    baristaBoardController.setNameLabel(username);
                    baristaBoardController.setCurrentDate();
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                }else if ((users.getString(2).equals(username) || users.getString(4).equals(username))
                        && users.getString(3).equals(password) && (users.getInt(1) > 99)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientBoard.fxml"));
                    root = loader.load();
                    ClientBoardController clientBoardController = loader.getController();
                    loader.setController(clientBoardController);
                    clientBoardController.setNameLabel(username);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
                usernameField.clear();
                passwordField.clear();
                }
//            users.first();
            }
    public void changeSceneToClient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientBoard.fxml"));
        root = loader.load();
        ClientBoardController clientBoardController = loader.getController();
        loader.setController(clientBoardController);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
