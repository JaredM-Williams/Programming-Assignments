import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SnackMachineTest
{

  @Test
  void snackMachineConstructorTest()
  {
    Product chips = new Product("chips", 25, 50);
    ArrayList<Product> productList = new ArrayList<Product>();
    productList.add(chips);
    int x=0;
    try
    {
      SnackMachine test = new SnackMachine(productList);
    }
    catch(Throwable e)
    {
      x=1;
    }
    assertEquals(x, 0);
  }
  
  @Test
  void snackMachineLoadTest()
  {
    Product chips = new Product("chips", 25, 50);
    ArrayList<Product> productList = new ArrayList<Product>();
    productList.add(chips);
    SnackMachine test = new SnackMachine(productList);
    test.load();
    assertEquals(test.nextProduct(0).toString(), chips.toString());
  }

}
