package image;

//@author: ARGHA SARKAR

import remotedesktop.transferWork.FileTransferSender;
import java.awt.AWTException;
import java.awt.Image;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ClientBackground {
    
    private String host = "127.0.0.1";
    private int port = 8000;
            
    private int timerInterval = 1000;
    private String savePath = "/Users/arghasarkar/Documents/screenshot.jpg";                               //SAVE PATH OF SCREENSHOT TAKEN
    private boolean started = false;                                            //FLAG TO CHECK IF BACKGROUND IS BEING SENT
    private ImageClass screen;                                                          //DECLARATION OF IMAGE CLASS
    private Image screenShot;                                                           //SCREENSHOT TAKEN
    private FileTransferSender imageSender;                                             //class for transmitting the image           
    
    
    private void takeScreenShot() {
        //TAKES A SCREEN SHOT AND SAVES IT UNDER IMAGE SCREENSHOT
        screen = new ImageClass();
        try { 
            screenShot = screen.getScreenShot();
        } catch (AWTException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        
    }
    
    public void saveScreenShot() {
        try {
            System.out.println(savePath);
            screen.writeScreenShotToFile(savePath, "jpg", false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        } catch (AWTException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }   
    
    private void transmitImage() {
        imageSender = new FileTransferSender(host, port, savePath);
        imageSender.sendFile();
    }
    
    public void startImageSender() {
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                takeScreenShot();
                saveScreenShot();
                transmitImage();
            }
        }, 0, timerInterval);
    }
    
    public void sendScreenShot() {
        
    }
}
