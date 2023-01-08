package management;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

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
    private TableView<?> fullMenuTable;

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

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }
}
