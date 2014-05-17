package remotedesktop.tests;

/*
 * @author ARGHA SARKAR
 */

import remotedesktop.transferWork.SocketListener;
import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import remotedesktop.transferWork.FileTransferReceiver;
        
public class consoleServer {
    
    public static void main(String[] args) throws IOException {

        String fileWriteLocation1 = "C:\\Users\\Argha\\Documents\\NetBeansProjects\\RemoteDesktop\\Resources\\pic1.jpg";                                          //THIS WILL BE THE FILE'S STORAGE LOCATION - RECEIVED BY SOCKET LISTENR
        String fileWriteLocation2 = "C:\\Users\\Argha\\Documents\\NetBeansProjects\\RemoteDesktop\\Resources\\pic2.jpg";
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                FileTransferReceiver ftr = new FileTransferReceiver(8001, fileWriteLocation1);
                ftr.startReceiver();
            } else {
                FileTransferReceiver ftr = new FileTransferReceiver(8001, fileWriteLocation2);
                ftr.startReceiver();
            }
        
        }
        
    }
        
    
}
