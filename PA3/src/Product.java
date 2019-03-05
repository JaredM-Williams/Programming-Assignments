/**
 * An immutable class that stores a name, cost, and a price.
 * 
 * @author Jared Williams
 */
public class Product
{
  public static final int ROUND_PRICE = 25;
  private String name;
  private int cost;
  private int price;

  /**
   * Product default constructor.
   */
  Product()
  {
    this.name = "Generic";
    this.cost = ROUND_PRICE;
    this.price = ROUND_PRICE * 2;

  }

  /**
   * Product constructor.
   * 
   * @param name
   *          Product name
   * @param cost
   *          Product cost
   * @param price
   *          Product price
   * @throws IllegalArgumentException
   *           illegal argument.
   */
  Product(String name, int cost, int price) throws IllegalArgumentException
  {
    int newPrice = price;
    if (name == null || cost < 0 || newPrice < 0)
    {
      throw new IllegalArgumentException();
    }
    if (cost >= newPrice)
    {
      newPrice = cost + 1;
    }
    if (newPrice % ROUND_PRICE != 0)
    {
      newPrice += ROUND_PRICE - (newPrice % ROUND_PRICE);
    }

    this.name = name;
    this.cost = cost;
    this.price = newPrice;
  }

  /**
   * Returns the name value.
   * 
   * @return The name value
   */
  public String getName()
  {
    return name;
  }

  /**
   * Returns the cost value.
   * 
   * @return The cost value
   */
  public int getCost()
  {
    return cost;
  }

  /**
   * Returns the price value.
   * 
   * @return The price value
   */
  public int getPrice()
  {
    return price;
  }

  /**
   * Returns a String representation of the Product.
   * 
   * @return the String
   */
  public String toString()
  {
    double costDollars = cost / 100.0;
    double priceDollars = price / 100.0;
    return String.format("Product: %s Cost: %.2f Price: %.2f.", name, costDollars, priceDollars);
  }
}
