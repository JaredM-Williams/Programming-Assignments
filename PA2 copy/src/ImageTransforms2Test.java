import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 
 * @author hcientist
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageTransforms2Test
{
  public static final int PA_SPEC_IMG_DEFAULT_WIDTH = 4;
  public static final int PA_SPEC_IMG_DEFAULT_HEIGHT = 5;

  private Image pa1SpecImg;
  private Image testImg;

  /**
   * 
   * @return image as specified in <a href
   *         ="https://hcientist.cs.jmu.edu/teaching/cs-159/spring-2019/pa1-mimp/#default-spec-img">PA1
   *         Spring 2019</a>
   */
  public static Image makePA1SpecImage()
  {
    Image i = ImageTestUtils.makeTestImage(PA_SPEC_IMG_DEFAULT_WIDTH, PA_SPEC_IMG_DEFAULT_HEIGHT);

    for (int y = 0; y < PA_SPEC_IMG_DEFAULT_HEIGHT; y++)
    {
      for (int x = 0; x < PA_SPEC_IMG_DEFAULT_WIDTH; x++)
      {
        i.setPixel(x, y, new Pixel(x + y * PA_SPEC_IMG_DEFAULT_WIDTH + 1,
            x + y * PA_SPEC_IMG_DEFAULT_WIDTH + 101, x + y * PA_SPEC_IMG_DEFAULT_WIDTH + 201));
      }
    }
    return i;

  }

  /**
   * Runs before the following @Test methods.
   */
  @Before
  public void setup()
  {
    this.pa1SpecImg = makePA1SpecImage();
    this.testImg = ImageTestUtils.makeTestImage(PA_SPEC_IMG_DEFAULT_WIDTH,
        PA_SPEC_IMG_DEFAULT_HEIGHT);

  }

  // ---------------------------------------------------
  // ROSE TINTED TESTS
  // ---------------------------------------------------
  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsRoseTintedGlassesCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.roseTintedGlasses(this.pa1SpecImg);

    int[][] expectedColors = new int[][] {{26, 101, 201}, {31, 106, 206}, {36, 111, 211},
        {41, 116, 216}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsRoseTintedGlassesCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.roseTintedGlasses(this.testImg);

    int[][] expectedColors = new int[][] {{26, 94, 199}, {31, 99, 204}, {36, 104, 209},
        {41, 109, 214}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  // ---------------------------------------------------
  // GRAYSCALE TESTS
  // ---------------------------------------------------

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsGrayscaleCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.convertToGrayscale(this.pa1SpecImg);

    int[] expectedColors = new int[] {82, 87, 92, 97};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsGrayscaleCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.convertToGrayscale(this.testImg);
    int[] expectedColors = new int[] {78, 83, 88, 93};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  // ---------------------------------------------------
  // THRESHOLD TESTS
  // ---------------------------------------------------

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsThresholdCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.threshold(this.pa1SpecImg, 91);

    int[] expectedColors = new int[] {0, 0, 255, 255};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsThresholdCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.threshold(this.testImg, 87);

    int[] expectedColors = new int[] {0, 0, 255, 255};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  // ---------------------------------------------------
  // ROTATE LEFT TESTS
  // ---------------------------------------------------

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsRotateLeftCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.rotateLeft(this.pa1SpecImg);

    int[][] expectedColors = new int[][] {{4, 104, 204}, {7, 107, 207}, {10, 110, 210},
        {13, 113, 213}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsRotateLeftCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.rotateLeft(this.testImg);

    int[][] expectedColors = new int[][] {{4, 97, 202}, {7, 100, 205}, {10, 103, 208},
        {13, 106, 211}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  // ---------------------------------------------------
  // ROTATE Right TESTS
  // ---------------------------------------------------

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsRotateRightCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.rotateRight(this.pa1SpecImg);

    int[][] expectedColors = new int[][] {{17, 117, 217}, {14, 114, 214}, {11, 111, 211},
        {8, 108, 208}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsRotateRightCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.rotateRight(this.testImg);

    int[][] expectedColors = new int[][] {{17, 110, 215}, {14, 107, 212}, {11, 104, 209},
        {8, 101, 206}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  // ---------------------------------------------------
  // FLIP TESTS
  // ---------------------------------------------------

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsFlipCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.flip(this.pa1SpecImg);

    int[][] expectedColors = new int[][] {{17, 117, 217}, {14, 114, 214}, {11, 111, 211},
        {8, 108, 208}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsFlipCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.flip(this.testImg);

    int[][] expectedColors = new int[][] {{17, 110, 215}, {14, 107, 212}, {11, 104, 209},
        {8, 101, 206}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  // ---------------------------------------------------
  // MIRROR TESTS
  // ---------------------------------------------------

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsMirrorCorrectOnSpecImage()
  {
    Image i1 = ImageTransforms.mirror(this.pa1SpecImg);

    int[][] expectedColors = new int[][] {{4, 104, 204}, {7, 107, 207}, {10, 110, 210},
        {13, 113, 213}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

  /**
   * Asserts that the implemented transform returns the expected values based on reference images.
   */
  @Test
  public void test3BTierImageTransformsMirrorCorrectOnTestImage()
  {
    Image i1 = ImageTransforms.mirror(this.testImg);

    int[][] expectedColors = new int[][] {{4, 97, 202}, {7, 100, 205}, {10, 103, 208},
        {13, 106, 211}};

    for (int i = 0; i < PA_SPEC_IMG_DEFAULT_WIDTH; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        assertEquals(expectedColors[i][j], i1.getPixel(i, i).getChannel(j));
      }
    }
  }

}
