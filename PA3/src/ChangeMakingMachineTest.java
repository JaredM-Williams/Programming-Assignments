import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChangeMakingMachineTest
{

  @Test
  void changeMakingMachineDefaultConstructorTest()
  {
    ChangeMakingMachine test = new ChangeMakingMachine();
    assertEquals(test.DEFAULT_SIZE, 15);
  }

  @Test
  void changeMakingMachineConstructorTest()
  {
    ChangeMakingMachine test = new ChangeMakingMachine(8);
    assertEquals(test.getSlotCount(), 8);
  }
  
  @Test
  void changeMakingMachineConstructor2Test()
  {
    Product chips = new Product("chips", 25, 50);
    ChangeMakingMachine test = new ChangeMakingMachine(8, chips);
    assertEquals(test.getSlotCount(), 8);
  }
  
  @Test
  void changeMakingMachineBuyTest()
  {
    Product chips = new Product("chips", 25, 50);
    ChangeMakingMachine test = new ChangeMakingMachine(8, chips);
    assertEquals(test.buy(0, 2, 1), 100);
  }
  
  @Test
  void changeMakingMachineNullBuyTest()
  {
    ChangeMakingMachine test = new ChangeMakingMachine();
    assertEquals(test.buy(0, 2, 1), 150);
  }
  
  @Test
  void changeMakingMachineNegativeQuartersTest()
  {
    ChangeMakingMachine test = new ChangeMakingMachine();
    int x=0;
    try
    {
      assertEquals(test.buy(0, -2, 1), 150);
    }
    catch (IllegalArgumentException e)
    {
      x=1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void changeMakingMachineNegativeDollarsTest()
  {
    ChangeMakingMachine test = new ChangeMakingMachine();
    int x=0;
    try
    {
      assertEquals(test.buy(0, 2, -1), 150);
    }
    catch (IllegalArgumentException e)
    {
      x=1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void changeMakingMachineNotEnoughMoneyTest()
  {
    Product chips = new Product("chips", 25, 50);
    ChangeMakingMachine test = new ChangeMakingMachine(8, chips);
    assertEquals(test.buy(0, 1, 0), -1);
  }
  
  
  
}
