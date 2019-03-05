import java.util.ArrayList;

/**
 * A class used to store and deliver Products.
 * 
 * @author Jared Williams
 */
public class Slot
{
  public static final int SLOT_SIZE = 10;
  private ArrayList<Product> products;

  /**
   * Slot default constructor.
   */
  Slot()
  {
    products = new ArrayList<Product>();
  }

  /**
   * Slot constructor, fills the Slot with Product product.
   * 
   * @param product
   *          The Product in the slot
   */
  Slot(Product product)
  {
    products = new ArrayList<Product>();
    for (int x = 0; x < SLOT_SIZE; x++)
    {
      products.add(new Product(product.getName(), product.getCost(), product.getPrice()));
    }
  }

  /**
   * Fully loads the slot with product.
   * 
   * @param product
   *          The Product loaded in the slot
   * @return the number of product loaded
   */
  public int load(Product product)
  {
    int used = 0;
    while (products.size() < SLOT_SIZE)
    {
      used++;
      products.add(new Product(product.getName(), product.getCost(), product.getPrice()));
    }
    return used;
  }

  /**
   * Loads the slot with count products.
   * 
   * @param product
   *          The Product loaded in the slot
   * @param count
   *          The number of products to load
   * @return The number of products loaded
   */
  public int load(Product product, int count)
  {
    int used = 0;
    while (products.size() < SLOT_SIZE && used < count)
    {
      used++;
      products.add(new Product(product.getName(), product.getCost(), product.getPrice()));
    }
    return used;
  }

  /**
   * Peeks at the next Product in the Slot.
   * 
   * @return The next Product
   */
  public Product nextProduct()
  {
    if (products.size() == 0)
    {
      return null;
    }
    return products.get(0);
  }

  /**
   * Removes the next Product from the slot and returns it.
   * 
   * @return The next Product
   */
  public Product buyOne()
  {
    Product next = nextProduct();
    if (next != null)
    {
      products.remove(0);
    }
    return next;
  }

  /**
   * Returns a String representation of the Product.
   * 
   * @return The String
   */
  public String toString()
  {
    String returnVal = "SlotCount: " + products.size() + " of \n";
    for (int x = 0; x < products.size(); x++)
    {
      returnVal += products.get(x).toString() + "\n";
    }
    return returnVal.substring(0, returnVal.length() - 1);
  }
}
