package management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import objects.items.*;
import objects.processes.Order;
import objects.processes.Payment;
import objects.users.Barista;
import utility.Database;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminBoardController {

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
    private Button addItemButton;

    @FXML
    private Button changeShiftEmployee;

    @FXML
    private Button clearFieldsEmployee;

    @FXML
    private Button getDescriptionButton;

    @FXML
    private ComboBox<?> coffeeMilkType;

    @FXML
    private TextField coffeeName;

    @FXML
    private TextField orderIdField;

    @FXML
    private TextField coffeePriceIns;

    @FXML
    private TextField coffeePriceOut;

    @FXML
    private TextField itemIdField;

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
    private TableView<OtherDrink> drinksTable;

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
    private TableView<Barista> employeesTable;

    @FXML
    private Button fireEmployee;

    @FXML
    private TextField foodName;

    @FXML
    private TextField foodPriceIns;

    @FXML
    private TextField foodPriceOut;

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
    private TableView<Order> ordersTable;

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
    private TableView<Payment> paymentsTable;

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
    private ComboBox<?> teaTemp;

    @FXML
    private TableColumn<?, ?> teaTotalLeft;

    @FXML
    private ComboBox<?> teaType;

    @FXML
    private Button updateItemButton;

    @FXML
    private Text todaysIncomeText;

    @FXML
    private Text totalncomeText;

    @FXML
    private Text numberOfOrdersText;

    @FXML
    private Label welcomeText;

    @FXML
    private TextArea coffeeDescription;

    @FXML
    private TextArea drinkDescription;

    @FXML
    private TextArea teaDescription;

    @FXML
    private TextArea foodDescription;

    @FXML
    private AreaChart<?, ?> incomeChart;

    private Stage stage;

    private Scene scene;

    private Parent root;

    private String[] itemtypes = {"Coffee", "Tea", "Drinks", "Food"};

    private String[] ctype = {"Arabica", "Robusta", "Excelsa", "Liberica"};

    private String[] ttype = {"Black", "Green", "Herbal"};

    private String[] mtype = {"Coconut", "Almond", "Soy", "Cow"};

    private String[] tempetature = {"Hot", "Cold"};

    private String[] ftype = {"Sandwich", "Pastry", "Salad"};

    private String[] eshifts = {"Morning", "Evening"};

    public void setNameLabel(String username) {
        welcomeText.setText("Welcome, " + username);
    }

    public void setCurrentDate() {
        currentDate.setText("The date today is: " + LocalDate.now().toString());
    }

    public void switchForm(ActionEvent event) {
        if(event.getSource() == dashBoardButton) {
            dashBoardPane.setVisible(true);
            itemsPane.setVisible(false);
            employeesPane.setVisible(false);
        }else if(event.getSource() == itemsButton) {
            dashBoardPane.setVisible(false);
            itemsPane.setVisible(true);
            employeesPane.setVisible(false);
        }else if(event.getSource() == employeesButton) {
            dashBoardPane.setVisible(false);
            itemsPane.setVisible(false);
            employeesPane.setVisible(true);
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

    public void populateItemTypeBox() {
        ArrayList<String> items = new ArrayList<>();
        for (String type : itemtypes) {
            items.add(type);
        }
        ObservableList itemsTypes = FXCollections.observableArrayList(items);
        itemType.setItems(itemsTypes);
    }

    public void populateComboBoxes() {
        ArrayList<ComboBox<?>> allcomboboxes =
                new ArrayList<>(Arrays.asList(coffeeType, coffeeMilkType, coffeeTemp,
                        teaType, teaMilkType, teaTemp,
                        drinkTemp,
                        foodType,
                        employeeShift));
        ArrayList<String[]> things =
                new ArrayList<>(Arrays.asList(ctype, mtype, tempetature,
                        ttype, mtype, tempetature,
                        tempetature,
                        ftype,
                        eshifts));
        for (int i = 0; i < things.size(); i++) {
            ArrayList<String> items = new ArrayList<>();
            for (String type : things.get(i)) {
                items.add(type);
            }
            ObservableList itemsTypes = FXCollections.observableArrayList(items);
            allcomboboxes.get(i).setItems(itemsTypes);
        }
    }

    public void populateTables() throws SQLException {
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
            ResultSet data = Database.getData("SELECT * FROM baristas");
            ArrayList<Barista> items = new ArrayList<>();
            while (data.next()) {
                Barista barista = new Barista();
                barista.setId(data.getInt(1));
                barista.setFirstName(data.getString(2));
                barista.setLastName(data.getString(3));
                barista.setShift(data.getString(4));
                barista.setPhoneNumber(data.getString(5));
                barista.setEmail(data.getString(6));
                items.add(barista);
            }
            ObservableList<Barista> otherbaristas = FXCollections.observableArrayList(items);
            employeeTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
            employeeTableFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            employeeTableLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            employeeTableShift.setCellValueFactory(new PropertyValueFactory<>("Shift"));
            employeeTablePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
            employeeTableEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            employeesTable.setItems(otherbaristas);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM orders");
            ArrayList<Order> items = new ArrayList<>();
            while (data.next()) {
                Order order = new Order();
                order.setOrderId(data.getInt(1));
                order.setClientId(data.getInt(2));
                order.setBaristaId(data.getInt(3));
                order.setOrderType(data.getString(4));
                order.setOrderTimestamp(data.getString(5));
                order.setOrderTotal(data.getFloat(6));
                order.setOrderPaymentStatus(data.getString(7));
                order.setOrderDetails(data.getString(8));
                items.add(order);
            }
            ObservableList<Order> otherorders = FXCollections.observableArrayList(items);
            orderTableOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            orderTableClientId.setCellValueFactory(new PropertyValueFactory<>("ClientId"));
            orderTableBaristaId.setCellValueFactory(new PropertyValueFactory<>("BaristaId"));
            orderTableTimestamp.setCellValueFactory(new PropertyValueFactory<>("OrderTimestamp"));
            orderTableTotal.setCellValueFactory(new PropertyValueFactory<>("OrderTotal"));
            orderTablePaymentStatus.setCellValueFactory(new PropertyValueFactory<>("OrderPaymentStatus"));
            ordersTable.setItems(otherorders);
        }
        {
            ResultSet data = Database.getData("SELECT * FROM payment");
            ArrayList<Payment> items = new ArrayList<>();
            while (data.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(data.getInt(1));
                payment.setOrderId(data.getInt(2));
                payment.setPaymentType(data.getString(3));
                payment.setPaymentTimestamp(data.getString(4));
                items.add(payment);
            }
            ObservableList<Payment> otherpayments = FXCollections.observableArrayList(items);
            paymentTableId.setCellValueFactory(new PropertyValueFactory<>("PaymentId"));
            paymentTableOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            paymentTableType.setCellValueFactory(new PropertyValueFactory<>("PaymentType"));
            paymentTableTimestamp.setCellValueFactory(new PropertyValueFactory<>("PaymentTimestamp"));;
            paymentsTable.setItems(otherpayments);
        }
    }

    public void switchItemsChoiceView(ActionEvent event) {
        if (itemType.getValue() == "Coffee") {
            paneChoiceCoffee.setVisible(true);
            paneChoiceTea.setVisible(false);
            paneChoiceDrinks.setVisible(false);
            paneChoiceFood.setVisible(false);
        }else if(itemType.getValue() == "Tea") {
            paneChoiceCoffee.setVisible(false);
            paneChoiceTea.setVisible(true);
            paneChoiceDrinks.setVisible(false);
            paneChoiceFood.setVisible(false);
        }else if(itemType.getValue() == "Drinks") {
            paneChoiceCoffee.setVisible(false);
            paneChoiceTea.setVisible(false);
            paneChoiceDrinks.setVisible(true);
            paneChoiceFood.setVisible(false);
        }else if(itemType.getValue() == "Food") {
            paneChoiceCoffee.setVisible(false);
            paneChoiceTea.setVisible(false);
            paneChoiceDrinks.setVisible(false);
            paneChoiceFood.setVisible(true);
        }
    }

    public void populateBasicInfo() throws SQLException {
        {
            String query = "SELECT COUNT(PaymentId) FROM payment;";
            ResultSet numberofordersrs = Database.getData(query);
            int numberoforders = numberofordersrs.getInt(1);
            numberofordersrs.close();
            numberOfOrdersText.setText(Integer.toString(numberoforders));
        }
        {
            float todaysincome = 0;
            String query = "SELECT sum(Total) from orders WHERE date(Timestamp) = date(current_date) AND PaymentStatus = 'Payed';";
            ResultSet todaysincomers = Database.getData(query);
            todaysincome = todaysincomers.getInt(1);
            todaysincomers.close();
            todaysIncomeText.setText(Float.toString(todaysincome));
        }
        {
            float totalincome = 0;
            String query = "SELECT sum(Total) from orders WHERE PaymentStatus = 'Payed';";
            ResultSet totalincomers = Database.getData(query);
            totalincome = totalincomers.getInt(1);
            totalincomers.close();
            totalncomeText.setText(Float.toString(totalincome));
        }
        {
            XYChart.Series chart = new XYChart.Series();
            String query = "SELECT date(Timestamp), sum(Total) FROM orders GROUP BY date(Timestamp) ORDER BY Timestamp ASC LIMIT 10;";
            ResultSet chartdatars = Database.getData(query);
            while (chartdatars.next()) {
                chart.getData().add(new XYChart.Data(chartdatars.getString(1), chartdatars.getInt(2)));
            }
            incomeChart.getData().add(chart);
        }
    }

    public void getDetailsOrder(ActionEvent event) throws SQLException {
        int orderid = Integer.parseInt(orderIdField.getText());
        String query = String.format("SELECT OrderDetails FROM orders WHERE OrderId = %d", orderid);
        ResultSet orderdetailsset = Database.getData(query);
        String orderdetails = orderdetailsset.getString(1);
        orderdetailsset.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, orderdetails, ButtonType.CLOSE);
        alert.show();
    }

    public void getDetailsPayment(ActionEvent event) throws SQLException {
        String query1 = String.format("SELECT OrderID FROM payment WHERE PaymentId = %d;", Integer.parseInt(paymentID.getText()));
        ResultSet irderidrs = Database.getData(query1);
        int orderid = irderidrs.getInt(1);
        irderidrs.close();
        String query2 = String.format("SELECT OrderDetails, Total FROM orders WHERE OrderId = 1439 AND PaymentStatus = 'Payed';", orderid);
        ResultSet orderdetailsset2 = Database.getData(query2);
        orderdetailsset2.next();
        String orderdetailsstart = orderdetailsset2.getString(1);
        String orderdetails = orderdetailsstart.substring(14);
        int paymenttotal = orderdetailsset2.getInt(2);
        String paymentdetails = String.format("The customer payed %d$ for the order of %s", paymenttotal, orderdetails);
        orderdetailsset2.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, paymentdetails, ButtonType.CLOSE);
        alert.show();
    }

    public void clearItemFields() {
        coffeeName.clear();
        coffeePriceIns.clear();
        coffeePriceOut.clear();
        coffeeDescription.clear();
        teaName.clear();
        teaPriceIns.clear();
        teaPriceOut.clear();
        teaDescription.clear();
        drinkName.clear();
        drinkPriceIns.clear();
        drinkPriceOut.clear();
        drinkDescription.clear();
        foodName.clear();
        foodPriceIns.clear();
        foodPriceOut.clear();
        foodDescription.clear();
    }

    public void removeItem() throws SQLException {
        int itemid = Integer.parseInt(itemIdField.getText());
        if (itemid >= 100 && itemid < 200) {
            String query = String.format("DELETE FROM drinkscoffee WHERE DrinkId = %d",
                     itemid);
            Database.inputData(query);
        }else if (itemid >= 200 && itemid < 300) {
            String query = String.format("DELETE FROM drinkstea WHERE DrinkId = %d",
                     itemid);
            Database.inputData(query);
        }else if (itemid >= 300 && itemid < 400) {
            String query = String.format("DELETE FROM drinksother WHERE DrinkId = %d",
                     itemid);
            Database.inputData(query);
        }else if (itemid >= 400) {
            String query = String.format("DELETE FROM food WHERE FoodId = %d",
                     itemid);
            Database.inputData(query);
        }
        populateTables();
    }

    public void addItem() throws SQLException {
        if (itemType.getValue() == "Coffee") {
            CoffeeDrink drink = new CoffeeDrink();
            drink.setItemName(coffeeName.getText());
            drink.setItemType(coffeeType.getValue().toString());
            drink.setMilkType(coffeeMilkType.getValue().toString());
            drink.setTemperature(coffeeTemp.getValue().toString());
            drink.setPriceInside(Integer.parseInt(coffeePriceIns.getText()));
            drink.setPriceOutside(Integer.parseInt(coffeePriceOut.getText()));
            drink.setTotalLeft(100);
            drink.setDescription(coffeeDescription.getText());
            drink.insertItem();
            clearItemFields();
            populateTables();
        }else if(itemType.getValue() == "Tea") {
            TeaDrink drink = new TeaDrink();
            drink.setItemName(teaName.getText());
            drink.setItemType(teaType.getValue().toString());
            drink.setMilkType(teaMilkType.getValue().toString());
            drink.setTemperature(teaTemp.getValue().toString());
            drink.setPriceInside(Integer.parseInt(teaPriceIns.getText()));
            drink.setPriceOutside(Integer.parseInt(teaPriceOut.getText()));
            drink.setTotalLeft(100);
            drink.setDescription(teaDescription.getText());
            drink.insertItem();
            clearItemFields();
            populateTables();
        }else if(itemType.getValue() == "Drinks") {
            OtherDrink drink = new OtherDrink();
            drink.setItemName(drinkName.getText());
            drink.setItemType(null);
            drink.setPriceInside(Integer.parseInt(drinkPriceIns.getText()));
            drink.setPriceOutside(Integer.parseInt(drinkPriceOut.getText()));
            drink.setTotalLeft(100);
            drink.setDescription(drinkDescription.getText());
            drink.insertItem();
            clearItemFields();
            populateTables();
        }else if(itemType.getValue() == "Food") {
            Food food = new Food();
            food.setItemName(foodName.getText());
            food.setItemType(foodType.getValue().toString());
            food.setPriceInside(Integer.parseInt(foodPriceIns.getText()));
            food.setPriceOutside(Integer.parseInt(foodPriceOut.getText()));
            food.setTotalLeft(100);
            food.setDescription(foodDescription.getText());
            food.insertItem();
            clearItemFields();
            populateTables();
        }
    }

    public void updateItemPrice() throws SQLException {
        if (itemType.getValue() == "Coffee") {
            String query = String.format("UPDATE drinkscoffee SET PriceInside = %f, PriceOutside = %f WHERE DrinkId = %d",
                    Float.parseFloat(coffeePriceIns.getText()), Float.parseFloat(coffeePriceOut.getText()),
                    Integer.parseInt(itemIdField.getText()));
            Database.inputData(query);
            clearItemFields();
            populateTables();
        }else if(itemType.getValue() == "Tea") {
            String query = String.format("UPDATE drinkstea SET PriceInside = %f, PriceOutside = %f WHERE DrinkId = %d",
                    Float.parseFloat(teaPriceIns.getText()), Float.parseFloat(teaPriceOut.getText()),
                    Integer.parseInt(itemIdField.getText()));
            Database.inputData(query);
            clearItemFields();
            populateTables();
        }else if(itemType.getValue() == "Drinks") {
            String query = String.format("UPDATE drinksother SET PriceInside = %f, PriceOutside = %f WHERE DrinkId = %d",
                    Float.parseFloat(drinkPriceIns.getText()), Float.parseFloat(drinkPriceOut.getText()),
                    Integer.parseInt(itemIdField.getText()));
            Database.inputData(query);
            clearItemFields();
            populateTables();
        }else if(itemType.getValue() == "Food") {
            String query = String.format("UPDATE food SET PriceInside = %f, PriceOutside = %f WHERE DrinkId = %d",
                    Float.parseFloat(foodPriceIns.getText()), Float.parseFloat(foodPriceOut.getText()),
                    Integer.parseInt(itemIdField.getText()));
            Database.inputData(query);
            clearItemFields();
            populateTables();
        }
    }

    public void getItemDescription() throws SQLException {
        int itemid = Integer.parseInt(itemIdField.getText());
        String query = String.format("SELECT Description FROM full_menu WHERE ItemId = %d", itemid);
        ResultSet itemdetailsset = Database.getData(query);
        String itemdetails = itemdetailsset.getString(1);
        itemdetailsset.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, itemdetails, ButtonType.CLOSE);
        alert.show();
    }

    public void clearFieldsEmployee() {
        employeeId.clear();
        employeeFirstName.clear();
        employeeLastName.clear();
        employeePhoneNumber.clear();
        employeeEmail.clear();
    }

    public void hireEmployee() throws SQLException {
        Barista barista = new Barista();
        barista.setFirstName(employeeFirstName.getText());
        barista.setLastName(employeeLastName.getText());
        barista.setShift(employeeShift.getValue().toString());
        barista.setPhoneNumber(employeePhoneNumber.getText());
        barista.setEmail(employeeEmail.getText());
        barista.insertBarista();
        clearFieldsEmployee();
        populateTables();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Please enter the employee's login.");
        dialog.showAndWait();
        String login = dialog.getEditor().getText();
        TextInputDialog dialog2 = new TextInputDialog();
        dialog2.setHeaderText("Please enter the employee's password.");
        dialog2.showAndWait();
        String password = dialog2.getEditor().getText();
        String query = String.format("INSERT INTO access VALUES ((SELECT max(BaristaId) FROM baristas), '%s', '%s');",
                login, password);
        Database.inputData(query);
    }

    public void fireEmployee() throws SQLException {
        String query = String.format("DELETE FROM baristas WHERE BaristaId = %d", Integer.parseInt(employeeId.getText()));
        Database.inputData(query);
        String query2 = String.format("DELETE FROM access WHERE AccessId = %d", Integer.parseInt(employeeId.getText()));
        Database.inputData(query2);
        clearFieldsEmployee();
        populateTables();
    }

    public void changeShiftEmployee() throws SQLException {
        String query = String.format("UPDATE baristas SET Shift = '%s' WHERE BaristaId = %d", employeeShift.getValue().toString(),
                Integer.parseInt(employeeId.getText()));
        Database.inputData(query);
        clearFieldsEmployee();
        populateTables();
    }

    /*
    public static void main(String[] args) throws SQLException {
        int orderid = 1436;
        String query = String.format("SELECT OrderDetails, Total FROM orders WHERE OrderId = %d AND PaymentStatus = 'Payed';", orderid);
        ResultSet orderdetailsset = Database.getData(query);
        String orderdetailsstart = orderdetailsset.getString(1);
        String orderdetails = orderdetailsstart.substring(14);
        int paymenttotal = orderdetailsset.getInt(2);
        String paymentdetails = String.format("The customer payed %d$ for the order of %s", paymenttotal, orderdetails);
        orderdetailsset.close();
        System.out.println(paymentdetails);
        int totalincome = 0;
        String query = String.format("SELECT OrderId FROM payment;");
        ResultSet orderidsrs = Database.getData(query);
        ArrayList<Integer> orderids = new ArrayList<>();
        while (orderidsrs.next()) {
            orderids.add(orderidsrs.getInt(1));
        }
        for (Integer orderid : orderids) {
            String query1 = String.format("SELECT Total FROM orders WHERE OrderId = %d;",
                    1437);
            ResultSet ordertotalrs = Database.getData(query1);
            int ordertotal = ordertotalrs.getInt(1);
            totalincome += ordertotal;
            ordertotalrs.close();
        }
        orderidsrs.close();
        System.out.println(totalincome);
        int totalincome = 0;
        String query1 = String.format("SELECT Total FROM orders WHERE OrderId = 1436;");
        ResultSet ordertotalrs = Database.getData(query1);
        float ordertotal = ordertotalrs.getFloat(1);
        totalincome += ordertotal;
        ordertotalrs.close();
        System.out.println(totalincome);
        String query = "SELECT Timestamp FROM payment;";
        ResultSet numberofordersrs = Database.getData(query);
        Date datetoday = new Date(System.currentTimeMillis());
        Date numberoforders = numberofordersrs.getDate(1);
        numberofordersrs.close();
        System.out.println(numberoforders);
        System.out.println(datetoday == n);
    }

     */

}
