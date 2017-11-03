import CommandLineInterface.*;
import customer.*;
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
            orderApplication.productCatalogue.printCatalogue();
            Order userOrder = new Order();
            orderApplication.createOrder(userOrder);
            String mainMenuString = (
                "Lab5Main:\n" +
                "1 - Print the order.\n" +
                "2 - Print the product catalogue.\n" +
                "3 - Modify the order.\n" +
                "4 - Get the final cost of the order.\n" +
                "-1 - Exit the program.\n");
            CommandLineInterface cli = new CommandLineInterface(mainMenuString);

            while(true)
            {
                System.out.format("\n");
                int selection = cli.getMainMenuNumber();
                String name = "";
                int quantity = 0;
                switch(selection)
                {
                    case 1:
                        System.out.format("PROG: Printing Order.\n");
                        userOrder.printOrder();
                        break;
                    case 2:
                        System.out.format("PROG: Printing Catalogue.\n");
                        orderApplication.productCatalogue.printCatalogue();
                        break;
                    case 3:
                        System.out.format("PROG: Modify the order.\n");
                        name = cli.getLine("Enter the name of the product you would like to add");
                        quantity = cli.getInt("How many quantities do you want to add? (Negatives to delete)");
                        Product findProduct = orderApplication.productCatalogue.getProductByName(name);
                        if (findProduct == null)
                        {
                             System.out.format("ERROR: Product does not exists in the catalogue.\n");
                        }
                        else
                        {
                             System.out.format("Product exists in the catalogue.\n");
                             userOrder.addProduct(findProduct, quantity);
                        }
                        break;
                    case 4:
                        System.out.format("PROG: Get the final cost of the order.\n");
                        double orderAmount = userOrder.calculatePrice();
                        System.out.format("This order has a grand total of $%f\n", orderAmount);
                        break;
                    case -1:
                        System.exit(0);
                        break;
                    default:
                        System.out.format("PROG: Undefined action. Please try again.\n");
                        break;
                }
            }
        }
        else
        {
            System.out.println("Failed to import a product catalogue.");
        }
    }

    public boolean createOrder(Order order)
    /*
        Precondition: This method assumes order is initially empty;
    */
    {
        System.out.println("PROG: Calling createOrder.");
        Customer newCustomer = new Customer(
            "Vincent Chan",
            "Regina, Sask",
            (float)0,
            (float)0.3);
        order.setCustomer(newCustomer);
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
        return true;
    }

    private boolean importCatalogue()
    {
        System.out.println("PROG: Calling importCatalogue.");
        boolean returnValue = true;
        String line = "";
        try
        {
            Scanner in = new Scanner(Paths.get("catalogueData.csv"));
            while (in.hasNextLine())
            {
                line = in.nextLine();
                //System.out.println(line);
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
