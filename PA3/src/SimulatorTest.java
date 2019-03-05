import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SimulatorTest
{

  @Test
  void simulatorConstructorNoErrorTest()
  {
    
    ArrayList<VendingMachine> test = new ArrayList<VendingMachine>();
    int x=0;
    try
    {
      Simulator sim = new Simulator(test);
    }
    catch(Throwable e)
    {
      x=1;
    }
    assertEquals(x, 0);
  }
  
  
  @Test
  void addVMNoErrorTest()
  {
    
    ArrayList<VendingMachine> test = new ArrayList<VendingMachine>();
    int x=0;
    Simulator sim = new Simulator(test);
    VendingMachine vmTest = new VendingMachine();
    try
    {
      sim.addVM(vmTest);
    }
    catch(Throwable e)
    {
      x=1;
    }
    assertEquals(x, 0);
  }
  
  @Test
  void passedVsAddedVMTest()
  {
    VendingMachine testVM1 = new VendingMachine(2);
    VendingMachine testVM2 = new VendingMachine(2);
    testVM1.load();
    testVM2.load();
    ArrayList<VendingMachine> arr1 = new ArrayList<VendingMachine>();
    arr1.add(testVM1);
    ArrayList<VendingMachine> arr2 = new ArrayList<VendingMachine>();
    Simulator sim1 = new Simulator(arr1);
    Simulator sim2 = new Simulator(arr2);
    sim2.addVM(testVM2);
    VendingMachine.resetTotalProfit();
    int simulation1 = sim1.simulate(10);
    VendingMachine.resetTotalProfit();
    int simulation2 = sim2.simulate(10);
    assertEquals(simulation1, simulation2);
  }
  
  @Test
  void simulationTest()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine test = new VendingMachine(2);
    VendingMachine test2 = new VendingMachine(3);
    test.load();
    test2.load();
    
    ArrayList<VendingMachine> testArr = new ArrayList<VendingMachine>();
    testArr.add(test);
    testArr.add(test2);
    
    Simulator sim = new Simulator(testArr);
    int simulation = sim.simulate(10);
    assertEquals(simulation, 1250);
  }

}
