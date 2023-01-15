package objects.items;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherDrink extends Item{
    public OtherDrink() {
        super();
    }

    public OtherDrink(String itemName, String itemType, float priceInside, float priceOutside, int totalLeft) {
        super(itemName, itemType, priceInside, priceOutside, totalLeft);
    }

    @Override
    public void insertItem() throws SQLException {
        String query = String.format("INSERT INTO drinksother VALUES (NULL, '%s', %f, %f, %d, '%s')",
                super.getItemName(), super.getPriceInside(), super.getPriceOutside(), super.getTotalLeft(), super.getDescription());
        Database.inputData(query);
    }
}
