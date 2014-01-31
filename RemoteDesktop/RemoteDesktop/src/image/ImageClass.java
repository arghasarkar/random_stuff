package image;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageClass {

    private boolean fullscreen = true;                                          //SHOULD THE SCREEN SHOUT BE FULL SCHREEN?
    
    private Image ScreenShot = null;                                            //SCREEN SHOT DECLARATION
    private BufferedImage BufferedShot = null;                                  //SCREENSHOT IN A BUFFEREDIMAGE CLASS
    
    private Rectangle area;                                                     //AREA OF THE SCREEN SHOT
    //private String filePath;                                                    //IMAGE PATH WHERE THE IMAGE WILL BE STORED
    //private String fileFormat;                                                  //FORMAT OF THE IMAGE, JPG, BMP OR PNG
    
    public ImageClass() {
    }
       
    private boolean checkFileExists(String path) {
        File checkFile = new File(path);
        return checkFile.exists();
    }
    
    private void takeScreenShot() throws AWTException {    
        Robot robot = new Robot();
        Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
        area = new Rectangle(a);
        ScreenShot = robot.createScreenCapture(area);
    }
    
    private void takeBufferedShot() throws AWTException {
        Robot robot = new Robot();
        Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
        area = new Rectangle(a);
        BufferedShot = robot.createScreenCapture(area);
    }
    
    public Image getScreenShot() throws AWTException {
        this.takeScreenShot();
        return ScreenShot;
    }
    
    public BufferedImage getBufferedShot() throws AWTException {
        this.takeBufferedShot();
        return BufferedShot;
    }
    
    public int writeImageToFile(Image inputImage, String path, String format) throws IOException{
        if (checkFileExists(path) == true) {
            BufferedImage img = (BufferedImage) inputImage;
            ImageIO.write(img, format, new File(path));
            return 1;
        } 
        return 0;
    }
    
    public int writeScreenShotToFile(String path, String format, boolean checkExists) throws IOException, AWTException {
        this.takeScreenShot();
        if (checkExists == true) {
            if (checkFileExists(path) == true) {
                BufferedImage img = (BufferedImage) ScreenShot;
                ImageIO.write(img, format, new File(path));
                return 1;
            } 
            return 0;
        } else {
            BufferedImage img = (BufferedImage) ScreenShot;
            ImageIO.write(img, format, new File(path));
            return 1;
        }
    }   
    
    
     public byte[] getScreenShotBytes() throws AWTException, IOException {
        Image testImage = this.getScreenShot();
        BufferedImage BI = (BufferedImage) testImage;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        String base64String=Base64.encode(baos.toByteArray());
        baos.close();
        return Base64.decode(base64String);
     }
     
     public byte[] getScreenShotBytes(BufferedImage input) {
         byte[] returnArray;
         returnArray = ((DataBufferByte) input.getData().getDataBuffer()).getData();
         return returnArray;
     }
    
}