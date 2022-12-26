package objects.items;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;
public class TeaDrink extends Item{
    private String MilkType;
    private String Temperature;

    public TeaDrink() {
        super();
        this.MilkType = null;
        this.Temperature = null;
    }

    public TeaDrink(String itemName, String itemType, String milkType,
                       String temperature, float priceInside, float priceOutside, int totalLeft) {
        super(itemName, itemType, priceInside, priceOutside, totalLeft);
        this.MilkType = milkType;
        this.Temperature = temperature;
    }

    @Override
    public void insertItem() throws SQLException {
        String query = String.format("INSERT INTO drinkstea VALUES (NULL, '%s', '%s', '%s', '%s', '%f', '%f', '%d')",
                super.getItemName(), super.getItemType(), this.MilkType, this.Temperature,
                super.getPriceInside(), super.getPriceOutside(), super.getTotalLeft());
        Database.inputData(query);
    }
}
