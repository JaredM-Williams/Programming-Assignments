import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * A basic image class.
 * 
 * @author Jared Williams
 * 
 */
public class Image
{
  private Pixel[][] pixels;
  private int width;
  private int height;

  /**
   * Create a new solid image with the indicated color.
   * 
   * @param width
   *          The width
   * @param height
   *          The height
   * @param red
   *          Red value
   * @param green
   *          Green value
   * @param blue
   *          blue value
   */
  public Image(int width, int height, int red, int green, int blue)
  {
    if (width <= 0 || height <= 0)
    {
      this.width = 0;
      this.height = 0;
    }
    else
    {
      this.width = width;
      this.height = height;

      pixels = new Pixel[height][width];

      Pixel p = new Pixel(red, green, blue);
      for (int x = 0; x < width; x++)
      {
        for (int y = 0; y < height; y++)
        {
          setPixel(x, y, p);
        }
      }
    }

  }

  /**
   * Create a blank white image.
   * 
   * @param width
   *          The image width
   * @param height
   *          The image height
   */
  public Image(int width, int height)
  {
    this(width, height, 255, 255, 255);
  }

  /**
   * Helper method for validating image index.
   * 
   * @param x
   *          x coordinate
   * @param y
   *          y coordinate
   * @return True if index is valid
   */
  private boolean isValidIndex(int x, int y)
  {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  /**
   * Return the indicated pixel.
   * 
   * @param x
   *          x position of pixel
   * @param y
   *          y position of pixel
   * @return The pixel
   */
  public Pixel getPixel(int x, int y)
  {
    Pixel result = null;
    if (isValidIndex(x, y))
    {
      result = pixels[y][x];
    }
    return result;
  }

  /**
   * @return the width
   */
  public int getWidth()
  {
    return width;
  }

  /**
   * @return the height
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * Set a particular pixel.
   * 
   * @param x
   *          horizontal position
   * @param y
   *          vertical position
   * @param pixel
   *          The new pixel
   */
  public void setPixel(int x, int y, Pixel pixel)
  {
    if (pixel != null && isValidIndex(x, y))
    {
      pixels[y][x] = pixel;
    }
  }

  /**
   * Return true if other is equal to this Image. Two images are equal if they are the same size and
   * contain equal pixels at corresponding positions.
   * 
   * @param other
   *          The object to compare
   * @return true if equal
   */
  public boolean equals(Object other)
  {
    if (!(other instanceof Image))
    {
      return false;
    }

    Image otherImg = (Image) other;
    if (this.getWidth() != otherImg.getWidth() || this.getHeight() != otherImg.getHeight())
    {
      return false;
    }

    for (int x = 0; x < getWidth(); x++)
    {
      for (int y = 0; y < getHeight(); y++)
      {
        if (!getPixel(x, y).equals(otherImg.getPixel(x, y)))
        {
          return false;
        }
      }
    }

    return true;

  }

  /**
   * @return A string representation of the image.
   */
  public String toString()
  {
    return "<Image width=" + width + " height=" + height + ">";
  }

  /**
   * Create a string representation of the entire image.
   * 
   * @return A big string containing the result.
   */
  public String toStringDebug()
  {
    String result = toString();
    for (int y = 0; y < height; y++)
    {
      result += "\n";
      for (int x = 0; x < width; x++)
      {
        result += "\t" + getPixel(x, y).toString();
      }
    }
    result += "\n";

    return result;
  }
  
  /**
   * Saves an image onto an existing mim file.
   * 
   * @param  image  the image that needs to be saved.
   * @param  file   the name of the mim file
   */
  public static void saveImage(Image image, File file) throws FileNotFoundException
  {
	  Pixel[][] imageArray = image.pixels;
	  PrintWriter writer = new PrintWriter(file);
	  for(int i=0; i<imageArray.length; i++) {
	      for(int j=0; j<imageArray[i].length; j++) {
	    	  writer.write(imageArray[i][j].getRed() + " ");
	    	  writer.write(imageArray[i][j].getGreen() + " ");
	    	  writer.write(imageArray[i][j].getBlue() + " ");
	      }
	      writer.write("\n");
	  }
  }
  
  /**
   * Creates a mim file and saves an image onto it.
   * 
   * @param  image  the image that needs to be saved.
   * @param  file   the name of the created mim file.
   */
  public static void saveImage(Image image, String fileName) throws FileNotFoundException
  {
	  Pixel[][] imageArray = image.pixels;
	  PrintWriter writer = new PrintWriter(new File(fileName));
	  writer.write(imageArray.length);

	  for(int i=0; i<imageArray.length; i++) {
	      for(int j=0; j<imageArray[i].length; j++) {
	    	  writer.write(imageArray[i][j].getRed() + " ");
	    	  writer.write(imageArray[i][j].getGreen() + " ");
	    	  writer.write(imageArray[i][j].getBlue() + " ");
	      }
	  }
  }
  
  /**
   * Loads an image object off of a File object.
   * 
   * @param  file  a file object.
   * @return   an image object.
   */
  public static Image loadImage(File file) throws FileNotFoundException, ImageFileFormatException
  {
	  Scanner scanner = new Scanner(file);
	  int width = scanner.nextInt();
	  while (scanner.hasNextInt())
	  {
		  
	  }
  }
  
  /**
   * Loads an image object off of a file with the given name.
   * 
   * @param  the file name String.
   * @return   an image object.
   */
  public static Image loadImage(String fileName) throws FileNotFoundException, ImageFileFormatException
  {
	  Scanner scanner = new Scanner(new File(fileName));
	  int width = scanner.nextInt();
	  ArrayList<Integer> data = new ArrayList<Integer>();
	  while(scanner.hasNextInt())
	  {
		  data.add(scanner.nextInt());
	  }
	  height = data.size() / width;
	  Image loadedImage = new Image(width, height)
	  return loadedImage;
	  
  }

}
