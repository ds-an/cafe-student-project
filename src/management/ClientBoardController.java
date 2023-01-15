package management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import objects.items.FullMenuItem;
import utility.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientBoardController {

    @FXML
    private Button addCoffeeToOrder;

    @FXML
    private Button addDrinkToOrder;

    @FXML
    private Button addFoodToOrder;

    @FXML
    private Button addTeaToOrder;

    @FXML
    private ComboBox<?> chooseCoffee;

    @FXML
    private ComboBox<?> chooseCoffeeMilk;

    @FXML
    private ComboBox<?> chooseCoffeeRoast;

    @FXML
    private ComboBox<?> chooseDrink;

    @FXML
    private ComboBox<?> chooseFood;

    @FXML
    private ComboBox<?> chooseTea;

    @FXML
    private ComboBox<?> chooseTeaMilk;

    @FXML
    private ComboBox<?> chooseTeaType;

    @FXML
    private Button clearOrderButton;

    @FXML
    private TableView<?> coffeeTable;

    @FXML
    private TableColumn<?, ?> coffeeTableId;

    @FXML
    private TableColumn<?, ?> coffeeTableMilkType;

    @FXML
    private TableColumn<?, ?> coffeeTableName;

    @FXML
    private TableColumn<?, ?> coffeeTablePriceIns;

    @FXML
    private TableColumn<?, ?> coffeeTablePriceOut;

    @FXML
    private TableColumn<?, ?> coffeeTableTemp;

    @FXML
    private TableColumn<?, ?> coffeeTableType;

    @FXML
    private TableColumn<?, ?> coffeeTotalLeft;

    @FXML
    private Text descriptionItem;

    @FXML
    private TableColumn<?, ?> drinkTableID;

    @FXML
    private TableColumn<?, ?> drinkTableName;

    @FXML
    private TableColumn<?, ?> drinkTablePriceIns;

    @FXML
    private TableColumn<?, ?> drinkTablePriceOut;

    @FXML
    private TableColumn<?, ?> drinkTableTotalLeft;

    @FXML
    private TableView<?> drinksTable;

    @FXML
    private TableView<?> foodTable;

    @FXML
    private TableColumn<?, ?> foodTableId;

    @FXML
    private TableColumn<?, ?> foodTableName;

    @FXML
    private TableColumn<?, ?> foodTablePriceIns;

    @FXML
    private TableColumn<?, ?> foodTablePriceOut;

    @FXML
    private TableColumn<?, ?> foodTableTotalLeft;

    @FXML
    private TableColumn<?, ?> foodTableType;

    @FXML
    private TableView<FullMenuItem> fullMenuTable;

    @FXML
    private TableColumn<?, ?> fullMenuTableId;

    @FXML
    private TableColumn<?, ?> fullMenuTableMilkType;

    @FXML
    private TableColumn<?, ?> fullMenuTableName;

    @FXML
    private TableColumn<?, ?> fullMenuTablePriceIns;

    @FXML
    private TableColumn<?, ?> fullMenuTablePriceOut;

    @FXML
    private TableColumn<?, ?> fullMenuTableTemp;

    @FXML
    private TableColumn<?, ?> fullMenuTableType;

    @FXML
    private TableColumn<?, ?> fullMenuTotalLeft;

    @FXML
    private TableColumn<?, ?> fullMenuDescription;

    @FXML
    private Button goBack;

    @FXML
    private Button goBackFromOrder;

    @FXML
    private ImageView infoButtonImage;

    @FXML
    private ImageView logOutButtonImage;

    @FXML
    private ImageView menuButtonImage;

    private ImageView welcomeImage;

    @FXML
    private Text nameItem;

    @FXML
    private ImageView orderButtonImage;

    @FXML
    private Button orderNow;

    @FXML
    private TableView<?> orderTable;

    @FXML
    private TableColumn<?, ?> orderTableDescription;

    @FXML
    private TableColumn<?, ?> orderTableName;

    @FXML
    private TableColumn<?, ?> orderTablePrice;

    @FXML
    private TableColumn<?, ?> orderTableType;

    @FXML
    private Button payWithCash;

    @FXML
    private Button payWithCreditCard;

    @FXML
    private Button payWithPayPal;

    @FXML
    private TableView<?> teaTable;

    @FXML
    private TableColumn<?, ?> teaTableId;

    @FXML
    private TableColumn<?, ?> teaTableMilkType;

    @FXML
    private TableColumn<?, ?> teaTableName;

    @FXML
    private TableColumn<?, ?> teaTablePriceIns;

    @FXML
    private TableColumn<?, ?> teaTablePriceOut;

    @FXML
    private TableColumn<?, ?> teaTableTemp;

    @FXML
    private TableColumn<?, ?> teaTableType;

    @FXML
    private TableColumn<?, ?> teaTotalLeft;

    @FXML
    private Text welcomeText;

    @FXML
    private Button callBarista;

    private Stage stage;

    private Scene scene;

    private Parent root;

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void callBarista(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Our barista is coming, please wait.");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void populateMenu() throws SQLException {
        ResultSet data = Database.getData("SELECT * FROM full_menu;");
        ArrayList<FullMenuItem> items = new ArrayList<>();
        while (data.next()) {
            FullMenuItem item = new FullMenuItem();
            item.setId(data.getInt(1));
            item.setItemName(data.getString(2));
            item.setItemType(data.getString(3));
            item.setMilkType(data.getString(4));
            item.setTemperature(data.getString(5));
            item.setPriceInside(data.getFloat(6));
            item.setPriceOutside(data.getFloat(7));
            item.setTotalLeft(data.getInt(8));
            item.setDescription(data.getString(9));
            items.add(item);
        }
        data.close();
        ObservableList<FullMenuItem> fullMenuItems = FXCollections.observableArrayList(items);
        fullMenuTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullMenuTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        fullMenuTableType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
        fullMenuTableMilkType.setCellValueFactory(new PropertyValueFactory<>("MilkType"));
        fullMenuTableTemp.setCellValueFactory(new PropertyValueFactory<>("Temperature"));
        fullMenuTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
        fullMenuTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
        fullMenuTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
        fullMenuDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        fullMenuTable.setItems(fullMenuItems);
    }
}
