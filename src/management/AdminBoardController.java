package management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import objects.processes.Order;
import objects.items.CoffeeDrink;
import objects.items.Food;
import objects.items.OtherDrink;
import objects.items.TeaDrink;
import objects.processes.Payment;
import objects.users.Barista;
import utility.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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
    private Label welcomeText;

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

}
