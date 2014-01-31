package remotedesktop.tests;

import remotedesktop.transferWork.SocketSender;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import remotedesktop.transferWork.FileTransferSender;
import image.ImageClass;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import remotedesktop.transferWork.SocketSender;

public class consoleClient {
    
    
    
    public static void main (String [] args) throws IOException, AWTException, InterruptedException {
        
       final String fileLocation = "/Users/arghasarkar/Documents/ss.jpg";
       final String fileWriteLocation = "/Users/arghasarkar/Documents/ss-test.jpg";
       final String fileWriteLocationDell = "C:\\Users\\Argha\\Documents\\NetBeansProjects\\RemoteDesktop\\Resources\\ss-test.jpg";
       
       
      
           
//       ImageClass ic = new ImageClass();
//       ic.writeScreenShotToFile(fileWriteLocationDell, "jpg", false);
//
//       SocketSender ss = new SocketSender("192.168.0.12", 8000);
//       ss.sendMessage(fileWriteLocationDell);

       //Thread.sleep(10);

//       FileTransferSender fts = new FileTransferSender("192.168.0.12", 8001, fileWriteLocationDell);
//       fts.sendFile();

       //Thread.sleep(50);


       Timer timer = new Timer();
       timer.scheduleAtFixedRate(new TimerTask() {
           int count = 0;
           
           @Override
           public void run() {
    
                   ImageClass ic = new ImageClass();
                   try {
                       ic.writeScreenShotToFile(fileLocation, "jpg", false);
                   } catch (IOException ex) {
                       Logger.getLogger(consoleClient.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (AWTException ex) {
                       Logger.getLogger(consoleClient.class.getName()).log(Level.SEVERE, null, ex);
                   }

                   FileTransferSender fts = new FileTransferSender("127.0.0.1", 8001, fileLocation);
                   fts.sendFile();
                   
                   count++;
                   //System.out.println("" + count);

           }
       }, 0, 1000);

           
       
    }
    
}
