package orderAndProducts;
import java.util.*;

public class OrderLine
{
    private int quantity;
    private double price;
    private Product product;

    public OrderLine(Product product, int quantity)
    {
        this.quantity = quantity;
        this.product = product;
        this.calculatePrice();
    }

    public void calculatePrice()
    {
        this.price = this.product.getPrice() * this.quantity;
    }

    public void incrementQuantity(int quantity)
    {
        this.quantity += quantity;
        this.calculatePrice();
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

    public void printOrderLine()
    {
        System.out.format("Product = %s|Quantity = %d|Price = $%f\n",
            this.product.getName(), this.quantity, this.price);
    }
}
