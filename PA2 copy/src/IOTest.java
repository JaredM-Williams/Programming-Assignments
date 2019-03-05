import static org.junit.Assert.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

/**
 * Unit tests for Web-CATing Image IO methods from PA2
 * 
 * @author spragunr
 * 
 */
public class IOTest
{

    /* TESTS FOR PRINTING AND SAVING */


    @AfterEach
    public void tearDown()
    {
        File n = new File("tmp.mim");
        n.delete();
        n = new File("tmp1.mim");
        n.delete();
        n = new File("tmp2.mim");
        n.delete();
    
        
    }

    // TESTS THAT SAVE IS DOING SOMETHING REASONABLE
    @Test
    public void testImageSaveImageWithFilenameFileExists() throws FileNotFoundException
    {
        Image i = new Image(20, 30);
        Image.saveImage(i, "tmp.mim");
        File n = new File("tmp.mim");
        assertTrue(n.exists());
    }

    @Test
    public void testImageSaveImageWithFilenameFileNotEmpty()
            throws ImageFileFormatException,
            FileNotFoundException, IOException

    {
        Image i = new Image(20, 30);
        Image.saveImage(i, "tmp.mim");
        File n = new File("tmp.mim");
        assertTrue(n.exists());
        FileInputStream fs = new FileInputStream(n);
        assertFalse(0 == fs.available());
        fs.close();
    }

    @Test
    public void testImageSaveImageWithFileObjectFileExists() throws FileNotFoundException
    {
        Image i = new Image(20, 30);
        File n = new File("tmp.mim");
        Image.saveImage(i, n);
        assertTrue(n.exists());
    }

    @Test
    public void testImageSaveImageWithFileObjectFileNotEmpty()
            throws ImageFileFormatException,
            FileNotFoundException, IOException
    {
        Image i = new Image(20, 30);
        File n = new File("tmp.mim");
        Image.saveImage(i, n);
        assertTrue(n.exists());
        FileInputStream fs = new FileInputStream(n);
        assertFalse(0 == fs.available());
        fs.close();
    }

    @Test
    public void testImageSaveFileNameSameResultAsSaveImageFileObject() throws FileNotFoundException
    {
        Image i = ImageTestUtils.makeTestImage(3, 4);
        File n = new File("tmp2.mim");
        Image.saveImage(i, "tmp1.mim");
        Image.saveImage(i, n);

        Scanner s1 = new Scanner(new FileInputStream("tmp1.mim"));
        Scanner s2 = new Scanner(new FileInputStream("tmp2.mim"));
        s1.useDelimiter("\\Z");
        s2.useDelimiter("\\Z");

        assertEquals(s1.next(), s2.next());
        s1.close();
        s2.close();
    }


    /*
     * TESTS FOR READING AND LOADING *****************************************
     */
    
    
    /* Test successful reads */
    @Test
    public void testSaveImageWithFilenameLoadImageUsingFileNameImageMatches()
            throws FileNotFoundException, ImageFileFormatException
    {
        Image i1 = ImageTestUtils.makeTestImage(4, 5);
        Image.saveImage(i1, "tmp.mim");

        Image i2 = Image.loadImage("tmp.mim");

        ImageTestUtils.imageEqualTest(i1, i2);
    }

    @Test
    public void testSaveImageWithFilenameLoadImageUsingFileObjectImageMatches()
            throws FileNotFoundException, ImageFileFormatException
    {
        Image i1 = ImageTestUtils.makeTestImage(4, 5);
        Image.saveImage(i1, "tmp.mim");

        File f = new File("tmp.mim");
        Image i2 = Image.loadImage(f);

        ImageTestUtils.imageEqualTest(i1, i2);
    }
    

    
    
    

}
