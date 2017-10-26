package orderAndProducts;
import java.util.*;

public class OrderLine
{
    private int quantity;
    private double price;
    private Product product;

    public OrderLine(Product product, int quantity, double price)
    {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Product getProduct()
    {
        return this.product;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public double getPrice()
    {
        return this.price;
    }
}
