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
        System.out.println("The product catalogue has the following.");
        for (int i = 0; i < productCatalogue.getProducts().size(); i++)
        {
            productCatalogue.getProducts().get(i).printValues();
        }
        order.printOrder();
        order.addProduct(productCatalogue.getProductByName("8GB RAM"), 1);
        order.addProduct(productCatalogue.getProductByName("8GB RAM"), 1);
        order.addProduct(productCatalogue.getProductByName("Monitor"), 2);
        order.addProduct(productCatalogue.getProductByName("VGA connector"), 1);
        order.addProduct(productCatalogue.getProductByName("DVI connector"), 1);
        order.addProduct(productCatalogue.getProductByName("Graphics Card"), 1);
        order.addProduct(productCatalogue.getProductByName("128-core processor"), 1);
        order.addProduct(productCatalogue.getProductByName("Motherboard version 2"), 1);
        order.addProduct(productCatalogue.getProductByName("Wired Mouse"), 1);
        order.addProduct(productCatalogue.getProductByName("Wired Keyboard"), 1);
        order.addProduct(productCatalogue.getProductByName("PC Case"), 1);
        order.printOrder();
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
                int productID = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                float price = Float.parseFloat(tokens[2]);
                Product newProduct = new Product(name, price, productID);
                productCatalogue.getProducts().add(newProduct);
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
