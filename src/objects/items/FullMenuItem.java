package objects.items;

import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

public class FullMenuItem extends Item{
    private SimpleStringProperty MilkType;
    private SimpleStringProperty Temperature;

    public FullMenuItem() {
        super();
        this.MilkType = new SimpleStringProperty();
        this.Temperature = new SimpleStringProperty();
    }

    @Override
    public void insertItem() throws SQLException {

    }

    public FullMenuItem(String itemName, String itemType, String milkType,
                       String temperature, float priceInside, float priceOutside, int totalLeft) {
        super(itemName, itemType, priceInside, priceOutside, totalLeft);
        this.MilkType = new SimpleStringProperty(milkType);
        this.Temperature = new SimpleStringProperty(temperature);
    }

    public String getMilkType() {
        return MilkType.get();
    }

    public SimpleStringProperty milkTypeProperty() {
        return MilkType;
    }

    public void setMilkType(String milkType) {
        this.MilkType.set(milkType);
    }

    public String getTemperature() {
        return Temperature.get();
    }

    public SimpleStringProperty temperatureProperty() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        this.Temperature.set(temperature);
    }
}
