package mouse_movement;

import java.awt.AWTException;
import java.awt.Robot;

import remotedesktop.transferWork.SocketListener;

public class mouse_receiver {
    
    //SETS THE HOST NAME AND PORT NUMBER
    private static int port_number = 4321;
    private static String host_name = "127.0.0.1";
    
    public mouse_receiver() { }
    
    public mouse_receiver(String host, int port) {
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
    
    public void start_receiver() {
        int mouse_x = 0, mouse_y = 0;
        String[] mouse_coordinates = new String[2];
        while (true) {
            SocketListener listener = new SocketListener(host_name, port_number);
            listener.startListener();
            String message = listener.getMessage();
            
            try {
                Robot r = new Robot();
                mouse_coordinates = message.split(",");
                mouse_x = Integer.parseInt(mouse_coordinates[0]);
                mouse_y = Integer.parseInt(mouse_coordinates[1]);
                r.mouseMove(mouse_x, mouse_y);
            } catch (AWTException ex) {
                System.err.println(ex.getMessage());
                                                                     //ERROR
            }
            System.out.println(message);                                                          //EVERYTHING IS OK
        }
    }
    
    public static void main(String[] args) throws AWTException {
        
        int mouse_x = 0, mouse_y = 0;
        String[] mouse_coordinates = new String[2];
        while (true) {
            SocketListener listener = new SocketListener(host_name, port_number);
            listener.startListener();
            String message = listener.getMessage();
            
            Robot r = new Robot();
            mouse_coordinates = message.split(",");
            mouse_x = Integer.parseInt(mouse_coordinates[0]);
            mouse_y = Integer.parseInt(mouse_coordinates[1]);
            r.mouseMove(mouse_x, mouse_y);
            System.out.println(message);
        }
    }
    
}
