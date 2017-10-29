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
            int comparision = name.compareTo(iterator.next().getName());
            if (comparision == 0)
            {
                returnProduct = iterator.next();
                isDone = true;
            }
            else if(comparision > 0)
            {
                isDone = false;
            }
        }
        return returnProduct;
    }
}
