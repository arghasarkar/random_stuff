package remotedesktop.transferWork;

import java.io.*;
import java.net.*;

public class SocketClass extends Socket {
    
    private ServerSocket listener = null;                                       //SERVER SOCKET DECLARATION
    private Socket listen = null;                                               //SOCKET DECLARATION
    private PrintWriter writer = null;                                          //WRITER DECLARATION FOR SOCKET
    private BufferedReader reader = null;                                       //READER DECLARATION FOR SOCKET
    
    private int portNumber = -1;                                                //PORT NUMBER
    private String hostName = "";                                               //HOST NAME
    
    private String message = "";                                                //MESSAGE TO BE SENT
    
    SocketClass(String host, int port) {                                        //CONSTRUCTOR CLASS
        hostName = host;
        portNumber = port;
    }
    
    SocketClass(String host, int port, String messageRead) {                                        //CONSTRUCTOR CLASS
        hostName = host;
        portNumber = port;
        message = messageRead;
    }
    
    public int startSocketServer() {
        /*
         * THIS METHOD INSTANTIATES THE SOCKET AND THE READER AND WRITER NEEDED TO READ FROM THE SOCKET
         * LISTEN IS THE SOCKET WORKING ON THE PORT NUMBER SENT AS AN ARGUMENT TO THIS CLASS
        */
        try {
            listener = new ServerSocket(portNumber);
            listen = listener.accept();
                                         
            return 1;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    
    public int startSocketClient() {
        try {
            listen = new Socket(hostName, portNumber);
            writer = new PrintWriter(listen.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(
                                            listen.getInputStream()));
            writer.println(message);
            return 1;
        } catch (IOException e) {
            return 0;
        }
    }
    
    public String Communicate () throws IOException {
        writer = new PrintWriter(listen.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(
                                        listen.getInputStream()));
        String readLine = "";
        readLine = reader.readLine();
        reader.close();
        writer.close();
        return readLine;
    }
    
    public int closeSocket() {
        try {
            /*
             * CLOSES SOCKET, WRITER AND THE READER
             * RETURNS 1 IF SUCCESSFUL AND 0 IF NOT
             */
            listener.close();
            listen.close();
            writer.close();
            reader.close();
            return 1;
        } catch (IOException e) {
            return 0;
        }        
    }
        
    public void changeSocket(int port) {
        this.closeSocket();
        portNumber = port;
        this.startSocketServer();
    }
   
}

