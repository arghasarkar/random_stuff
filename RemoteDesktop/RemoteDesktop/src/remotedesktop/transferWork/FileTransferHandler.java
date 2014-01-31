package remotedesktop.transferWork;

import remotedesktop.TextFileWriter;
import remotedesktop.transferWork.SocketListener;

/*
 * @author arghasarkar
 */
public class FileTransferHandler  {
    
    private String storeDetails = "./filePathStore.txt";
    private int port;
    private String filePath;
    
    public FileTransferHandler(int portNum) {
        port = portNum;
    }
    
    public void receive() {
        
        SocketListener receiver = new SocketListener(port);
        receiver.startListener();
        filePath = receiver.getMessage();
        
        TextFileWriter writer = new TextFileWriter(storeDetails);
        
    }
    
}
