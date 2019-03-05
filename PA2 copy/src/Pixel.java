/**
 * An immutable RGB pixel class.
 * 
 * @author Jared Williams
 */
public class Pixel
{

  private final int red;
  private final int green;
  private final int blue;

  /**
   * Create a pixel with the indicated color.
   * 
   * @param red
   *          Red value
   * @param green
   *          Green value
   * @param blue
   *          Blue value
   */
  public Pixel(int red, int green, int blue)
  {
    this.red = clipColor(red);
    this.green = clipColor(green);
    this.blue = clipColor(blue);
  }

  /**
   * Make sure the color value is between 0-255.
   * 
   * @param value
   *          The value to clip
   * @return the clipped value.
   */
  private int clipColor(int value)
  {
    int result = value;
    if (value > 255)
    {
      result = 255;
    }
    else if (value < 0)
    {
      result = 0;
    }
    return result;

  }

  /**
   * Return the red value.
   * 
   * @return The red value
   */
  public int getRed()
  {
    return red;
  }

  /**
   * Return the green value.
   * 
   * @return the green value
   */
  public int getGreen()
  {
    return green;
  }

  /**
   * Return the blue value.
   * 
   * @return the blue value
   */
  public int getBlue()
  {
    return blue;
  }

  /**
   * Return true of the other object is equal to this Pixel.
   * 
   * @param other
   *          Object to compare
   * @return true if equal
   */
  @Override
  public boolean equals(Object other)
  {
    if (!(other instanceof Pixel))
    {
      return false;
    }
    Pixel otherPixel = (Pixel) other;
    return red == otherPixel.red && blue == otherPixel.blue && green == otherPixel.green;
  }

  /**
   * Return one of the color channels based on a number 0- red 1- green 2- blue.
   * 
   * @param color
   *          the requested color channel.
   * @return the correct color value, or -1 for bad input.
   */
  public int getChannel(int color)
  {
    int value = -1;
    switch (color)
    {
      case 0:
        value = red;
        break;
      case 1:
        value = green;
        break;
      case 2:
        value = blue;
        break;
      default:
        value = -1;
    }
    return value;

  }

  /**
   * Return a string representation of the Pixel.
   * 
   * @return the string
   */
  public String toString()
  {
    return "(" + red + ", " + green + ", " + blue + ")";
  }

}
