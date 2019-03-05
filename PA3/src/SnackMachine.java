import java.util.ArrayList;

/**
 * A class that extends VendingMachine.
 * 
 * @author Jared Williams
 */
public class SnackMachine extends ChangeMakingMachine
{
  private ArrayList<Product> productList;

  /**
   * SnackMachine constructor.
   * @param pList the list of Products
   */
  SnackMachine(ArrayList<Product> pList)
  {
    super(pList.size());
    productList = new ArrayList<Product>();
    for (int x = 0; x < pList.size(); x++)
    {
      productList.add(pList.get(x));
      super.load(x, Integer.MAX_VALUE, productList.get(x));
    }
  }

  /**
   * Loads the SnackMachines with Products.
   */
  public void load()
  {
    for (int x = 0; x < productList.size(); x++)
    {
      super.load(x, Integer.MAX_VALUE, productList.get(x));
    }
  }
}
