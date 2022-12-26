package objects.items;


import java.sql.SQLException;

public abstract class Item {
    private String id;
    private String ItemName;
    private String ItemType;
    private float PriceInside;
    private float PriceOutside;
    private int TotalLeft;

    public Item() {
        this.id = null;
        this.ItemName = null;
        this.ItemType = null;
        this.PriceInside = 0;
        this.PriceOutside = 0;
        this.TotalLeft = 0;
    }

    public Item(String itemName, String itemType, float priceInside, float priceOutside, int totalLeft) {
        this.id = null;
        this.ItemName = itemName;
        this.ItemType = itemType;
        this.PriceInside = priceInside;
        this.PriceOutside = priceOutside;
        this.TotalLeft = totalLeft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public float getPriceInside() {
        return PriceInside;
    }

    public void setPriceInside(float priceInside) {
        PriceInside = priceInside;
    }

    public float getPriceOutside() {
        return PriceOutside;
    }

    public void setPriceOutside(float priceOutside) {
        PriceOutside = priceOutside;
    }

    public int getTotalLeft() {
        return TotalLeft;
    }

    public void setTotalLeft(int totalLeft) {
        TotalLeft = totalLeft;
    }

    public abstract void insertItem() throws SQLException;
}
