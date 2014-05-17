package mouse_movement;

import java.awt.MouseInfo;
import java.io.IOException;
import remotedesktop.transferWork.SocketSender;

public class mouse_sender {
    
    private static int port_number = 4321;
    private static String host_name = "127.0.0.1";
    
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
        //GETS THE CURSOR COORDINATES       
        int cursor_x = MouseInfo.getPointerInfo().getLocation().x;
        int cursor_y = MouseInfo.getPointerInfo().getLocation().y;
       
        while (true) {
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
    
    /*
    public static void main(String[] args) throws IOException {
        //GETS THE CURSOR COORDINATES       
        int cursor_x = MouseInfo.getPointerInfo().getLocation().x;
        int cursor_y = MouseInfo.getPointerInfo().getLocation().y;
       
        while (true) {
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
    */
}
