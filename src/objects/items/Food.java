package objects.items;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Food extends Item{
    public Food() {
        super();
    }

    public Food(String itemName, String itemType, float priceInside, float priceOutside, int totalLeft) {
        super(itemName, itemType, priceInside, priceOutside, totalLeft);
    }

    @Override
    public void insertItem() throws SQLException {
        String query = String.format("INSERT INTO food VALUES (NULL, '%s', '%s', %f, %f, %d, '%s')",
                super.getItemName(), super.getItemType(),
                super.getPriceInside(), super.getPriceOutside(), super.getTotalLeft(), super.getDescription());
        Database.inputData(query);
    }
}
