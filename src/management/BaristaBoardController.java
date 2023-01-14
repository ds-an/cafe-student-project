package management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import objects.items.*;
import objects.processes.Order;
import objects.processes.TakingOrder;
import utility.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class BaristaBoardController {
    @FXML
    private AnchorPane creditCardPane;
    @FXML
    private TextField creditCardField;
    @FXML
    private Button acceptPaymert;

    @FXML
    private Button addItem;

    @FXML
    private Button removeItem;

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
    private TextField clientId;

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

    private int baristaId;

    private int ordertotal;

    private Stage stage;

    private Scene scene;

    private Parent root;

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void setCurrentDate() {
        currentDate.setText("The date today is: " + LocalDate.now().toString());
    }

    public void populateTables() throws SQLException {
        {
            ResultSet data = Database.getData("SELECT * FROM drinkscoffee;");
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
            data.close();
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
            ResultSet data = Database.getData("SELECT * FROM drinkstea;");
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
            data.close();
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
            ResultSet data = Database.getData("SELECT * FROM drinksother;");
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
            data.close();
            ObservableList<OtherDrink> otherDrinks = FXCollections.observableArrayList(items);
            drinkTableID.setCellValueFactory(new PropertyValueFactory<>("id"));
            drinkTableName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            drinkTablePriceIns.setCellValueFactory(new PropertyValueFactory<>("PriceInside"));
            drinkTablePriceOut.setCellValueFactory(new PropertyValueFactory<>("PriceOutside"));
            drinkTableTotalLeft.setCellValueFactory(new PropertyValueFactory<>("TotalLeft"));
            drinksTable.setItems(otherDrinks);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM food;");
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
            data.close();
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
            fullMenuTable.setItems(fullMenuItems);
        }
        {
            ResultSet data = Database.getData("SELECT OrderId, PaymentStatus FROM orders;");
            ArrayList<Order> items = new ArrayList<>();
            while (data.next()) {
                Order item = new Order();
                item.setOrderId(data.getInt(1));
                item.setOrderPaymentStatus(data.getString(2));
                items.add(item);
            }
            data.close();
            items.sort(Comparator.comparing(Order :: getOrderId).reversed());
            ObservableList<Order> orders = FXCollections.observableArrayList(items);
            paymentsTableOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            paymentTableOrderStatus.setCellValueFactory(new PropertyValueFactory<>("OrderPaymentStatus"));
            paymentTable.setItems(orders);
        }
    }

    public void addToOrder(ActionEvent event) throws SQLException {
        TakingOrder item = new TakingOrder();
        int itemid = Integer.parseInt(itemId.getText());
            for (TakingOrder itemorder : orderList) {
                if (itemorder.getItemId() == itemid) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "This item is already in the order.", ButtonType.CLOSE);
                    alert.show();
                    throw new SQLException("'The item is already in the order' - prevention of incorrect db input.");
                }
            }
        item.setItemId(itemid);
        ResultSet getitemname = Database.getData(String.format("SELECT ItemName FROM full_menu WHERE ItemId = %d;", itemid));
        item.setItemName(getitemname.getString(1));
        getitemname.close();
        ResultSet getitemtype = Database.getData(String.format("SELECT ItemType FROM full_menu WHERE ItemId = %d;", itemid));
        item.setItemType(getitemtype.getString(1));
        getitemtype.close();
        float itemactualprice = 0;
        if (toGoToggle.isSelected()) {
            ResultSet getitemprice = Database.getData(String.format("SELECT PriceOutside FROM full_menu WHERE ItemId = %d;", itemid));
            item.setItemPrice(getitemprice.getInt(1));
            itemactualprice = getitemprice.getInt(1);
            getitemprice.close();
        }else {
            ResultSet getitemprice = Database.getData(String.format("SELECT PriceInside FROM full_menu WHERE ItemId = %d;", itemid));
            item.setItemPrice(getitemprice.getInt(1));
            itemactualprice = getitemprice.getInt(1);
            getitemprice.close();
        }
        item.setItemQuantity(Integer.parseInt(itemAmount.getText()));
        ResultSet getitemtotalleftrs = Database.getData(String.format("SELECT TotalLeft FROM full_menu WHERE ItemId = %d;", itemid));
        int itemtotalleft = getitemtotalleftrs.getInt(1);
        getitemtotalleftrs.close();
        if (!(clientId.getText().isEmpty()) && (item.getItemId() >= 100 && item.getItemId() < 200)) {
            int clientid = Integer.parseInt(clientId.getText());
            String query = String.format("SELECT CoffeeOrders FROM clients WHERE ClientId = %d;", clientid);
            ResultSet clientcupsrs = Database.getData(query);
            int clientcups = clientcupsrs.getInt(1);
            clientcupsrs.close();
            int itemquant = Integer.parseInt(itemAmount.getText());
            for (int i = 0; i < itemquant; i++) {
                clientcups++;
                if (clientcups % 10 == 0) {
                    item.setItemPrice((item.getItemPrice() * item.getItemQuantity()) - itemactualprice);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "The client gets one cup of coffee for free!");
                    alert.showAndWait();
                }
            }
            String query1 = String.format("UPDATE clients SET CoffeeOrders = %d WHERE ClientId = %d",
                    clientcups, clientid);
            Database.inputData(query1);
        }
        if (itemtotalleft - item.getItemQuantity() < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "This item is out of stock.", ButtonType.CLOSE);
            alert.show();
        } else {
            orderList.add(item);
            ObservableList<TakingOrder> order = FXCollections.observableArrayList(orderList);
            orderTableItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
            orderTableItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            orderTableItemType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            orderTableItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
            orderTableItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
            orderTable.setItems(order);
            ordertotal = 0;
            for (int i = 0; i < orderList.size(); i++) {
                ordertotal += orderList.get(i).getItemPrice();
            }
            totalText.setText("Total: " + Integer.toString(ordertotal) + "$");
            toGoToggle.setDisable(true);
            clientId.setDisable(true);
        }
    }

    public void populateComboBoxes() {
        ObservableList paymentoptions = FXCollections.observableArrayList(paymentOptions);
        paymentOption.setItems(paymentoptions);
    }

    public void switchPanes(ActionEvent event) {
        if (paymentOption.getValue() == "Credit card") {
            creditCardPane.setVisible(true);
        } else {
            creditCardPane.setVisible(false);
        }
    }

    public void removeFromOrder(ActionEvent event) throws SQLException {
        if (!(clientId.getText().isEmpty()) && (orderList.get(orderList.size() - 1).getItemId() >= 100 &&
                orderList.get(orderList.size() - 1).getItemId() < 200)) {
            int clientid = Integer.parseInt(clientId.getText());
            String query = String.format("SELECT CoffeeOrders FROM clients WHERE ClientId = %d;", clientid);
            ResultSet clientcupsrs = Database.getData(query);
            int clientcups = clientcupsrs.getInt(1);
            clientcupsrs.close();
            int itemquant = orderList.get(orderList.size() - 1).getItemQuantity();
            String query1 = String.format("UPDATE clients SET CoffeeOrders = %d WHERE ClientId = %d",
                    clientcups - itemquant, clientid);
            Database.inputData(query1);
        }
        orderList.remove(orderList.size() - 1);
        ObservableList<TakingOrder> order = FXCollections.observableArrayList(orderList);
        orderTableItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
        orderTableItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        orderTableItemType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
        orderTableItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
        orderTableItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
        orderTable.setItems(order);
        ordertotal = 0;
        for (int i = 0; i < orderList.size(); i++) {
            ordertotal += orderList.get(i).getItemPrice();
        }
        totalText.setText("Total: " + Integer.toString(ordertotal) + "$");
    }

    public void takeOrder(ActionEvent event) throws SQLException {
        Order resultingorder = new Order();
        String orderdetails = "The order is: ";
        if (clientId.getText().isEmpty()) {
            resultingorder.setClientId(0);
        } else {
            int clientid = Integer.parseInt(clientId.getText());
            resultingorder.setClientId(clientid);
            //
//            String query = String.format("SELECT CoffeeOrders FROM clients WHERE ClientId = %d;", clientid);
//            ResultSet clientcupsrs = Database.getData(query);
//            int clientcups = clientcupsrs.getInt(1);
//            clientcupsrs.close();
//            int countercoffee = 0;
//            for (TakingOrder item : orderList) {
//                if ((item.getItemId() >= 100 && item.getItemId() < 200)) {
//                    countercoffee += item.getItemQuantity();
//                }
//            }
//            for (int i = 0; i < countercoffee; i++) {
//                clientcups++;
//                if (clientcups % 10 == 0)
//
//            }
        }
        resultingorder.setBaristaId(baristaId);
        resultingorder.setOrderTotal(ordertotal);
        resultingorder.setOrderPaymentStatus("Unpayed");
        if (toGoToggle.isSelected()) {
            resultingorder.setOrderType("To Go");
        } else {
            resultingorder.setOrderType("Inside");
        }
        resultingorder.setOrderTimestamp(null);
        for (TakingOrder item: orderList) {
            orderdetails += item.getItemName() + " x" + item.getItemQuantity() + ", ";
            if (item.getItemId() >= 100 && item.getItemId() < 200) {
                String query = String.format("UPDATE drinkscoffee SET TotalLeft = TotalLeft - %d WHERE DrinkId = %d",
                        item.getItemQuantity(), item.getItemId());
                Database.inputData(query);
            }else if (item.getItemId() >= 200 && item.getItemId() < 300) {
                String query = String.format("UPDATE drinkstea SET TotalLeft = TotalLeft - %d WHERE DrinkId = %d",
                        item.getItemQuantity(), item.getItemId());
                Database.inputData(query);
            }else if (item.getItemId() >= 300 && item.getItemId() < 400) {
                String query = String.format("UPDATE drinksother SET TotalLeft = TotalLeft - %d WHERE DrinkId = %d",
                        item.getItemQuantity(), item.getItemId());
                Database.inputData(query);
            }else if (item.getItemId() >= 400) {
                String query = String.format("UPDATE food SET TotalLeft = TotalLeft - %d WHERE FoodId = %d",
                        item.getItemQuantity(), item.getItemId());
                Database.inputData(query);
            }
        }
        String orderdetailsf = orderdetails.substring(0, orderdetails.length() - 1) + ".";
        resultingorder.setOrderDetails(orderdetailsf);
        resultingorder.insertOrder();
        orderList.clear();
        clientId.setText("");
        itemAmount.setText("1");
        itemId.setText("");
        totalText.setText("Total: 0$");
        orderTable.getItems().clear();
        populateTables();
        toGoToggle.setDisable(false);
        clientId.setDisable(false);
//        {
//            ResultSet data = Database.getData("SELECT OrderId, PaymentStatus FROM orders;");
//            ArrayList<Order> items = new ArrayList<>();
//            while (data.next()) {
//                Order item = new Order();
//                item.setOrderId(data.getInt(1));
//                item.setOrderPaymentStatus(data.getString(2));
//                items.add(item);
//            }
//            data.close();
//            items.sort(Comparator.comparing(Order :: getOrderId).reversed());
//            ObservableList<Order> orders = FXCollections.observableArrayList(items);
//            paymentsTableOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
//            paymentTableOrderStatus.setCellValueFactory(new PropertyValueFactory<>("OrderPaymentStatus"));
//            paymentTable.setItems(orders);
//        }
    }

    public void toGoToggleSwitch(ActionEvent event) throws SQLException {
        if (toGoToggle.isSelected()) {
            for (TakingOrder item : orderList) {
                ResultSet getitemprice = Database.getData(String.format("SELECT PriceOutside FROM full_menu WHERE ItemId = %d;", item.getItemId()));
                item.setItemPrice(getitemprice.getInt(1));
                getitemprice.close();
            }
            ObservableList<TakingOrder> order = FXCollections.observableArrayList(orderList);
            orderTableItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
            orderTableItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            orderTableItemType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            orderTableItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
            orderTableItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
            orderTable.setItems(order);
            ordertotal = 0;
            for (int i = 0; i < orderList.size(); i++) {
                ordertotal += orderList.get(i).getItemPrice();
            }
            totalText.setText("Total: " + Integer.toString(ordertotal) + "$");
            orderTable.refresh();
        } else if (!(toGoToggle.isSelected())) {
            for (TakingOrder item : orderList) {
                ResultSet getitemprice = Database.getData(String.format("SELECT PriceInside FROM full_menu WHERE ItemId = %d;", item.getItemId()));
                item.setItemPrice(getitemprice.getInt(1));
                getitemprice.close();
            }
            ObservableList<TakingOrder> order = FXCollections.observableArrayList(orderList);
            orderTableItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
            orderTableItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
            orderTableItemType.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
            orderTableItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
            orderTableItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
            orderTable.setItems(order);
            ordertotal = 0;
            for (int i = 0; i < orderList.size(); i++) {
                ordertotal += orderList.get(i).getItemPrice();
            }
            totalText.setText("Total: " + Integer.toString(ordertotal) + "$");
            orderTable.refresh();
        }
    }

    public void getDetails(ActionEvent event) throws SQLException {
        int orderid = Integer.parseInt(orderId.getText());
        String query = String.format("SELECT OrderDetails FROM orders WHERE OrderId = %d", orderid);
        ResultSet orderdetailsset = Database.getData(query);
        String orderdetails = orderdetailsset.getString(1);
        orderdetailsset.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, orderdetails, ButtonType.CLOSE);
        alert.show();
    }

    public void acceptPayment(ActionEvent event) throws SQLException {
            int orderid = Integer.parseInt(orderId.getText());
            if (paymentOption.getValue() == "Credit card") {
                if (creditCardField.getText().length() == 16) {
                    String querytotal = String.format("SELECT Total from orders WHERE OrderId = %d", orderid);
                    ResultSet totalrs = Database.getData(querytotal);
                    float total = totalrs.getInt(1);
                    totalrs.close();
                    String topay = String.format("To pay: %.1f$", total);
                    Alert alerttotal = new Alert(Alert.AlertType.CONFIRMATION, topay);
                    Optional<ButtonType> result = alerttotal.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        try {
                            String query = String.format("INSERT INTO payment (OrderId, PaymentType) VALUES (%d, '%s');",
                                    orderid, paymentOption.getValue());
                            String query1 = String.format("UPDATE orders SET PaymentStatus = 'Payed' WHERE OrderId = %d;", orderid);
                            Database.inputData(query);
                            Database.inputData(query1);
                        } catch (SQLException sqlException) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "This order has already been payed.", ButtonType.CLOSE);
                            alert.showAndWait();
                            throw sqlException;
                        }
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment successful!", ButtonType.OK);
                        alert.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        throw new SQLException("The user refused to pay.");
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter valid credit card information.", ButtonType.CLOSE);
                    alert.show();
                }
            } else if (paymentOption.getValue() == "Cash") {
                String querytotal = String.format("SELECT Total from orders WHERE OrderId = %d", orderid);
                ResultSet totalrs = Database.getData(querytotal);
                float total = totalrs.getInt(1);
                totalrs.close();
                String topay = String.format("To pay: %.1f$", total);
                Alert alerttotal = new Alert(Alert.AlertType.CONFIRMATION, topay);
                Optional<ButtonType> result = alerttotal.showAndWait();
                if (result.get() == ButtonType.OK) {
                    try {
                        String query = String.format("INSERT INTO payment (OrderId, PaymentType) VALUES (%d, '%s');",
                                orderid, paymentOption.getValue());
                        String query1 = String.format("UPDATE orders SET PaymentStatus = 'Payed' WHERE OrderId = %d;", orderid);
                        Database.inputData(query);
                        Database.inputData(query1);
                    } catch (SQLException sqlException) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This order has already been payed.", ButtonType.CLOSE);
                        alert.showAndWait();
                        throw sqlException;
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment successful!", ButtonType.OK);
                    alert.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    throw new SQLException("The user refused to pay.");
                }
//                String query = String.format("INSERT INTO payment (OrderId, PaymentType) VALUES (%d, '%s');",
//                        orderid, paymentOption.getValue());
//                String query1 = String.format("UPDATE orders SET PaymentStatus = 'Payed' WHERE OrderId = %d;", orderid);
//                Database.inputData(query);
//                Database.inputData(query1);
//                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment successful!", ButtonType.OK);
//                alert.show();
            } else if (paymentOption.getValue() == "PayPal") {
                String querytotal = String.format("SELECT Total from orders WHERE OrderId = %d", orderid);
                ResultSet totalrs = Database.getData(querytotal);
                float total = totalrs.getInt(1);
                totalrs.close();
                String topay = String.format("To pay: %.1f$", total);
                Alert alerttotal = new Alert(Alert.AlertType.CONFIRMATION, topay);
                Optional<ButtonType> result = alerttotal.showAndWait();
                if (result.get() == ButtonType.OK) {
                    try {
                        String query = String.format("INSERT INTO payment (OrderId, PaymentType) VALUES (%d, '%s');",
                                orderid, paymentOption.getValue());
                        String query1 = String.format("UPDATE orders SET PaymentStatus = 'Payed' WHERE OrderId = %d;", orderid);
                        Database.inputData(query);
                        Database.inputData(query1);
                    } catch (SQLException sqlException) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This order has already been payed.", ButtonType.CLOSE);
                        alert.showAndWait();
                        throw sqlException;
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment successful!", ButtonType.OK);
                    alert.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    throw new SQLException("The user refused to pay.");
                }
//                String query = String.format("INSERT INTO payment (OrderId, PaymentType) VALUES (%d, '%s');",
//                        orderid, paymentOption.getValue());
//                String query1 = String.format("UPDATE orders SET PaymentStatus = 'Payed' WHERE OrderId = %d;", orderid);
//                Database.inputData(query);
//                Database.inputData(query1);
//                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment successful!", ButtonType.OK);
//                alert.show();
            } else if (paymentOption.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please choose a payment option.", ButtonType.CLOSE);
                alert.show();
            }
            {
                ResultSet data = Database.getData("SELECT OrderId, PaymentStatus FROM orders;");
                ArrayList<Order> items = new ArrayList<>();
                while (data.next()) {
                    Order item = new Order();
                    item.setOrderId(data.getInt(1));
                    item.setOrderPaymentStatus(data.getString(2));
                    items.add(item);
                }
                data.close();
                items.sort(Comparator.comparing(Order::getOrderId).reversed());
                ObservableList<Order> orders = FXCollections.observableArrayList(items);
                paymentsTableOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
                paymentTableOrderStatus.setCellValueFactory(new PropertyValueFactory<>("OrderPaymentStatus"));
                paymentTable.setItems(orders);
            }
    }

    public void logOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBaristaId(int baristaId) {
        this.baristaId = baristaId;
    }

//    public static void main(String[] args) {
//        System.out.println(69 / 10);
//        System.out.println(1);
//    }
}

