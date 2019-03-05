/**
 * A set of static image transform utility methods.
 * 
 * @author Jared Williams
 * 
 */
public class ImageTransforms
{

  public static final double RED_LUMINOSITY_WEIGHT = 0.299;
  public static final double GREEN_LUMINOSITY_WEIGHT = 0.587;
  public static final double BLUE_LUMINOSITY_WEIGHT = 0.114;
  public static final int ROSE_TINT = 25;

  /**
   * Calculate luminosity of a Pixel.
   * 
   * @param pixel
   *          The color to convert.
   * @return The luminosity.
   */
  private static int luminosity(Pixel pixel)
  {
    return (int) (RED_LUMINOSITY_WEIGHT * pixel.getRed()
        + GREEN_LUMINOSITY_WEIGHT * pixel.getGreen() + BLUE_LUMINOSITY_WEIGHT * pixel.getBlue());
  }

  /**
   * Convert an image to grayscale.
   * 
   * @param image
   *          The image to convert.
   * @return The Grayscale image.
   */
  public static Image convertToGrayscale(Image image)
  {
    Image newImage = new Image(image.getWidth(), image.getHeight());
    Pixel pixel;

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);
        int luminosity = luminosity(pixel);
        newImage.setPixel(x, y, new Pixel(luminosity, luminosity, luminosity));
      }
    }
    return newImage;
  }

  /**
   * Threshold an image based on pixel luminosity.
   * 
   * @param image
   *          The image to threshold.
   * @param threshold
   *          integer threshold cutoff.
   * @return Thresholded image.
   */
  public static Image threshold(Image image, int threshold)
  {
    Image newImage = new Image(image.getWidth(), image.getHeight());
    Pixel pixel;
    Pixel whitePixel = new Pixel(255, 255, 255);
    Pixel blackPixel = new Pixel(0, 0, 0);

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);
        int luminosity = luminosity(pixel);
        if (luminosity < threshold)
        {
          newImage.setPixel(x, y, blackPixel);
        }
        else
        {
          newImage.setPixel(x, y, whitePixel);
        }
      }
    }
    return newImage;
  }

  /**
   * Rotate image 90 degrees to counter-clockwise.
   * 
   * @param image
   *          Image to rotate
   * @return rotated image
   */
  public static Image rotateLeft(Image image)
  {
    Image newImage = new Image(image.getHeight(), image.getWidth());

    Pixel pixel;

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);
        newImage.setPixel(y, image.getWidth() - x - 1, pixel);
      }
    }
    return newImage;
  }

  /**
   * Rotate image 90 degrees to clockwise.
   * 
   * @param image
   *          Image to rotate
   * @return rotated image
   */
  public static Image rotateRight(Image image)
  {
    Image newImage = new Image(image.getHeight(), image.getWidth());

    Pixel pixel;

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);
        newImage.setPixel(image.getHeight() - y - 1, x, pixel);
      }
    }
    return newImage;

  }

  /**
   * Mirror image around the vertical axis.
   * 
   * @param image
   *          Image to mirror
   * @return mirrored image
   */
  public static Image mirror(Image image)
  {
    Image newImage = new Image(image.getWidth(), image.getHeight());

    Pixel pixel;

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);
        newImage.setPixel(image.getWidth() - x - 1, y, pixel);
      }
    }
    return newImage;

  }

  /**
   * Flip image around the horizontal axis.
   * 
   * @param image
   *          Image to flip
   * @return flipped image
   */
  public static Image flip(Image image)
  {
    Image newImage = new Image(image.getWidth(), image.getHeight());

    Pixel pixel;

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);
        newImage.setPixel(x, image.getHeight() - y - 1, pixel);
      }
    }
    return newImage;

  }

  /**
   * Tint an image red.
   * 
   * @param image
   *          Image to tint
   * @return tinted image
   */
  public static Image roseTintedGlasses(Image image)
  {
    Image newImage = new Image(image.getWidth(), image.getHeight());
    Pixel pixel;
    int newRed;
    int oldGreen;
    int oldBlue;

    for (int y = 0; y < image.getHeight(); y++)
    {
      for (int x = 0; x < image.getWidth(); x++)
      {
        pixel = image.getPixel(x, y);

        newRed = pixel.getRed() + ROSE_TINT;
        oldGreen = pixel.getGreen();
        oldBlue = pixel.getBlue();

        newImage.setPixel(x, y, new Pixel(newRed, oldGreen, oldBlue));
      }
    }
    return newImage;

  }

}
