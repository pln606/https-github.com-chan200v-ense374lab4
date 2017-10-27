import orderAndProducts.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class OrderApplication
{
    private ProductCatalogue productCatalogue = new ProductCatalogue();

    public static void main(String[] args)
    {
        OrderApplication orderApplication = new OrderApplication();
        if (orderApplication.importCatalogue())
        {
            System.out.println("Successfully imported a product catalogue.");
            Order userOrder = new Order();
            orderApplication.createOrder(userOrder);


        }
        else
        {
            System.out.println("Failed to import a product catalogue.");
        }
    }

    public boolean createOrder(Order order)
    {
        return true;
    }

    private boolean importCatalogue()
    {
        boolean returnValue = true;
        String line = "";
        try
        {
            Scanner in = new Scanner(Paths.get("catalogueData.csv"));
            while (in.hasNextLine())
            {
                line = in.nextLine();
                System.out.println(line);
                String[] tokens = line.split("\\|");
                //productCatalogue.add();
            }
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            returnValue = false;
        }
        return returnValue;
    }
}
