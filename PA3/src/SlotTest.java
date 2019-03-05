import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SlotTest
{

  @Test
  void slotDefaultConstuctorTest()
  {
    Product product = new Product();
    Slot test = new Slot();
    assertEquals(test.load(product), 10);
  }
  
  @Test
  void slotConstuctorTest()
  {
    Product product = new Product();
    Slot test = new Slot(product);
    assertEquals(new Product().toString(), test.nextProduct().toString());
  }
  
  @Test
  void slotLoadCountTest()
  {
    Product product = new Product();
    Slot test = new Slot();
    assertEquals(test.load(product, 2), 2);
  }
  
  @Test
  void slotBuyOneTest()
  {
    Product product = new Product();
    Slot test = new Slot();
    test.load(product);
    Product test2 = test.buyOne();
    assertEquals(test2.toString(), product.toString());
  }
  
  @Test
  void slotBuyOneNullTest()
  {
    Slot test = new Slot();
    Product test2 = test.buyOne();
    assertEquals(test2, null);
  }
  
  @Test
  void emptySlotToStringTest()
  {
    Slot slot = new Slot();
    assertEquals(slot.toString(), "SlotCount: 0 of ");
  }
  
  @Test
  void filledSlotToStringHeaderTest()
  {
    Product product = new Product("chips", 25, 50);
    Slot slot = new Slot(product);
    String[] stringArr = slot.toString().split("\n");
    assertEquals(stringArr[0], "SlotCount: " + slot.SLOT_SIZE + " of ");
  }
  
  @Test
  void filledSlotToStringBodyTest()
  {
    Product product = new Product("chips", 25, 50);
    Slot slot = new Slot(product);
    String[] stringArr = slot.toString().split("\n");
    assertEquals(stringArr[1], product.toString());
  }
  
  @Test
  void filledSlotToStringLineCountTest()
  {
    Product product = new Product("chips", 25, 50);
    Slot slot = new Slot(product);
    String[] stringArr = slot.toString().split("\n");
    assertEquals(stringArr.length, slot.SLOT_SIZE + 1);
  }
  
  @Test
  void filledSlotToStringNewLineCharCountTest()
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
}
