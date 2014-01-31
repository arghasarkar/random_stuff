package remotedesktop.transferWork;

import java.io.*;
import java.net.*;

/*
 * @author: ARGHA SAKRAR
 * 
 * PLEASE CHECK http://tinyurl.com/ErrCode FOR ERROR CODES
 */

public class SocketSender {
    
    private Socket senderSocket = null;                                         //SOCKET DECLARATION
    private PrintWriter writer = null;                                          //WRITER DECLARATION FOR SOCKET
    
    private String host = "";                                                   //HOST 
    private int port = -1;                                                      //PORT NUMBER
   
    private String message;                                                     //MESSAGE TO BE SENT
    
    public SocketSender(String hostName, int portNumber) {                             //CONSTRUCTOR WITHOUT MESSAGE
        host = hostName;
        port = portNumber;
    }
    
    public SocketSender(String hostName, int portNumber, String messageToBeSent) {     //CONSTRUCTOR WITH MESSAGE
        host = hostName;
        port = portNumber;
        message = messageToBeSent;
    }
       
    private int startSocket() {
        //CREATES AN INSTANT OF THE SOCKET WITH THE GIVEN HOST AND PORT
        try {
            senderSocket = new Socket(host, port);
            return 1;
        } catch (UnknownHostException e) {
            return -2;
        } catch (IOException e) {
            return -1;
        }
    }
    
    private int closeSocket() {
        //CLOSES HE PORT AND THE SOCKET
        try {
            senderSocket.close();
            writer.close();
            return 1;
        } catch (IOException e) {
            return -1;
        }
    }
    
    public int sendMessage(String messageToBeSent) {
        //METHOD TO START THE SOCKETS AND SEND A MESSAGE
        int status = startSocket();
        if (status == 1) {
            try {
                writer = new PrintWriter(senderSocket.getOutputStream(), true);
                writer.println(messageToBeSent);
                closeSocket();
                return 1;
            } catch (IOException e) {
                return -1;
            }
        } else {
            return status;
        }
    }
    
    public int sendMessage() {
        //METHOD TO START THE SOCKETS AND SEND A MESSAGE
        int status = startSocket();
        if (status == 1) {
            try {
                writer = new PrintWriter(senderSocket.getOutputStream(), true);
                writer.println(message);
                closeSocket();
                return 1;
            } catch (IOException e) {
                return -1;
            }
        } else {
            return status;
        }
    }
    
    public int sendByteArray(byte[] b) {
        int status = startSocket();
        if (status == 1) {
            try {
                writer = new PrintWriter(senderSocket.getOutputStream(), true);
                writer.println(b);
                closeSocket();
                return 1;
            } catch (IOException e) {
                return -1;
            }
        } else {
            return status;
        }
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
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String messageToBeSet) {
        message = messageToBeSet;
    }
    
}
