package mouse_movement;

import remotedesktop.transferWork.SocketListener;

public class mouse_client {
    
    private static int port_no = 4321;
    private static String host = "127.0.0.1";
    
    public static void main(String[] args) {
        
        while (true) {
            SocketListener listener = new SocketListener(host, port_no);
            listener.startListener();
            String message = listener.getMessage();
            System.out.println(message);
        }
    }
    
}
