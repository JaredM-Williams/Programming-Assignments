import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageTransformsWithoutCompleteTest
{
    // ---------------------------------------------------
    // ROSE TINTED TESTS
    // ---------------------------------------------------
    @Test
    public void test3CTierImageTransformsRoseTintedGlassesOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.roseTintedGlasses(i1);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

    // ---------------------------------------------------
    // GRAYSCALE TESTS
    // ---------------------------------------------------

    @Test
    public void test3CTierImageTransformsConvertToGrayscaleOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.convertToGrayscale(i1);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

    // ---------------------------------------------------
    // THRESHOLD TESTS
    // ---------------------------------------------------

    @Test
    public void test3CTierImageTransformsThresholdOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.threshold(i1, 100);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

    // ---------------------------------------------------
    // ROTATE LEFT TESTS
    // ---------------------------------------------------

    @Test
    public void test4BTierImageTransformsRotateLeftOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.rotateLeft(i1);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

    // ---------------------------------------------------
    // ROTATE Right TESTS
    // ---------------------------------------------------

    @Test
    public void test4BTierImageTransformsRotateRightOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.rotateRight(i1);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

    // ---------------------------------------------------
    // FLIP TESTS
    // ---------------------------------------------------

    @Test
    public void test5ATierImageTransformsFlipOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.flip(i1);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

    // ---------------------------------------------------
    // MIRROR TESTS
    // ---------------------------------------------------

    @Test
    public void test5ATierImageTransformsMirrorOriginalNotModified()
    {
        Image i1 = ImageTestUtils.makeTestImage(3, 4);
        Image i2 = ImageTestUtils.makeTestImage(3, 4);
        ImageTransforms.mirror(i1);
        assertTrue(ImageTestUtils.imageEqualTest(i1, i2));
    }

}
