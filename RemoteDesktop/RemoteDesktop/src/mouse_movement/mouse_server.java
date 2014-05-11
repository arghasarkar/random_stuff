package mouse_movement;

import java.awt.MouseInfo;
import java.io.IOException;
import remotedesktop.transferWork.SocketSender;

public class mouse_server {
    
    private static int port_no = 4321;
    private static String host = "127.0.0.1";
    
    public static void main(String[] args) throws IOException {
        //GETS THE CURSOR COORDINATES
        int cursor_x = MouseInfo.getPointerInfo().getLocation().x;
        int cursor_y = MouseInfo.getPointerInfo().getLocation().y;
       
        while (true) {
            //CHECKS WHEN THE CURSOR POSITION HAS CHANGED
            if (cursor_x != MouseInfo.getPointerInfo().getLocation().x || cursor_y != MouseInfo.getPointerInfo().getLocation().y) {
                String send_info = cursor_x + "," + cursor_y;
                SocketSender sender = new SocketSender(host, port_no);
                sender.sendMessage(send_info);
                //System.out.println("Mouse x: " + cursor_x + "\t" + "y: " + cursor_y );
                cursor_x = MouseInfo.getPointerInfo().getLocation().x;
                cursor_y = MouseInfo.getPointerInfo().getLocation().y;
            }
        }
    }
}
