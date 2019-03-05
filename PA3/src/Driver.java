import java.util.ArrayList;
public class Driver
{

  public static void main(String[] args)
  {
    //Product test = new Product("M&Ms", 102, 125);
    //System.out.println(test);

    //Slot slotTest = new Slot(test);
    
    
    //System.out.println(slotTest.nextProduct());
    //slotTest.buyOne();
    //System.out.println(slotTest);
    //slotTest.load(new Product("nothing", 101, 102));
    //System.out.println(slotTest);
    
    VendingMachine test = new VendingMachine(2);
    VendingMachine test2 = new VendingMachine(3);
    test.load();
    test2.load();
    
    ArrayList<VendingMachine> testArr = new ArrayList<VendingMachine>();
    testArr.add(test);
    testArr.add(test2);
    
    Simulator sim = new Simulator(testArr);
    int simulation = sim.simulate(10);
    System.out.println(simulation);
    
    VendingMachine test4 = new VendingMachine(2);
    System.out.println(test4.toString());
    //Slot slot = new Slot();
    //System.out.println(slot.toString());
    
    
  }

}
