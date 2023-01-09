package management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import objects.items.*;
import objects.processes.Order;
import objects.processes.TakingOrder;
import utility.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BaristaBoardController {

    @FXML
    private Button acceptPaymert;

    @FXML
    private Button addItem;

    @FXML
    private TableView<CoffeeDrink> coffeeTable;

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
    private TableView<OtherDrink> drinksTable;

    @FXML
    private TableView<Food> foodTable;

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
    private TableView<TakingOrder> orderTable;

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
    private TableView<Order> paymentTable;

    @FXML
    private TableColumn<?, ?> paymentTableOrderStatus;

    @FXML
    private TableColumn<?, ?> paymentsTableOrderId;

    @FXML
    private Button takeOrder;

    @FXML
    private TableView<TeaDrink> teaTable;

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

    private String[] paymentOptions = {"Credit card", "PayPal", "Cash"};

    private ArrayList<TakingOrder> orderList = new ArrayList<>();

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void setCurrentDate() {
        currentDate.setText("The date today is: " + LocalDate.now().toString());
    }

    public void populateTables() throws SQLException {
        {
            ResultSet data = Database.getData("SELECT * FROM drinkscoffee");
            ArrayList<CoffeeDrink> items = new ArrayList<>();
            while (data.next()) {
                CoffeeDrink drink = new CoffeeDrink();
                drink.setId(data.getInt(1));
                drink.setItemName(data.getString(2));
                drink.setItemType(data.getString(3));
                drink.setMilkType(data.getString(4));
                drink.setTemperature(data.getString(5));
                drink.setPriceInside(data.getFloat(6));
                drink.setPriceOutside(data.getFloat(7));
                drink.setTotalLeft(data.getInt(8));
                items.add(drink);
            }
            ObservableList<CoffeeDrink> coffeeDrinks = FXCollections.observableArrayList(items);
            coffeeTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
            coffeeTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            coffeeTableType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            coffeeTableMilkType.setCellValueFactory(new PropertyValueFactory<>("MilkType"));
            coffeeTableTemp.setCellValueFactory(new PropertyValueFactory<>("Temperature"));
            coffeeTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
            coffeeTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
            coffeeTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
            coffeeTable.setItems(coffeeDrinks);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM drinkstea");
            ArrayList<TeaDrink> items = new ArrayList<>();
            while (data.next()) {
                TeaDrink drink = new TeaDrink();
                drink.setId(data.getInt(1));
                drink.setItemName(data.getString(2));
                drink.setItemType(data.getString(3));
                drink.setMilkType(data.getString(4));
                drink.setTemperature(data.getString(5));
                drink.setPriceInside(data.getFloat(6));
                drink.setPriceOutside(data.getFloat(7));
                drink.setTotalLeft(data.getInt(8));
                items.add(drink);
            }
            ObservableList<TeaDrink> teaDrinks = FXCollections.observableArrayList(items);
            teaTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
            teaTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            teaTableType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            teaTableMilkType.setCellValueFactory(new PropertyValueFactory<>("MilkType"));
            teaTableTemp.setCellValueFactory(new PropertyValueFactory<>("Temperature"));
            teaTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
            teaTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
            teaTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
            teaTable.setItems(teaDrinks);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM drinksother");
            ArrayList<OtherDrink> items = new ArrayList<>();
            while (data.next()) {
                OtherDrink drink = new OtherDrink();
                drink.setId(data.getInt(1));
                drink.setItemName(data.getString(2));
                drink.setItemType(null);
                drink.setPriceInside(data.getFloat(3));
                drink.setPriceOutside(data.getFloat(4));
                drink.setTotalLeft(data.getInt(5));
                items.add(drink);
            }
            ObservableList<OtherDrink> otherDrinks = FXCollections.observableArrayList(items);
            drinkTableID.setCellValueFactory(new PropertyValueFactory<>("id"));
            drinkTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            drinkTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
            drinkTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
            drinkTableTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
            drinksTable.setItems(otherDrinks);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM food");
            ArrayList<Food> items = new ArrayList<>();
            while (data.next()) {
                Food food = new Food();
                food.setId(data.getInt(1));
                food.setItemName(data.getString(2));
                food.setItemType(data.getString(3));
                food.setPriceInside(data.getFloat(4));
                food.setPriceOutside(data.getFloat(5));
                food.setTotalLeft(data.getInt(6));
                items.add(food);
            }
            ObservableList<Food> otherfoods = FXCollections.observableArrayList(items);
            foodTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
            foodTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            foodTableType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            foodTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
            foodTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
            foodTableTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
            foodTable.setItems(otherfoods);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM full_menu");
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
                items.add(item);
            }
            ObservableList<FullMenuItem> fullMenuItems = FXCollections.observableArrayList(items);
            fullMenuTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
            fullMenuTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            fullMenuTableType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            fullMenuTableMilkType.setCellValueFactory(new PropertyValueFactory<>("MilkType"));
            fullMenuTableTemp.setCellValueFactory(new PropertyValueFactory<>("Temperature"));
            fullMenuTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
            fullMenuTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
            fullMenuTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
            fullMenuTable.setItems(fullMenuItems);
        }
        {
            ResultSet data = Database.getData("SELECT OrderId, PaymentStatus FROM orders");
            ArrayList<Order> items = new ArrayList<>();
            while (data.next()) {
                Order item = new Order();
                item.setOrderId(data.getInt(1));
                item.setOrderPaymentStatus(data.getString(2));
                items.add(item);
            }
            ObservableList<Order> orders = FXCollections.observableArrayList(items);
            paymentsTableOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            paymentTableOrderStatus.setCellValueFactory(new PropertyValueFactory<>("OrderPaymentStatus"));
            paymentTable.setItems(orders);
        }
    }

    public void addToOrder(ActionEvent event) throws SQLException {
        TakingOrder item = new TakingOrder();
        int itemid = Integer.parseInt(itemId.getText());
        item.setItemId(itemid);
        item.setItemName(Database.getData(String.format("SELECT ItemName FROM full_menu WHERE ItemId = %d", itemid)).getString(1));
        item.setItemType(Database.getData(String.format("SELECT ItemType FROM full_menu WHERE ItemId = %d", itemid)).getString(1));
        if (toGoToggle.isSelected()) {
            item.setItemPrice(Database.getData(String.format("SELECT PriceOutside FROM full_menu WHERE ItemId = %d", itemid)).getInt(1));
        }else {
            item.setItemPrice(Database.getData(String.format("SELECT PriceInside FROM full_menu WHERE ItemId = %d", itemid)).getInt(1));
        }
        item.setItemQuantity(Integer.parseInt(itemAmount.getText()));
        orderList.add(item);
        ObservableList<TakingOrder> order = FXCollections.observableArrayList(orderList);
        orderTableItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
        orderTableItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        orderTableItemType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
        orderTableItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
        orderTableItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
        orderTable.setItems(order);
    }

}

