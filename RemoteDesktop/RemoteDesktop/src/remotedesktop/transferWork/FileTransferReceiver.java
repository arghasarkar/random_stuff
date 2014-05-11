package remotedesktop.transferWork;

/*
 * @author ARGHA SARKAR
 */
import java.io.*;
import java.net.*;

public class FileTransferReceiver {
    
    private ServerSocket receiveSocket = null;                                  //RECEIVER SOCKET
    private Socket acceptSocket = null;                                         //SOCKET TO ACCEPT SERVER SOCKET CONNECTION
    private int port;                                                           //PORT NUMBER TO OPERATE ON
    private int bufferSize = 0;                                                 //BUFFER SIZE USED BY THE SOCKET
    
    private byte[] byteArray = null;                                            //BYTE ARRAY THAT WILL STORE THE DATA RECEIVED
    private FileOutputStream fileWriter = null;                                 //BINARY WRITER FOR WRITING THE FILE
    private InputStream receiverStream = null;                                  //READS DATA INCOMING FROM THE SOCKET
    private BufferedOutputStream out = null;                                    //WRITERS THE FILE WITH THE HELP OF FILEOUTPUT STREAM
    
    private String fileStorePath = "";                                          //LOCATION OF THE FILE WHERE IT WILL BE STORED ON THE SERVER
    
    
    public FileTransferReceiver(int portNumber, String storePath) {
        //CONSTRUCTOR
        port = portNumber;
        fileStorePath = storePath;
    }
    
    private boolean initialiseServerSocket() {
        //METHOD TO INITIALISE SOCKET AND SERVER SOCKET
        try {
            receiveSocket = new ServerSocket(port);
            acceptSocket = receiveSocket.accept();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    private boolean initialiseServerSocket(int portNumber) {
        //METHOD TO INITIALISE SOCKET AND SERVER SOCKET
        //OVERLOADED TO ALLOW A PORT NUMBER ARGUMENT
        try {
            receiveSocket = new ServerSocket(portNumber);
            acceptSocket = receiveSocket.accept();
            return true;
        } catch (IOException e) {
            return false;
        }
     }
    
    private boolean initialiseStreams() {
        //INITIALISES THE STREAMS TO ENABLE THEM TO RECEIVE DATA FROM THE SOCKET AND WRITER A FILE
        try {
            receiverStream = acceptSocket.getInputStream();
            bufferSize = acceptSocket.getReceiveBufferSize();                   //GETS BUFFER SIZE
            
            byteArray = new byte[bufferSize];                                   //INITIALISES BYTE ARRAY
            
            fileWriter = new FileOutputStream(fileStorePath);
            out = new BufferedOutputStream(fileWriter);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    private boolean writeFile() {
        //RECEIVES THE BYTE STREAM FROM THE SOCKET
        //INSERTS IT INTO BYTE ARRAY
        //WRITES THE DATA INTO A FILE
        int index = 0;
        try {
            while ((index = receiverStream.read(byteArray)) > 0) {
               out.write(byteArray, 0, index);
            }
            receiveSocket.close();
            acceptSocket.close();
            fileWriter.flush();
            fileWriter.close();
            receiverStream.close();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean startReceiver() {
        if (initialiseServerSocket() == true) {
            if (initialiseStreams() == true) {
                if (writeFile() == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    //---------------------------------------------ACCESSOR METHODS------------
    
    public int getPort() {
        return port;
    }

    public void setPort(int portNumber) {
        port = portNumber;
    }
    
    public String getFileStorePath() {
        return fileStorePath;
    }
    
    public void setFileStorePath(String storePath) {
        fileStorePath = storePath;
    }
    
    public int getBufferSize() {
        return bufferSize;
    }
    
}

class FileReceiver extends FileTransferReceiver {
    
    private int port;
    private String path;
    
    FileReceiver(int portNumber, String pathToFile) {
        super(portNumber, pathToFile);
        port = portNumber;
        path = pathToFile;        
    }
    
    public String getFilePath() {
        SocketListener sl = new SocketListener(port);
        sl.startListener();
        path = sl.getMessage();
        super.setFileStorePath(path);
        return path;
    }
    
}
