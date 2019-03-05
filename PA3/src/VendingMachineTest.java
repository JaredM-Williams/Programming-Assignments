import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest
{

  @Test
  void constructorOneArgTest()
  {
    VendingMachine test = new VendingMachine(2);
    assertEquals(test.getSlotCount(), 2);
  }
  
  @Test
  void loadDefaultEquivalenceToStringTest()
  {
    VendingMachine test = new VendingMachine(2);
    test.load();
    Product next = test.nextProduct(0);
    Product newP = new Product();
    assertEquals(next.toString(), newP.toString());
  }
  
  @Test
  void loadThreeArgEquivalenceToStringTest()
  {
    VendingMachine test = new VendingMachine(2);
    Product newP = new Product();
    test.load(0, 1, newP);
    Product next = test.nextProduct(0);
    assertEquals(next.toString(), newP.toString());
  }
  
  @Test
  void loadNullProductTest()
  {
    VendingMachine test = new VendingMachine(2);
    Product newP = null;
    int x = 0;
    try
    {
      test.load(0, 1, newP);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineCountNegativeLoadOutOfBoundsTest()
  {
    VendingMachine test = new VendingMachine(2);
    Product newP = new Product();
    int x = 0;
    try
    {
      test.load(0, -1, newP);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  
  @Test
  void vendingMachineSlotNumLoadOutOfBoundsTest()
  {
    VendingMachine test = new VendingMachine(2);
    Product newP = new Product();
    int x = 0;
    try
    {
      test.load(-1, 1, newP);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineSlotNumLoadOutOfBoundsTest2()
  {
    VendingMachine test = new VendingMachine(2);
    Product newP = new Product();
    int x = 0;
    try
    {
      test.load(100, 1, newP);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineSlotNumLoadNoErrorTest()
  {
    VendingMachine test = new VendingMachine(2);
    Product newP = new Product();
    int x = 0;
    try
    {
      test.load(0, 10, newP);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 0);
  }
  
  @Test
  void vendingMachineNextProductSlotNumNegativeOutOfBoundsTest()
  {
    VendingMachine test = new VendingMachine(2);
    test.load();
    int x = 0;
    try
    {
      test.nextProduct(-1);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineNextProductSlotNumTooHighOutOfBoundsTest()
  {
    VendingMachine test = new VendingMachine(2);
    test.load();
    int x = 0;
    try
    {
      test.nextProduct(3);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineBuySlotNumNegativeOutOfBoundsTest()
  {
    VendingMachine test = new VendingMachine(2);
    test.load();
    int x = 0;
    try
    {
      test.buy(-1);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineBuySlotNumTooHighOutOfBoundsTest()
  {
    VendingMachine test = new VendingMachine(2);
    test.load();
    int x = 0;
    try
    {
      test.buy(3);
    }
    catch(IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }
  
  @Test
  void vendingMachineBuyNullTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine test = new VendingMachine(2);
    assertEquals(test.buy(0), false);
  }
  
  @Test
  void vendingMachineGetTotalProfitTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine test = new VendingMachine(2);
    VendingMachine.resetTotalProfit();
    assertEquals(VendingMachine.getTotalProfit(), 0);
  }
  
  @Test
  void vendingMachineGetMachineProfitTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine test = new VendingMachine(2);
    assertEquals(test.getMachineProfit(), 0);
  }
  
  @Test
  void vendingMachineToStringEquivalenceTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine test = new VendingMachine(0);
    VendingMachine test2 = new VendingMachine(0);
    
    assertEquals(test.toString(), test2.toString());
  }
  
  @Test
  void vendingMachineToStringFirstLineTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine test = new VendingMachine(0);
    
    assertEquals(test.toString().split("\n")[0], "Vending Machine");
  }
  
  @Test
  void totalProfitTwoVendingMachinesFilledTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm1 = new VendingMachine();
    VendingMachine vm2 = new VendingMachine();
    vm1.load();
    vm2.load();
    
    
    assertEquals(VendingMachine.getTotalProfit(), -7500);
  }
  
  @Test
  void totalProfitTwoVendingMachinesTwoArgFilledTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm1 = new VendingMachine(15);
    VendingMachine vm2 = new VendingMachine(15);
    vm1.load();
    vm2.load();
    
    
    assertEquals(VendingMachine.getTotalProfit(), -7500);
  }
  
  @Test
  void totalProfitTwoVendingMachinesMultipleProductsBoughtTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm1 = new VendingMachine();
    VendingMachine vm2 = new VendingMachine();
    vm1.load();
    vm2.load();
    
    vm1.buy(0);
    vm1.buy(9);
    vm2.buy(5);
    assertEquals(VendingMachine.getTotalProfit(), -7350);
  }
  
  @Test
  void totalProfitTwoVendingMachinesTwoArgMultipleProductsBoughtTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm1 = new VendingMachine(15);
    VendingMachine vm2 = new VendingMachine(15);
    vm1.load();
    vm2.load();
    
    vm1.buy(0);
    vm1.buy(9);
    vm2.buy(5);
    assertEquals(VendingMachine.getTotalProfit(), -7350);
  }
  
  @Test
  void totalProfitTwoVendingMachinesTwoArgMultipleUniqueProductsBoughtTest()
  {
    VendingMachine.resetTotalProfit();
    Product chips = new Product("Chips", 100, 150);
    VendingMachine vm1 = new VendingMachine(15, chips);
    VendingMachine vm2 = new VendingMachine(15, chips);
    
    vm1.buy(0);
    vm1.buy(9);
    vm2.buy(5);
    assertEquals(VendingMachine.getTotalProfit(), -29550);
  }
  
  @Test
  void emptyVendingMachineToStringTest()
  {
    VendingMachine vm= new VendingMachine();
    String returnString = "Vending Machine";
    for (int x=0; x<VendingMachine.DEFAULT_SIZE; x++)
    {
      returnString += "\nSlotCount: 0 of ";
    }
    returnString += "\nTotal Profit: 0.00 Machine Profit: 0.00.";
    assertEquals(vm.toString(), returnString);
  }
  
  @Test
  void filledVendingMachineToStringHeaderTest()
  {
    Product product = new Product("chips", 25, 50);
    VendingMachine vm= new VendingMachine(2, product);
    String[] stringArr = vm.toString().split("\n");
    assertEquals(stringArr[0] + stringArr[1], "Vending MachineSlotCount: " + Slot.SLOT_SIZE + " of ");
  }
  
  @Test
  void filledVendingMachineToStringBodyTest()
  {
    Product product = new Product("chips", 25, 50);
    VendingMachine vm= new VendingMachine(2, product);
    String[] stringArr = vm.toString().split("\n");
    assertEquals(stringArr[3], product.toString());
  }
  /*
  @Test
  void filledVendingMachineToStringLineCountTest()
  {
    Product product = new Product("chips", 25, 50);
    VendingMachine vm= new VendingMachine(2, product);
    String[] stringArr = vm.toString().split("\n");
    assertEquals(stringArr.length, vm.getSlotCount() );
  }
  
  @Test
  void filledVendingMachineToStringNewLineCharCountTest()
  {
    Product product = new Product();
    Slot slot = new Slot(product);
    
    String str = slot.toString();
    String findStr = "\n";
    int lastIndex = 0;
    int count = 0;

    while(lastIndex != -1){

        lastIndex = str.indexOf(findStr,lastIndex);

        if(lastIndex != -1){
            count ++;
            lastIndex += findStr.length();
        }
    }
    assertEquals(count, slot.SLOT_SIZE);
  }
  */

  
}
