import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest
{

  @Test
  void defaultProductNameTest()
  {
    Product p = new Product();
    assertEquals(p.getName(), "Generic");
  }

  @Test
  void defaultProductCostTest()
  {
    Product p = new Product();
    assertEquals(p.getCost(), 25);
  }

  @Test
  void defaultProductPriceTest()
  {
    Product p = new Product();
    assertEquals(p.getPrice(), 50);
  }

  @Test
  void negativePriceTest()
  {
    int x = 0;
    try
    {
      Product test = new Product("Chips", 50, -20);
    }
    catch (IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }

  @Test
  void PriceAndCostZeroTest()
  {
    Product p = new Product("Chips", 0, 0);
    assertEquals(p.getPrice(), 25);
  }
  
  @Test
  void costZeroTest()
  {
    Product p = new Product("Chips", 0, 100);
    assertEquals(p.getPrice(), 100);
  }
  
  @Test
  void costGreaterThanPriceTest()
  {
    Product p = new Product("Chips", 25, 23);
    assertEquals(p.getPrice(), 50);
  }


  @Test
  void PriceAndCostEqualTest()
  {
    Product p = new Product("Chips", 25, 25);
    assertEquals(p.getPrice(), 50);
  }

  @Test
  void nullNameTest()
  {
    int x = 0;
    try
    {
      Product test = new Product(null, 50, 70);
    }
    catch (IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }

  @Test
  void negativeCostTest()
  {
    int x = 0;
    try
    {
      Product test = new Product("Chips", -20, 70);
    }
    catch (IllegalArgumentException e)
    {
      x = 1;
    }
    assertEquals(x, 1);
  }

  @Test
  void productToStringTest()
  {
    String testString = "Product: M&Ms Cost: 1.02 Price: 1.25.";
    Product test = new Product("M&Ms", 102, 125);
    assertEquals(test.toString(), testString);
  }

  @Test
  void productPriceRoundingTest()
  {
    Product test = new Product("M&Ms", 102, 115);
    assertEquals(test.getPrice(), 125);
  }

  @Test
  void productPriceLessThanCostTest()
  {
    Product test = new Product("M&Ms", 132, 15);
    assertEquals(test.getPrice(), 150);
  }

}
