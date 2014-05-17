package remotedesktop.tests;

import java.io.*;
import remotedesktop.transferWork.FileTransferReceiver;

public class testScreenReceiver {
    
    public static void main (String[] args) {
        
        FileTransferReceiver FTR = new FileTransferReceiver(8000, "127.0.0.1");
        FTR.startReceiver();
        
    }
    
}
