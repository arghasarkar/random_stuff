package mouse_movement;

import java.awt.MouseInfo;
import remotedesktop.transferWork.SocketSender;

public class mouse_sender implements Runnable {
    
    private boolean on = false;                                                 //BOOLEAN FLAG TO TURN OFF THE LOOP
    
    private static int port_number = 4321;                                      //PORT NUMBER
    private static String host_name = "127.0.0.1";                              //HOST NAME - CAN BE IP ADDRESS.
    
    public mouse_sender() { }
    
    public mouse_sender(String host, int port) {
        port_number = port;
        host_name = host;
    }
    
    public int get_port() {
        return port_number;
    }
    
    public void set_port(int port) {
        port_number = port;
    }
    
    public String get_host() {
        return host_name;
    }
    
    public void set_host(String host) {
        host_name = host;
    }
    
    public void start_sender() {
        //TURNS THE FLAG ON
        on = true;                                                      
        
        //GETS THE CURSOR COORDINATES       
        int cursor_x = MouseInfo.getPointerInfo().getLocation().x;
        int cursor_y = MouseInfo.getPointerInfo().getLocation().y;
       
        while (on) {
            //CHECKS WHEN THE CURSOR POSITION HAS CHANGED
            if (cursor_x != MouseInfo.getPointerInfo().getLocation().x || cursor_y != MouseInfo.getPointerInfo().getLocation().y) {
                String send_info = cursor_x + "," + cursor_y;
                SocketSender sender = new SocketSender(host_name, port_number);
                sender.sendMessage(send_info);
                cursor_x = MouseInfo.getPointerInfo().getLocation().x;
                cursor_y = MouseInfo.getPointerInfo().getLocation().y;
            }
        }   
    }
    
    public void stop_sender() {
        //TURNS THE FLAG OFF
        on = false;     
    }

    @Override
    public void run() {
        if (on == true) {
            on = false;
            stop_sender();
        } else {
            on = true;
            start_sender();
        }
        
    }
   
}
