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

    public String getName()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getProductId()
    {
        return this.productId;
    }
}
