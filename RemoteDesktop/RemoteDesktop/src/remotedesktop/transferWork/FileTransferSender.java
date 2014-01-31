package remotedesktop.transferWork;

/*
 * @author ARGHA SARKAR
 */

import remotedesktop.transferWork.SocketSender;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileTransferSender {
    
    private String host = "";                                                   //HOST 
    private int port = -1;                                                      //PORT NUMBER
    private Socket sendSocket = null;                                           //SOCKET THAT WILL BE USED TO SEND THE BINARY DATA
    
    private String clientFilePath = "";                                         //FILE PATH ON THE CLIENT/SENDER COMPUTER
    private String serverFilePath = "";                                         //FILE PATH ON THE SERVER/RECEIVER COMPUTER
    private File f;                                                             //FILE CLASS 
     
    private FileInputStream fileReader = null;                                  //BINARY READER USED TO READ THE FILE ON THE CLIENT COMPUTER
    private BufferedInputStream in = null;                                      //BUFFERED INPUT STREAM TO READ THE BINARY FILE READER
    private BufferedOutputStream out = null;                                    //BUFFERED OUTPUT STREAM TO SEND THE DATA VIA THE SOCKET

    public FileTransferSender(String hostName, int portNumber, String pathToFile) {
        //CONSTRUCTOR
        host = hostName;
        port = portNumber;
        clientFilePath = pathToFile;
    }
    
    private boolean initialiseSocket() {  //---------------   ----------------COONECTION IS BEING REFUSED HERE!!!!!
        //TRIES TO INITIALISE SOCKET WITH THE GIVEN HOST AND PORT NUMBER
        //RETURNS TRUE IF THE SOCKET HAS BEEN INITIALISED. FALSE IF IT FAILS TO INITALISE THE SOCKET
        try {
            sendSocket = new Socket(host, port);
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage() + " line 42");
            return false;
        }
    }
    

    private boolean transmitFile() {
        //RETURNS TRUE IF FILE WAS TRANSMITTED SUCCESSFULLY. FALSE IF NOT
        try {
            f = new File(clientFilePath);                                       //INITIALISES THE FILE
            if (validFile() == true) {
                               
                long fileSize = f.length();                                     //GETS THE FILE'S SIZE
                byte[] byteArray = new byte[(int) fileSize];                    //DECLARES AND INITIALSES THE BYTE ARRAY WHICH WILL CONTAIN ALL THE FILE DATA
                int index = 0;                                                  //INDEX FOR LOOP TO TRANSMIT DATA
                
                //INITIALISES THE FILE READER AND THE I/O STREAMS
                fileReader = new FileInputStream(f);                            //INITIALISES BINARY FILE READER
                in = new BufferedInputStream(fileReader);                       //INITIALISES THE BUFFERED INPUT STREAM WITH THE ARGUMENT BEING THE BINARY DATA FROM THE BINARY FILE READER
                out = new BufferedOutputStream(sendSocket.getOutputStream());   //INITIALISES OUTPUT STREAM WITH THE OUTPUT STREAM OF THE SOCKET
                
                
                while ((index = in.read(byteArray)) > 0) {                      //LOOP TO ITERATE THROUGH ARRAY AND TRANSMIT DATA
                    out.write(byteArray, 0, index);
                }
                
                //CLOSES SOCKET AND STREAMS TO RELEASE THE RESOURCES
                out.flush();
                out.close();
                in.close();
                fileReader.close();
                sendSocket.close(); 
                
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage() + "line 79");
            return false;
        }
    }
    
    public boolean sendFile() {
        if (initialiseSocket() == true) {
            if (transmitFile() == true) {
                return true;
            }
        }
        return false;
    }
    
    
    private boolean validFile() {
        //A FILE IS CONSIDERED AS A VALID FILE IF IT EXISTS AND HAS A LENGTH LESS THAN THE MAX INTEGER VALUE
        if ((fileExists(clientFilePath) == true) && (f.length() < Integer.MAX_VALUE)) {
            return true;
        } 
        return false;
    }
    
    private boolean validFile(String pathToFile) {
        //A FILE IS CONSIDERED AS A VALID FILE IF IT EXISTS AND HAS A LENGTH LESS THAN THE MAX INTEGER VALUE
        File testFile = new File(pathToFile);
        if (fileExists(pathToFile) == true & testFile.length() < Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }

    private boolean fileExists() {
        File testFile = new File(clientFilePath);
        return testFile.exists();
    }
    
    private boolean fileExists(String pathToFile) {
        File testFile = new File(pathToFile);
        return testFile.exists();
    }
    
    
    //--------------------------------------------------------------------------ACCESSOR METHODS ---------------------------------
    
    public String getHost() {
        return host;
    }
    
    public void setHost(String input) {
        host = input;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int input) {
        port = input;
    }
    
    public String getClientFilePath() {
        return clientFilePath;
    }
    
    public void setClientFilePath(String input) {
        clientFilePath = input;
    }
    
    public String getServerFIlePath() {
        return serverFilePath;
    }
    
    public void setServerFilePath(String input) {
        serverFilePath = input;
    }
    
}

class FileSender extends FileTransferSender {
    
    private String pathMessage = "";
    private String host = "";
    private int port = 0;
    
    FileSender(String hostName, int portNumber, String pathToFile, String receivePath) {
        super(hostName, portNumber, pathToFile);
        host = hostName;
        port = portNumber;
        pathMessage = receivePath;
    }
    
    public void sendFilePath() {
            SocketSender ss = new SocketSender(host, port, pathMessage);
            ss.sendMessage();
    }
    
}