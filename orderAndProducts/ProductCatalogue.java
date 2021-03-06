package orderAndProducts;
import java.util.*;

public class ProductCatalogue
{
    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public ArrayList<Product> getProducts()
    {
        return listOfProducts;
    }

    public Product getProductByName(String name)
    {
        Product returnProduct = null;
        boolean isDone = false;
        ListIterator<Product> iterator = this.listOfProducts.listIterator();
        while(iterator.hasNext() && !isDone)
        {
            Product currentProduct = iterator.next();
            int comparision = name.compareTo(currentProduct.getName());
            if (comparision == 0)
            {
                returnProduct = currentProduct;
                isDone = true;
            }
            else if(comparision > 0)
            {
                isDone = false;
            }
        }
        return returnProduct;
    }

    public void printCatalogue()
    {
        System.out.println("The product catalogue has the following.");
        for (int i = 0; i < this.listOfProducts.size(); i++)
        {
            this.listOfProducts.get(i).printValues();
        }
    }
}
