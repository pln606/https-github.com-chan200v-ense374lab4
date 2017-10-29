package orderAndProducts;
import customer.*;
import java.util.*;

public class Order
{
    private Date dateReceived;
    private double price;
    private int orderInt;
    private ArrayList<OrderLine> listOfOrderLines = new ArrayList<>();
    private Customer customer;

    public Order()
    {
        this.dateReceived = new Date();
        this.price = 0.0;
        this.orderInt = 0;
        this.customer = null;
    }

    public Order(Date dateReceived, double price, int orderInt)
    {
        this.dateReceived = dateReceived;
        this.price = price;
        this.orderInt = orderInt;
        this.customer = null;
    }

    public Order(Date dateReceived, double price, int orderInt, Customer customer)
    {
        this.dateReceived = dateReceived;
        this.price = price;
        this.orderInt = orderInt;
        this.customer = customer;
    }

    public boolean addProduct(Product product, int quantity)
    {
        if (product == null)
        {
            return false;
        }
        else
        {
            boolean isDone = false;
            ListIterator<OrderLine> iterator = this.listOfOrderLines.listIterator();
            while(iterator.hasNext())
            {
                OrderLine currentOrderLine = iterator.next();
                if (product == currentOrderLine.getProduct())
                {
                    currentOrderLine.incrementQuantity(quantity);
                    isDone = true;
                }
            }
            if (!isDone)
            {
                OrderLine newOrderLine = new OrderLine(product, quantity);
                listOfOrderLines.add(newOrderLine);
            }
        }
        return true;
    }

    public Date getDateReceived()
    {
        return this.dateReceived;
    }

    public double calculatePrice()
    {
        System.out.format("PROG: Calling calculatePrice\n");
        ListIterator<OrderLine> iterator = this.listOfOrderLines.listIterator();
        this.price = 0.0;
        while(iterator.hasNext())
        {
            OrderLine currentOrderLine = iterator.next();
            this.price += currentOrderLine.getPrice();
        }
        return this.price;
    }

    public void printOrder()
    {
        System.out.format("Printing current order\n");
        ListIterator<OrderLine> iterator = this.listOfOrderLines.listIterator();
        if (iterator.hasNext())
        {
            while(iterator.hasNext())
            {
                OrderLine currentOrderLine = iterator.next();
                currentOrderLine.printOrderLine();
            }
        }
        else
        {
            System.out.format("Empty order\n");
        }
    }
}
