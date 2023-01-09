package objects.processes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TakingOrder {
    private SimpleIntegerProperty ItemId;
    private SimpleStringProperty ItemName;
    private SimpleStringProperty ItemType;
    private SimpleFloatProperty ItemPrice;
    private SimpleIntegerProperty ItemQuantity;

    public TakingOrder() {
        this.ItemId = new SimpleIntegerProperty();
        this.ItemName = new SimpleStringProperty();
        this.ItemType = new SimpleStringProperty();
        this.ItemPrice = new SimpleFloatProperty();
        this.ItemQuantity = new SimpleIntegerProperty();
    }

    public TakingOrder(String itemName, String itemType, float itemPrice, int itemQuantity) {
        this.ItemId = new SimpleIntegerProperty();
        this.ItemName = new SimpleStringProperty(itemName);
        this.ItemType = new SimpleStringProperty(itemType);
        this.ItemPrice = new SimpleFloatProperty(itemPrice);
        this.ItemQuantity = new SimpleIntegerProperty(itemQuantity);
    }

    public int getItemId() {
        return ItemId.get();
    }

    public SimpleIntegerProperty itemIdProperty() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        this.ItemId.set(itemId);
    }

    public String getItemName() {
        return ItemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        this.ItemName.set(itemName);
    }

    public String getItemType() {
        return ItemType.get();
    }

    public SimpleStringProperty itemTypeProperty() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        this.ItemType.set(itemType);
    }

    public float getItemPrice() {
        return ItemPrice.get();
    }

    public SimpleFloatProperty itemPriceProperty() {
        return ItemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.ItemPrice.set(itemPrice);
    }

    public int getItemQuantity() {
        return ItemQuantity.get();
    }

    public SimpleIntegerProperty itemQuantityProperty() {
        return ItemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.ItemQuantity.set(itemQuantity);
    }
}
