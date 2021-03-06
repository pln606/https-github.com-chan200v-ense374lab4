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
        System.out.format("PROG: Calling getPrice\n");
        return this.price;
    }

    public int getProductId()
    {
        return this.productId;
    }

    public void printValues()
    {
        System.out.format("ID = %d|Name = %s|Price = $%f\n",  this.productId, this.name, this.price);
    }
}
