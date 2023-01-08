package management;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class AdminBoardController {

    @FXML
    private Button addItemButton;

    @FXML
    private Button changeShiftEmployee;

    @FXML
    private Button clearFieldsEmployee;

    @FXML
    private Button clearItemsButton;

    @FXML
    private ComboBox<?> coffeeMilkType;

    @FXML
    private TextField coffeeName;

    @FXML
    private TextField coffeePriceIns;

    @FXML
    private TextField coffeePriceOut;

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
    private ComboBox<?> coffeeTemp;

    @FXML
    private TableColumn<?, ?> coffeeTotalLeft;

    @FXML
    private ComboBox<?> coffeeType;

    @FXML
    private Label currentDate;

    @FXML
    private Button dashBoardButton;

    @FXML
    private AnchorPane dashBoardPane;

    @FXML
    private TextField drinkName;

    @FXML
    private TextField drinkPriceIns;

    @FXML
    private TextField drinkPriceOut;

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
    private ComboBox<?> drinkTemp;

    @FXML
    private TableView<?> drinksTable;

    @FXML
    private TextField employeeEmail;

    @FXML
    private TextField employeeFirstName;

    @FXML
    private TextField employeeId;

    @FXML
    private TextField employeeLastName;

    @FXML
    private TextField employeePhoneNumber;

    @FXML
    private ComboBox<?> employeeRank;

    @FXML
    private ComboBox<?> employeeShift;

    @FXML
    private TableColumn<?, ?> employeeTableEmail;

    @FXML
    private TableColumn<?, ?> employeeTableFirstName;

    @FXML
    private TableColumn<?, ?> employeeTableId;

    @FXML
    private TableColumn<?, ?> employeeTableLastName;

    @FXML
    private TableColumn<?, ?> employeeTablePhoneNumber;

    @FXML
    private TableColumn<?, ?> employeeTableRank;

    @FXML
    private TableColumn<?, ?> employeeTableShift;

    @FXML
    private Button employeesButton;

    @FXML
    private AnchorPane employeesPane;

    @FXML
    private TableView<?> employeesTable;

    @FXML
    private Button fireEmployee;

    @FXML
    private TextField foodName;

    @FXML
    private TextField foodPriceIns;

    @FXML
    private TextField foodPriceOut;

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
    private ComboBox<?> foodType;

    @FXML
    private AnchorPane getReceipt;

    @FXML
    private Button hireEmployee;

    @FXML
    private Tab incomeChartTab;

    @FXML
    private ComboBox<?> itemType;

    @FXML
    private Button itemsButton;

    @FXML
    private AnchorPane itemsPane;

    @FXML
    private Button logOutButton;

    @FXML
    private Tab numberOfOrdersTab;

    @FXML
    private TableView<?> ordersTable;

    @FXML
    private TableColumn<?, ?> orderTableBaristaId;

    @FXML
    private TableColumn<?, ?> orderTableClientId;

    @FXML
    private TableColumn<?, ?> orderTableDrinkId;

    @FXML
    private TableColumn<?, ?> orderTableFoodId;

    @FXML
    private TableColumn<?, ?> orderTableOrderId;

    @FXML
    private TableColumn<?, ?> orderTablePaymentStatus;

    @FXML
    private TableColumn<?, ?> orderTableTimestamp;

    @FXML
    private TableColumn<?, ?> orderTableTotal;

    @FXML
    private Tab ordersTab;

    @FXML
    private AnchorPane paneChoiceCoffee;

    @FXML
    private AnchorPane paneChoiceDrinks;

    @FXML
    private AnchorPane paneChoiceFood;

    @FXML
    private AnchorPane paneChoiceTea;

    @FXML
    private TextField paymentID;

    @FXML
    private TableColumn<?, ?> paymentTableId;

    @FXML
    private TableColumn<?, ?> paymentTableOrderId;

    @FXML
    private TableColumn<?, ?> paymentTableTimestamp;

    @FXML
    private TableColumn<?, ?> paymentTableType;

    @FXML
    private Tab paymentsTab;

    @FXML
    private TableView<?> paymentsTable;

    @FXML
    private Button promoteEmployee;

    @FXML
    private Button removeItemButton;

    @FXML
    private ComboBox<?> teaMilkType;

    @FXML
    private TextField teaName;

    @FXML
    private TextField teaPriceIns;

    @FXML
    private TextField teaPriceOut;

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
    private ComboBox<?> teaTemp;

    @FXML
    private TableColumn<?, ?> teaTotalLeft;

    @FXML
    private ComboBox<?> teaType;

    @FXML
    private Button updateItemButton;

    @FXML
    private Label welcomeText;

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void setCurrentDate() {
        currentDate.setText("The date today is: " + LocalDate.now().toString());
    }

    pub
}
