package objects.items;
import utility.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeDrink extends Item {
    private String MilkType;
    private String Temperature;

    public CoffeeDrink() {
        super();
        this.MilkType = null;
        this.Temperature = null;
    }

    public CoffeeDrink(String itemName, String itemType, String milkType,
                       String temperature, float priceInside, float priceOutside, int totalLeft) {
        super(itemName, itemType, priceInside, priceOutside, totalLeft);
        this.MilkType = milkType;
        this.Temperature = temperature;
    }

    @Override
    public void insertItem() throws SQLException {
        String query = String.format("INSERT INTO drinkscoffee VALUES (NULL, '%s', '%s', '%s', '%s', '%f', '%f', '%d')",
                super.getItemName(), super.getItemType(), this.MilkType, this.Temperature,
                super.getPriceInside(), super.getPriceOutside(), super.getTotalLeft());
        Database.inputData(query);
    }

    public static void main(String[] args) throws SQLException {
        CoffeeDrink coffeeDrink2 = new CoffeeDrink("Maciatto", "Arabica",
                "Almond", "Hot", 10, 12, 20);
        coffeeDrink2.insertItem();
        ResultSet rs = Database.getData("SELECT * FROM drinkscoffee WHERE DrinkID = 2;");
        System.out.println(rs.getString(2));
        System.out.println(rs.getInt(1));

//        CoffeeDrink coffeeDrink1 = new CoffeeDrink("Boba", "Green",
//                "Almond", "Hot", 10, 12, 20);
//        coffeeDrink1.insertItem();
    }
}