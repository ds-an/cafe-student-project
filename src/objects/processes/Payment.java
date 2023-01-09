package objects.processes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Payment {
        private SimpleIntegerProperty PaymentId;
        private SimpleIntegerProperty OrderId;
        private SimpleStringProperty PaymentType;
        private SimpleStringProperty PaymentTimestamp;

        public Payment() {
            this.PaymentId = new SimpleIntegerProperty();
            this.OrderId = new SimpleIntegerProperty();
            this.PaymentType = new SimpleStringProperty();
            this.PaymentTimestamp = new SimpleStringProperty();
        }

        public Payment(int orderId, String paymentType, String paymentTimestamp) {
            this.PaymentId = new SimpleIntegerProperty();
            this.OrderId = new SimpleIntegerProperty(orderId);
            this.PaymentType = new SimpleStringProperty(paymentType);
            this.PaymentTimestamp = new SimpleStringProperty(paymentTimestamp);
        }

    public int getPaymentId() {
        return PaymentId.get();
    }

    public SimpleIntegerProperty paymentIdProperty() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        this.PaymentId.set(paymentId);
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

    public String getPaymentType() {
        return PaymentType.get();
    }

    public SimpleStringProperty paymentTypeProperty() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        this.PaymentType.set(paymentType);
    }

    public String getPaymentTimestamp() {
        return PaymentTimestamp.get();
    }

    public SimpleStringProperty paymentTimestampProperty() {
        return PaymentTimestamp;
    }

    public void setPaymentTimestamp(String paymentTimestamp) {
        this.PaymentTimestamp.set(paymentTimestamp);
    }
}
