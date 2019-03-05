/**
 * A type of VendingMachine that gives change for a purchase.
 * 
 * @author Jared Williams
 */
public class ChangeMakingMachine extends VendingMachine
{

  /**
   * ChangeMakingMachine default constructor.
   */
  ChangeMakingMachine()
  {
    super();
  }

  /**
   * ChangeMakingMachine constructor.
   * 
   * @param size
   *          the number of Slots in the VendingMachine
   */
  ChangeMakingMachine(int size)
  {
    super(size);
  }

  /**
   * ChangeMakingMachine constructor.
   * 
   * @param size
   *          the size of the ChangeMakingMachine
   * @param product
   *          the type of Product in the ChangeMakingMachine
   */
  ChangeMakingMachine(int size, Product product)
  {
    super(size, product);
  }

  /**
   * Attempts to buy a product from the slot indexed, and returns the change.
   * 
   * @param slotNum
   *          the slot index
   * @param quarters
   *          the quarters
   * @param dollars
   *          the dollars
   * @throws IllegalArgumentException
   *           illegal argument    
   * @return the change
   */
  public int buy(int slotNum, int quarters, int dollars) throws IllegalArgumentException
  {
    if (quarters < 0 || dollars < 0)
    {
      throw new IllegalArgumentException();
    }
    Product product = super.nextProduct(slotNum);
    if (!super.buy(slotNum))
    {
      return quarters * 25 + dollars * 100;
    }
    int change = quarters * 25 + dollars * 100 - product.getPrice();
    if (change < 0)
    {
      return -1;
    }
    return change;
  }
}
