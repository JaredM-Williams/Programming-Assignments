import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;

/**
 * @author spragunr
 * @summary
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageTest
{

    private static String correctToStringDebug(Image image)
    {
        String result = "<Image width=" + image.getWidth() + " height=" + image.getHeight() + ">"
                + "\n";

        for (int y = 0; y < image.getHeight(); y++)
        {

            for (int x = 0; x < image.getWidth(); x++)
            {
                result += "\t" + image.getPixel(x, y).toString();
            }
            result += "\n";
        }

        return result;
    }

    // CONSTRUCTOR TESTS
    @Test
    public void test3CTierImageGetWidthTwoArgConstructor()
    {
    //done
        Image i = new Image(20, 30);
        Image i1 = new Image(1, 1);
        assertEquals(20, i.getWidth());
        assertEquals(1, i1.getWidth());
    }

    @Test
    public void test3CTierImageGetWidthTwoArgConstructorZeroWidth()
    {
    //done
        Image i = new Image(0, 30);
        assertEquals(0, i.getWidth());
    }

    @Test
    public void test3CTierImageGetWidthTwoArgConstructorNegativeWidth()
    {
    //done
        Image i = new Image(-1, 30);
        assertEquals(0, i.getWidth());
    }

    @Test
    public void test3CTierImageGetHeightTwoArgConstructor()
    {
    //done
        Image i = new Image(20, 30);
        Image i1 = new Image(1, 1);
        assertEquals(30, i.getHeight());
        assertEquals(1, i1.getHeight());
    }

    @Test
    public void test3CTierImageGetHeightTwoArgConstructorZeroHeight()
    {
    //done
        Image i = new Image(20, 0);
        assertEquals(0, i.getHeight());
    }

    @Test
    public void test3CTierImageGetHeightTwoArgConstructorNegativeHeight()
    {
        Image i = new Image(20, -1);
        assertEquals(0, i.getHeight());
    }

    @Test
    public void test1FTierImageGetWidthFiveArgConstructor()
    {
        Image i = new Image(20, 30, 1, 1, 1);
        assertEquals(20, i.getWidth());
    }

    @Test
    public void test3CTierImageGetWidthFiveArgConstructorZeroWidth()
    {
        Image i = new Image(0, 30, 1, 1, 1);
        assertEquals(0, i.getWidth());
    }

    @Test
    public void test3CTierImageGetWidthFiveArgConstructorNegativeWidth()
    {
        Image i = new Image(-1, 30, 1, 1, 1);
        assertEquals(0, i.getWidth());
    }

    @Test
    public void test1FTierImageGetHeightFiveArgConstructor()
    {
        Image i = new Image(20, 30, 1, 1, 1);
        assertEquals(30, i.getHeight());
    }

    @Test
    public void test3CTierImageGetHeightFiveArgConstructorZeroHeight()
    {
        Image i = new Image(20, 0, 1, 1, 1);
        assertEquals(0, i.getHeight());
    }

    @Test
    public void test3CTierImageGetHeightFiveArgConstructorNegativeHeight()
    {
        Image i = new Image(20, -1, 1, 1, 1);
        assertEquals(0, i.getHeight());
    }

    // GET PIXEL TESTS

    @Test
    public void test3CTierImageGetPixelTwoArgConstructor()
    {
        Image i = new Image(20, 30);
        Pixel p;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                p = i.getPixel(x, y);
                assertEquals(255, p.getRed());
                assertEquals(255, p.getGreen());
                assertEquals(255, p.getBlue());
            }
        }
    }

    @Test
    public void test1FTierImageGetPixelFiveArgConstructor()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                p = i.getPixel(x, y);
                assertEquals(2, p.getRed());
                assertEquals(3, p.getGreen());
                assertEquals(4, p.getBlue());
            }
        }
    }

    @Test
    public void test3CTierImageGetPixelNegativeX()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p;
        p = i.getPixel(-1, 0);
        assertEquals(null, p);
    }

    @Test
    public void test3CTierImageGetPixelNegativeY()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p;
        p = i.getPixel(0, -1);
        assertEquals(null, p);
    }

    @Test
    public void test3CTierImageGetPixelXTooLarge()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p;
        p = i.getPixel(20, 0);
        assertEquals(null, p);
    }

    @Test
    public void test3CTierImageGetPixelYTooLarge()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p;
        p = i.getPixel(0, 30);
        assertEquals(null, p);
    }

    // SET PIXEL TESTS

    @Test
    public void test3CTierImageSetPixelTwoArgConstructor()
    {
        Image i = new Image(20, 30);
        Pixel p;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                p = new Pixel(x, y, x + y);
                i.setPixel(x, y, p);
            }
        }

        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                p = i.getPixel(x, y);
                assertEquals(x, p.getRed());
                assertEquals(y, p.getGreen());
                assertEquals(x + y, p.getBlue());
            }
        }

    }

    @Test
    public void test1FTierImageSetPixelFiveArgConstructor()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                p = new Pixel(x, y, x + y);
                i.setPixel(x, y, p);
            }
        }

        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                p = i.getPixel(x, y);
                assertEquals(x, p.getRed());
                assertEquals(y, p.getGreen());
                assertEquals(x + y, p.getBlue());
            }
        }

    }

    @Test
    public void test3CTierImageSetPixelNegativeX()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p = new Pixel(7, 8, 9);
        i.setPixel(-1, 0, p);
    }

    @Test
    public void test3CTierImageSetPixelNegativeY()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p = new Pixel(7, 8, 9);
        i.setPixel(0, -1, p);
    }

    @Test
    public void test3CTierImageSetPixelXTooLarge()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p = new Pixel(7, 8, 9);
        i.setPixel(20, 0, p);
    }

    @Test
    public void test3CTierImageSetPixelYTooLarge()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p = new Pixel(7, 8, 9);
        i.setPixel(30, 0, p);
    }

    @Test
    public void test3CTierImageSetPixelNull()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        Pixel p = null;
        i.setPixel(0, 0, p);
        assertEquals(new Pixel(2, 3, 4), i.getPixel(0, 0));
    }

    @Test
    public void test3CTierImageEqualsNonImage()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        assertFalse(i.equals(null));
        assertFalse(i.equals("image"));
    }

    @Test
    public void test3CTierImageEqualsImageSizeMismatch()
    {
        Image i1 = new Image(20, 30, 2, 3, 4);
        Image i2 = new Image(20, 31, 2, 3, 4);
        Image i3 = new Image(21, 30, 2, 3, 4);

        assertFalse(i1.equals(i2));
        assertFalse(i1.equals(i3));
    }

    @Test
    public void test2DTierImageEqualsImagePixelMismatch()
    {
        Image i1 = new Image(20, 30, 2, 3, 4);
        Image i2 = new Image(20, 30, 2, 3, 4);

        i2.setPixel(19, 29, new Pixel(255, 255, 255));

        assertFalse(i1.equals(i2));
    }

    @Test
    public void test2DTierImageEqualsTrue()
    {
        Image i1 = new Image(20, 30, 2, 3, 4);
        Image i2 = new Image(20, 30, 2, 3, 4);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void test3CTierImageEqualsSizeZeroImages()
    {
        Image i1 = new Image(0, 0, 2, 3, 4);
        Image i2 = new Image(0, 0, 2, 3, 4);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void test2DTierImageToString()
    {
        Image i = new Image(20, 30, 2, 3, 4);
        assertEquals("<Image width=20 height=30>", i.toString());
    }

    @Test
    public void test2DTierImageToStringDebug()
    {
        Image i = ImageTestUtils.makeTestImage(4, 5);
        assertEquals(correctToStringDebug(i).trim(), i.toStringDebug().trim());
    }

}
