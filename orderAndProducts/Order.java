package orderAndProducts;
import java.util.*;

public class Order
{
    private Date dateReceived;
    private double price;
    private int orderInt;
    private List<OrderLine> listOfOrderLines = new ArrayList<>();

    public Order()
    {
        this.dateReceived = new Date();
        this.price = 0.0;
        this.orderInt = 0;
    }

    public Order(Date dateReceived, double price, int orderInt)
    {
        this.dateReceived = dateReceived;
        this.price = price;
        this.orderInt = orderInt;
    }

    public Date getDateReceived()
    {
        return this.dateReceived;
    }

    public double calculatePrice()
    {
        return this.price;
    }
}
