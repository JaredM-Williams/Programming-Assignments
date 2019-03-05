import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Utility class for converting back and forth between Image objects and
 * java.awt.image.BufferedImage objects.
 * 
 * @author Nathan Sprague
 * @version V1.0, 9/5/13
 * 
 */
public class ImageUtils
{

  /**
   * Convert from java.awt.image.BufferedImage to Image.
   * 
   * @param bufferedImage
   *          The BufferedImage to convert.
   * @return Equivalent Image.
   */
  public static Image bufferedImageToImage(BufferedImage bufferedImage)
  {
    Image newImage = new Image(bufferedImage.getWidth(), bufferedImage.getHeight());
    Color c;

    for (int y = 0; y < bufferedImage.getHeight(); y++)
    {
      for (int x = 0; x < bufferedImage.getWidth(); x++)
      {
        c = new Color(bufferedImage.getRGB(x, y));
        newImage.setPixel(x, y, new Pixel(c.getRed(), c.getGreen(), c.getBlue()));
      }
    }
    return newImage;

  }

  /**
   * Convert from Image to java.awt.image.BufferedImage.
   * 
   * @param image
   *          The Image to convert.
   * @return Equivalent BufferedImage
   */
  public static BufferedImage imageToBufferedImage(Image image)
  {
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(),
        BufferedImage.TYPE_INT_RGB);
    Pixel p;
    Color c;

    for (int y = 0; y < bufferedImage.getHeight(); y++)
    {
      for (int x = 0; x < bufferedImage.getWidth(); x++)
      {
        p = image.getPixel(x, y);
        c = new Color(p.getRed(), p.getGreen(), p.getBlue());
        bufferedImage.setRGB(x, y, c.getRGB());
      }
    }
    return bufferedImage;

  }
}
