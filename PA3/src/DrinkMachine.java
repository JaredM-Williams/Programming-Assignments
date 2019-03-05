/**
 * A type of VendingMachine that charges a little more.
 * 
 * @author Jared Williams
 */
public class DrinkMachine extends VendingMachine
{
  public static final int COOLING_CHARGE = 10;

  /**
   * DrinkMachine default constructor.
   */
  DrinkMachine()
  {
    super();
  }

  /**
   * DrinkMachine constructor.
   * 
   * @param size
   *          the size of the VM.
   * @param product
   *          the product in the VM.
   */
  DrinkMachine(int size, Product product)
  {
    super(size, product);
  }

  /**
   * A type of VendingMachine that charges a little more.
   * 
   * @param slotNum
   *          the slot to buy something from
   * @throws IllegalArgumentException
   *           illegal argument
   * @return if the buy is successful.
   */
  public boolean buy(int slotNum) throws IllegalArgumentException
  {
    machineProfit -= COOLING_CHARGE;
    totalProfit -= COOLING_CHARGE;
    return super.buy(slotNum);
  }
}
