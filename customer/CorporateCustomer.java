package customer;
import java.util.*;

public class CorporateCustomer extends Customer
{
    private String contactName;

    public CorporateCustomer(
        String name,
        String address,
        float creditRating,
        float discountRating,
        String contactName)
    {
        super(name, address, creditRating, discountRating);
        this.contactName = contactName;
    }

    public String getContactName()
    {
        return this.contactName;
    }
}
