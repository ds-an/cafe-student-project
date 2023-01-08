package management;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class BaristaBoardController {

    @FXML
    private Button acceptPaymert;

    @FXML
    private Button addItem;

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
    private Label currentDate;

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
    private Button getReceipt;

    @FXML
    private TextField itemAmount;

    @FXML
    private TextField itemId;

    @FXML
    private Button logOut;

    @FXML
    private MenuItem menuOrderAlphabetical;

    @FXML
    private MenuItem menuOrderOriginal;

    @FXML
    private MenuItem menuOrderPriceDec;

    @FXML
    private MenuItem menuOrderPriceInc;

    @FXML
    private MenuItem menuOrderReverseAlphabetical;

    @FXML
    private MenuButton orderByMenu;

    @FXML
    private TextField orderId;

    @FXML
    private TableView<?> orderTable;

    @FXML
    private TableColumn<?, ?> orderTableItemId;

    @FXML
    private TableColumn<?, ?> orderTableItemName;

    @FXML
    private TableColumn<?, ?> orderTableItemPrice;

    @FXML
    private TableColumn<?, ?> orderTableItemQuantity;

    @FXML
    private TableColumn<?, ?> orderTableItemType;

    @FXML
    private ComboBox<?> paymentOption;

    @FXML
    private TableView<?> paymentTable;

    @FXML
    private TableColumn<?, ?> paymentTableOrderStatus;

    @FXML
    private TableColumn<?, ?> paymentsTableOrderId;

    @FXML
    private Button takeOrder;

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
    private RadioButton toGoToggle;

    @FXML
    private Text totalText;

    @FXML
    private Label welcomeText;

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void setCurrentDate() {
        currentDate.setText("The date today is: " + LocalDate.now().toString());
    }

}

