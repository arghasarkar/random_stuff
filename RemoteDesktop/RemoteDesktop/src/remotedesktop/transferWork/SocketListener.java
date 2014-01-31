package remotedesktop.transferWork;

import java.io.*;
import java.net.*;

/*
 * @author: ARGHA SAKRAR
 * 
 * PLEASE CHECK http://tinyurl.com/ErrCode FOR ERROR CODES
 */

public class SocketListener {
   
    private ServerSocket listener = null;                                       //SERVER SOCKET DECLARATION
    private Socket listen = null;                                               //SOCKET DECLARATION
    private BufferedReader reader = null;                                       //READER DECLARATION FOR SOCKET
    
    private String host = "";                                                   //HOST 
    private int port = -1;                                                      //PORT NUMBER
    
    public SocketListener(String hostName, int portNumber) {
        host = hostName;
        port = portNumber;
    }
    
    public SocketListener(int portNumber) {
        port = portNumber;
    }
    
    public int startListener() {
        //STARTS LISTENER AT THE PORT DECLARED DURING INSTANTIATION
         try {
            listener = new ServerSocket(port);
            listen = listener.accept();                      
            return 1;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int startListener(int portNumber) {
        //STARTS LISTENER AT A PARTICULAR PORT
         try {
            listener = new ServerSocket(portNumber);
            listen = listener.accept();                      
            return 1;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    private String listen() {
        try {
            reader = new BufferedReader(new InputStreamReader(
                                            listen.getInputStream()));
            String readLine = "";
            readLine = reader.readLine();
            listener.close();
            listen.close();
            reader.close();
            
            return readLine;
        } catch (IOException e) {
            return "-1";
        }
    }
    
    private byte[] listenToByteArray() {
        byte[] receivedArray;
        try {
            reader = new BufferedReader(new InputStreamReader(
                                            listen.getInputStream()));
            receivedArray = reader.readLine().getBytes();
        } catch (IOException e) {
            return receivedArray = new byte[0];
        }
        return receivedArray;
    }
    
    public String getMessage() {
        return this.listen();
    }
    
    public byte[] getByteArray() {
        return this.listenToByteArray();
    }
    
    public String getHost() {
        return host;
    }
    
    public void setHost(String hostToBeSet) {
        host = hostToBeSet;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int portToBeSet) {
        port = portToBeSet;
    }
}

