package customer;
import java.util.*;

public class Customer
{
    private String name;
    private String address;
    private float creditRating;
    private float discountRating;

    public Customer(
        String name,
        String address,
        float creditRating,
        float discountRating)
    {
        this.name = name;
        this.address = address;
        this.creditRating = creditRating;
        this.discountRating = discountRating;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public float getCreditRating()
    {
        return this.creditRating;
    }

    public float getDiscountRating()
    {
        return this.discountRating;
    }
}
