package objects.items;
import javafx.beans.property.SimpleStringProperty;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;
public class TeaDrink extends Item{
    private SimpleStringProperty MilkType;
    private SimpleStringProperty Temperature;

    public TeaDrink() {
        super();
        this.MilkType = new SimpleStringProperty();
        this.Temperature = new SimpleStringProperty();
    }

    public TeaDrink(String itemName, String itemType, String milkType,
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

    @Override
    public void insertItem() throws SQLException {
        String query = String.format("INSERT INTO drinkstea VALUES (NULL, '%s', '%s', '%s', '%s', %f, %f, %d, '%s')",
                super.getItemName(), super.getItemType(), this.getMilkType(), this.getTemperature(),
                super.getPriceInside(), super.getPriceOutside(), super.getTotalLeft(), super.getDescription());
        Database.inputData(query);
    }
}
