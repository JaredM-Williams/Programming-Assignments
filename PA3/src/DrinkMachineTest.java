import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DrinkMachineTest
{

  @Test
  void drinkMachineDefaultConstructorTest()
  {
    DrinkMachine test = new DrinkMachine();
    assertEquals(test.COOLING_CHARGE, 10);
  }

  @Test
  void drinkMachineConstructorTest()
  {
    Product product = new Product();
    DrinkMachine test = new DrinkMachine(3, product);
    assertEquals(test.COOLING_CHARGE, 10);
  }
  
  @Test
  void drinkMachineBuyTest()
  {
    Product product = new Product();
    DrinkMachine test = new DrinkMachine(3, product);
    assertEquals(test.buy(0), true);
  }

}
