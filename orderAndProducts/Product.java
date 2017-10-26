package orderAndProducts;
import java.util.*;

public class Product
{
    private String name;
    private double price;
    private int productId;

    public Product(String name, double price, int productId)
    {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    private String getName()
    {
        return this.name;
    }

    private double getPrice()
    {
        return this.price;
    }

    private int getProductId()
    {
        return this.productId;
    }
}
