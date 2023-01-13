package management;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import objects.users.Client;
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
    private Button createAnAccount;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private ResultSet users;
    @FXML
    private AnchorPane createAnAccountPane;
    @FXML
    private AnchorPane mainLoginScreenPane;
    @FXML
    private TextField passwordField2;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Button registerButton;
    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField loginField;

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
                    baristaBoardController.populateTables();
                    baristaBoardController.populateComboBoxes();
                    String baristaIdQuery = String.format("SELECT AccessId FROM access WHERE Login = '%s' AND Password = '%s';",
                            username, password);
                    ResultSet getbaristaid = Database.getData(baristaIdQuery);
                    int baristaId = getbaristaid.getInt(1);
                    baristaBoardController.setBaristaId(baristaId);
                    getbaristaid.close();
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
                users.close();
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

    public void switchToCreateAnAccount() {
        createAnAccountPane.setVisible(true);
        mainLoginScreenPane.setVisible(false);
    }

    public void switchToMainLoginScreen() {
        createAnAccountPane.setVisible(false);
        mainLoginScreenPane.setVisible(true);
    }

    public void registerClient(ActionEvent event) throws SQLException {
        if (firstNameField.getText().isEmpty() || loginField.getText().isEmpty() ||
        passwordField2.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please provide your first name, login and password. " +
                    "Everything else is optional!");
            alert.showAndWait();
            throw new SQLException("Some of the necessary info was not provided by the user.");
        }
        Client client = new Client();
        client.setFirstName(firstNameField.getText());
        client.setLastName(lastNameField.getText());
        client.setPhoneNumber(phoneNumberField.getText());
        client.setEmail(emailField.getText());
        client.insertClient();
        String query = String.format("INSERT INTO access VALUES ((SELECT ClientId from clients WHERE ROWID = last_insert_rowid()), '%s', '%s');",
                loginField.getText(), passwordField2.getText());
        Database.inputData(query);
        String greeting = String.format("%s, thank you for registering at our Coffee Shop!", firstNameField.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, greeting);
        alert.showAndWait();
        switchToMainLoginScreen();
        firstNameField.clear();
        lastNameField.clear();
        passwordField2.clear();
        phoneNumberField.clear();
        emailField.clear();
        loginField.clear();
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
