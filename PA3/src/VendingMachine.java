/**
 * A class that manages and holds Slots.
 * 
 * @author Jared Williams
 */
public class VendingMachine
{
  public static final int DEFAULT_SIZE = 15;
  static int totalProfit = 0;
  int machineProfit = 0;
  private Slot[] slots;

  /**
   * VendingMachine default constructor.
   */
  VendingMachine()
  {
    slots = new Slot[DEFAULT_SIZE];
    for (int x = 0; x < DEFAULT_SIZE; x++)
    {
      slots[x] = new Slot();
    }
  }

  /**
   * VendingMachine constructor.
   * 
   * @param size
   *          the number of Slots in the VendingMachine
   */
  VendingMachine(int size)
  {
    slots = new Slot[size];
    for (int x = 0; x < size; x++)
    {
      slots[x] = new Slot();
    }
  }

  /**
   * VendingMachine constructor.
   * 
   * @param size
   *          the size of the VendingMachine
   * @param product
   *          the type of Product in the VendingMachine
   */
  VendingMachine(int size, Product product)
  {
    slots = new Slot[size];
    for (int x = 0; x < size; x++)
    {
      slots[x] = new Slot(product);
    }
    machineProfit -= product.getCost() * size * Slot.SLOT_SIZE;
    totalProfit -= product.getCost() * size * Slot.SLOT_SIZE;
  }

  /**
   * Fully loads the VendingMachine Slots with Products.
   */
  public void load()
  {
    int count;
    Product generic = new Product();
    for (int x = 0; x < slots.length; x++)
    {
      count = slots[x].load(generic);
      machineProfit -= generic.getCost() * count;
      totalProfit -= generic.getCost() * count;
    }
  }

  /**
   * Loads a specific VendingMachine Slot with a specific amount of Products.
   * 
   * @param slotNum
   *          the size of the VendingMachine
   * @param count
   *          the products in the VendingMachine
   * @param product
   *          the product to be loaded
   * @throws IllegalArgumentException
   *           illegal argument
   */
  public void load(int slotNum, int count, Product product) throws IllegalArgumentException
  {
    if (product == null || count <= 0 || slotNum < 0 || slotNum > slots.length)
    {
      throw new IllegalArgumentException();
    }
    int countNum = slots[slotNum].load(product, count);
    machineProfit -= product.getCost() * countNum;
    totalProfit -= product.getCost() * countNum;
  }

  /**
   * Returns the next Product in the Slot indexed.
   * 
   * @param slotNum
   *          the index of the slot
   * @throws IllegalArgumentException
   *           illegal argument
   * @return the next Product
   */
  public Product nextProduct(int slotNum) throws IllegalArgumentException
  {
    if (slotNum < 0 || slotNum >= slots.length)
    {
      throw new IllegalArgumentException();
    }
    return slots[slotNum].nextProduct();
  }

  /**
   * Attempts to buy the next Product in the Slot indexed, and returns if the purchase was
   * successful.
   * 
   * @param slotNum
   *          the index of the slot
   * @throws IllegalArgumentException
   *           illegal argument
   * @return whether or not the purchase succeeds
   */
  public boolean buy(int slotNum) throws IllegalArgumentException
  {
    if (slotNum < 0 || slotNum >= slots.length)
    {
      throw new IllegalArgumentException();
    }
    Product bought = slots[slotNum].buyOne();
    if (bought == null)
    {
      return false;
    }
    else
    {
      machineProfit += bought.getPrice();
      totalProfit += bought.getPrice();
      return true;
    }
  }

  /**
   * Returns the slot count.
   * 
   * @return the slot count
   */
  public int getSlotCount()
  {
    return slots.length;
  }

  /**
   * Returns the total profit.
   * 
   * @return the total profit
   */
  public static int getTotalProfit()
  {
    return totalProfit;
  }

  /**
   * Resets the total profit.
   */
  public static void resetTotalProfit()
  {
    totalProfit = 0;
  }

  /**
   * Returns the machine profit.
   * 
   * @return the machine profit
   */
  public int getMachineProfit()
  {
    return machineProfit;
  }

  /**
   * Returns the String representation of the VM.
   * 
   * @return the String
   */
  public String toString()
  {
    String returnString = "Vending Machine";
    for (int x = 0; x < slots.length; x++)
    {
      returnString += "\n" + slots[x].toString();
    }
    returnString += String.format("\nTotal Profit: %.2f Machine Profit: %.2f.", totalProfit / 100.0,
        machineProfit / 100.0);

    return returnString;
  }
}
