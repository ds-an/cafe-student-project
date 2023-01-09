package objects.items;


import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

public abstract class Item {
    private SimpleIntegerProperty id;
    private SimpleStringProperty ItemName;
    private SimpleStringProperty ItemType;
    private SimpleFloatProperty PriceInside;
    private SimpleFloatProperty PriceOutside;
    private SimpleIntegerProperty TotalLeft;

    public Item() {
        this.id = new SimpleIntegerProperty();
        this.ItemName = new SimpleStringProperty();
        this.ItemType = new SimpleStringProperty();
        this.PriceInside = new SimpleFloatProperty();
        this.PriceOutside = new SimpleFloatProperty();
        this.TotalLeft = new SimpleIntegerProperty();
    }

    public Item(String itemName, String itemType, float priceInside, float priceOutside, int totalLeft) {
        this.id = null;
        this.ItemName = new SimpleStringProperty(itemName);
        this.ItemType = new SimpleStringProperty(itemType);
        this.PriceInside = new SimpleFloatProperty(priceInside);
        this.PriceOutside = new SimpleFloatProperty(priceOutside);
        this.TotalLeft = new SimpleIntegerProperty(totalLeft);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public float getPriceInside() {
        return PriceInside.get();
    }

    public SimpleFloatProperty priceInsideProperty() {
        return PriceInside;
    }

    public void setPriceInside(float priceInside) {
        this.PriceInside.set(priceInside);
    }

    public float getPriceOutside() {
        return PriceOutside.get();
    }

    public SimpleFloatProperty priceOutsideProperty() {
        return PriceOutside;
    }

    public void setPriceOutside(float priceOutside) {
        this.PriceOutside.set(priceOutside);
    }

    public int getTotalLeft() {
        return TotalLeft.get();
    }

    public SimpleIntegerProperty totalLeftProperty() {
        return TotalLeft;
    }

    public void setTotalLeft(int totalLeft) {
        this.TotalLeft.set(totalLeft);
    }

    //    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getItemName() {
//        return ItemName;
//    }
//
//    public void setItemName(String itemName) {
//        ItemName = itemName;
//    }
//
//    public String getItemType() {
//        return ItemType;
//    }
//
//    public void setItemType(String itemType) {
//        ItemType = itemType;
//    }
//
//    public float getPriceInside() {
//        return PriceInside;
//    }
//
//    public void setPriceInside(float priceInside) {
//        PriceInside = priceInside;
//    }
//
//    public float getPriceOutside() {
//        return PriceOutside;
//    }
//
//    public void setPriceOutside(float priceOutside) {
//        PriceOutside = priceOutside;
//    }
//
//    public int getTotalLeft() {
//        return TotalLeft;
//    }
//
//    public void setTotalLeft(int totalLeft) {
//        TotalLeft = totalLeft;
//    }

    public abstract void insertItem() throws SQLException;
}
