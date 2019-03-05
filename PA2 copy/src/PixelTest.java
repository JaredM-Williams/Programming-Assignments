import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;


/**
 * Unit tests for CS159 PA1B.
 * 
 * @author Nathan Sprague
 * @version 1/17
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PixelTest
{
    @Test
    public void test1FTierPixelGetRed()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(2, p.getRed());
    }

    @Test
    public void test1FTierPixelGetBlue()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(4, p.getBlue());
    }

    @Test
    public void test1FTierPixelGetGreen()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(3, p.getGreen());
    }

    @Test
    public void test3CTierPixelConstructorRedTooBig()
    {
        Pixel p = new Pixel(256, 0, 0);
        assertEquals(255, p.getRed());
    }

    @Test
    public void test3CTierPixelConstructorRedTooSmall()
    {
        Pixel p = new Pixel(-1, 0, 0);
        assertEquals(0, p.getRed());
    }

    @Test
    public void test3CTierPixelConstructorGreenTooBig()
    {
        Pixel p = new Pixel(0, 256, 0);
        assertEquals(255, p.getGreen());
    }

    @Test
    public void test3CTierPixelConstructorGreenTooSmall()
    {
        Pixel p = new Pixel(0, -1, 0);
        assertEquals(0, p.getGreen());
    }

    @Test
    public void test3CTierPixelConstructorBlueTooBig()
    {
        Pixel p = new Pixel(0, 0, 256);
        assertEquals(255, p.getBlue());
    }

    @Test
    public void test3CTierPixelConstructorBlueTooSmall()
    {
        Pixel p = new Pixel(0, 0, -1);
        assertEquals(0, p.getBlue());
    }

    @Test
    public void test2DTierPixelToString()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals("(2, 3, 4)", p.toString());
    }

    @Test
    public void test3CTierPixelGetChannel0()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(2, p.getChannel(0));
    }

    @Test
    public void test3CTierPixelGetChannel1()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(3, p.getChannel(1));
    }

    @Test
    public void test3CTierPixelGetChannel2()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(4, p.getChannel(2));
    }

    @Test
    public void test3CTierPixelGetChannelTooSmall()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(-1, p.getChannel(-1));
    }

    @Test
    public void test3CTierPixelGetChannelTooBig()
    {
        Pixel p = new Pixel(2, 3, 4);
        assertEquals(-1, p.getChannel(3));
    }

    @Test
    public void test2DTierPixelEqualPixelInput()
    {
        Pixel p1 = new Pixel(2, 3, 4);
        Pixel p2 = new Pixel(2, 3, 4);
        Pixel p3 = new Pixel(2, 3, 10);
        Pixel p4 = new Pixel(2, 10, 4);
        Pixel p5 = new Pixel(10, 3, 4);

        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertFalse(p1.equals(p5));
    }

    @Test
    public void test2DTierPixelEqualNonPixelInput()
    {
        Pixel p1 = new Pixel(2, 3, 4);
        assertFalse(p1.equals(null));
        assertFalse(p1.equals("(2, 3, 4)"));

    }

}
