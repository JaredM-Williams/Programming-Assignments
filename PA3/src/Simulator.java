import java.util.ArrayList;

/**
 * A class to simulate the purchase of stuff from VendingMachines.
 * 
 * @author Jared Williams
 */
public class Simulator
{
  private ArrayList<VendingMachine> vmList;

  /**
   * Simulation constructor.
   * 
   * @param vmList
   *          the list of VendingMachines
   */
  Simulator(ArrayList<VendingMachine> vmList)
  {
    this.vmList = vmList;
  }

  /**
   * Simulation constructor.
   * 
   * @param vm
   *          the VendingMachine to be added.
   */
  public void addVM(VendingMachine vm)
  {
    vmList.add(vm);
  }

  /**
   * Simulation constructor.
   * 
   * @param pCount
   *          the amount of purchases per slot.
   * @return the total profit.
   */
  public int simulate(int pCount)
  {
    for (int vm = 0; vm < vmList.size(); vm++)
    {
      for (int slot = 0; slot < vmList.get(vm).getSlotCount(); slot++)
      {
        for (int count = 0; count < pCount; count++)
        {
          vmList.get(vm).buy(slot);
        }
      }
    }
    return VendingMachine.getTotalProfit();
  }
}
