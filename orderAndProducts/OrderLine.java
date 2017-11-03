package orderAndProducts;
import java.util.*;

public class OrderLine
{
    private int quantity;
    private double price;
    private Product product;

    public OrderLine(Product product, int quantity)
    {
        System.out.format("PROG: Calling OrderLine() Constructor\n");
        this.quantity = quantity;
        this.product = product;
        this.calculatePrice();
    }

    public void calculatePrice()
    {
        System.out.format("PROG: Calling calculatePrice\n");
        this.price = this.product.getPrice() * this.quantity;
    }

    public void incrementQuantity(int quantity)
    {
        System.out.format("PROG: Calling incrementQuantity\n");
        this.quantity += quantity;
        if (this.quantity < 0)
        {
            this.quantity = 0;
        }
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
        System.out.format("PROG: Calling getPrice\n");
        return this.price;
    }

    public void printOrderLine()
    {
        System.out.format(
            "Product = %s|Unit Price = $%f| Quantity = %d|Price = $%f\n",
            this.product.getName(), this.product.getPrice(),
            this.quantity, this.price);
    }
}
