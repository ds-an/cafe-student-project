package objects.processes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {
    private SimpleIntegerProperty OrderId;
    private SimpleIntegerProperty ClientId;
    private SimpleIntegerProperty BaristaId;
    private SimpleStringProperty OrderType;
    private SimpleStringProperty OrderTimestamp;
    private SimpleFloatProperty OrderTotal;
    private SimpleStringProperty OrderPaymentStatus;
    private SimpleStringProperty OrderDetails;

    public Order() {
        this.OrderId = new SimpleIntegerProperty();
        this.ClientId = new SimpleIntegerProperty();
        this.BaristaId = new SimpleIntegerProperty();
        this.OrderType = new SimpleStringProperty();
        this.OrderTimestamp = new SimpleStringProperty();
        this.OrderTotal = new SimpleFloatProperty();
        this.OrderPaymentStatus = new SimpleStringProperty();
        this.OrderDetails = new SimpleStringProperty();
    }

    public Order(int clientId, int baristaId, String orderType, String orderTimestamp,
                      float orderTotal, String orderPaymentStatus, String orderDetails) {
        this.OrderId = new SimpleIntegerProperty();
        this.ClientId = new SimpleIntegerProperty(clientId);
        this.BaristaId = new SimpleIntegerProperty(baristaId);
        this.OrderType = new SimpleStringProperty(orderType);
        this.OrderTimestamp = new SimpleStringProperty(orderTimestamp);
        this.OrderTotal = new SimpleFloatProperty(orderTotal);
        this.OrderPaymentStatus = new SimpleStringProperty(orderPaymentStatus);
        this.OrderDetails = new SimpleStringProperty(orderDetails);
    }

    public int getOrderId() {
        return OrderId.get();
    }

    public SimpleIntegerProperty orderIdProperty() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        this.OrderId.set(orderId);
    }

    public int getClientId() {
        return ClientId.get();
    }

    public SimpleIntegerProperty clientIdProperty() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        this.ClientId.set(clientId);
    }

    public int getBaristaId() {
        return BaristaId.get();
    }

    public SimpleIntegerProperty baristaIdProperty() {
        return BaristaId;
    }

    public void setBaristaId(int baristaId) {
        this.BaristaId.set(baristaId);
    }

    public String getOrderType() {
        return OrderType.get();
    }

    public SimpleStringProperty orderTypeProperty() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        this.OrderType.set(orderType);
    }

    public String getOrderTimestamp() {
        return OrderTimestamp.get();
    }

    public SimpleStringProperty orderTimestampProperty() {
        return OrderTimestamp;
    }

    public void setOrderTimestamp(String orderTimestamp) {
        this.OrderTimestamp.set(orderTimestamp);
    }

    public float getOrderTotal() {
        return OrderTotal.get();
    }

    public SimpleFloatProperty orderTotalProperty() {
        return OrderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.OrderTotal.set(orderTotal);
    }

    public String getOrderPaymentStatus() {
        return OrderPaymentStatus.get();
    }

    public SimpleStringProperty orderPaymentStatusProperty() {
        return OrderPaymentStatus;
    }

    public void setOrderPaymentStatus(String orderPaymentStatus) {
        this.OrderPaymentStatus.set(orderPaymentStatus);
    }

    public String getOrderDetails() {
        return OrderDetails.get();
    }

    public SimpleStringProperty orderDetailsProperty() {
        return OrderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.OrderDetails.set(orderDetails);
    }

}
