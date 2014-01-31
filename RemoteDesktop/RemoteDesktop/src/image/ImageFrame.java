package image;


import java.awt.Container;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class ImageFrame extends JFrame {
    
static JFrame f;
static ImageIcon icon;
static Container pane;
static JLabel label;
    
static int imgCount = 0;

    public ImageFrame(String title, String imageFileName) {
        setTitle(title);
        icon = new ImageIcon(imageFileName);
        pane = getContentPane();
        label = new JLabel(icon);
        pane.add(label);// adds to center region of default BorderLayout of pane
    }

    /**
    * Example of usage...
    *
    * @param args
    */
    public static void main(String[] args) {
//        f = new ImageFrame("Orca", "/Users/arghasarkar/Documents/pic2.jpg");
//        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        f.pack();
//        f.setVisible(true);
        String pathToImage1 = "/Users/arghasarkar/Documents/ss-test.jpg";
        f = new ImageFrame("Orca", pathToImage1);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        imgCount++;
        
        timerCall();
    }
    
    public static void timerCall() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                updateGraphics();
            }
        }, 0, 1);
    }
    
    public static void updateGraphics() {
        //proper way to push graphics execution to the GUI event thread...
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                String title = "Test Frame";
                String pathToImage1 = "/Users/arghasarkar/Documents/ss-test.jpg";
                String pathToImage2 = "/Users/arghasarkar/Documents/ss-test.jpg";
                
                f.setVisible(false);
                
                if (imgCount % 2 == 0) {
                    
                    f = new ImageFrame("Orca", pathToImage1);
                    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    f.pack();
                    f.setVisible(true);
                } else {
                    f = new ImageFrame("Orca", pathToImage2);
                    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    f.pack();
                    f.setVisible(true);
                }
                
                imgCount++;
                
                //setTitle(title);
//                icon = new ImageIcon(pathToImage);
//                pane = new Container();
////                pane = getContentPane().add;
//                label = new JLabel(icon);
//                pane.add(label);// adds to center region of default BorderLayout of pane
                
            }
        });
    }
}

