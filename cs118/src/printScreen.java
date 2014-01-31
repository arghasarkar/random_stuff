import java.awt.*;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.IOException;
import javax.swing.*;
import java.io.File;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.awt.event.InputEvent;

/**
 *
 * @author arghasarkar - @AGGASarkar
 */
public class printScreen extends javax.swing.JFrame {
 
    public printScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Screen Capture");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setText("Storage location:");

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Start");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        jLabel6.setText("No. of shots:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Capture interval:");

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel9.setText("mins");

        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jLabel10.setText("secs");

        jLabel11.setText("mils");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel8)
                    .add(jLabel6))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSlider1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel9)
                        .add(18, 18, 18)
                        .add(jSlider2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel10)
                        .add(18, 18, 18)
                        .add(jSlider3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel11)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(jSlider1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(jSlider2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(jSlider3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        jLabel7.setText("File format:");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText(".jpg");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        jCheckBox2.setText(".png");
        jCheckBox2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox2StateChanged(evt);
            }
        });

        jCheckBox3.setText(".bmp");
        jCheckBox3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox3StateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel7)
                .add(37, 37, 37)
                .add(jCheckBox1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jCheckBox2)
                .add(94, 94, 94)
                .add(jCheckBox3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jCheckBox1)
                    .add(jCheckBox2)
                    .add(jCheckBox3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setText("Select Screen Area");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(180, 180, 180)
                .add(jLabel2)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        jButton2.setText("Screen Area");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //GLOBAL VARIABLES - START
    Storage store = new Storage();                                              //THIS IS THE CLASS MADE TO STORAGE THE DETAILS ABOUT STORAGE
    private static Rectangle Rectangle;                                         //USED FOR SCREEN SHOT
    ActionListener taskPerformer;                                               //DECLARES A NEW ACTION LISTENER TO BE USED FOR THE TIMER
    Timer doTask = new Timer(store.getDelay(), taskPerformer);                  //SETS UP TIMER
    boolean SASV = true;                                //FLAG TO CHECK IF THE SCREEN AREA SETTINGS IS VISIBLE OR NOT
    //GLOBAL VARIABLES - END
    
    public void setupStartStop() {
        try {  
            try {
                int shotsLeft = Integer.parseInt(jTextField5.getText());        //GETS THE NUMBER OF SCREEN SHOTS TO TAKE
                //CALCULATES AND STORES THE TIME INVERVAL BETWEEN EACH SCREENS SHOT
                store.calcDelay(calcTimeValue(jSlider1.getValue(),0), calcTimeValue(jSlider2.getValue(),1), calcTimeValue(jSlider3.getValue(),2));
                store.setShotsCount(shotsLeft);

                doTask.removeActionListener(taskPerformer);
                taskPerformer = null;
                doTask = null;

                taskPerformer = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            try {
                                if (store.getTimerStatus() == true) {
                                    doTask.setDelay(store.getDelay());
                                    screenShot();
                                } else {
                                    doTask.stop();
                                    store.setTimerStatus(false);
                                }
                                System.out.println("" + doTask.getDelay());
                            } catch (IOException ioe) {}
                        } catch (AWTException awte) { }   
                    }   
                 };

                doTask = new Timer(store.getDelay(), taskPerformer);

                System.out.println("" + store.getDelay());
                if (store.getTimerStatus() == true ) {
                    doTask.stop();
                    store.setTimerStatus(false);
                    jButton1.setText("Start");
                    jTextField5.setEnabled(true);
                } else {
                    doTask.start();
                    store.setTimerStatus(true);
                    jButton1.setText("Stop");
                    jTextField5.setEnabled(false);
                }
                
            } catch (NumberFormatException nfe) { }   
            
        } catch (NullPointerException npe) {
            //System.err.println(npe.getMessage());
        }
    }
    
    public int filesInDir() {
        int noOfFiles = new File(store.getFolderLocation()).listFiles().length;
        return noOfFiles;
    }
    
    public void screenShot() throws AWTException, IOException {                       
        Robot robot = new Robot();
        Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle = new Rectangle(a);
        BufferedImage img = robot.createScreenCapture(Rectangle);
        int numberOfImages = filesInDir();
        numberOfImages++;
        
        //MANAGING NUMBER OF SHOTS LEFT - START
        int shotsLeft = store.getShotsCount();
        shotsLeft--;
        jTextField5.setText("" + shotsLeft);
        store.setShotsCount(shotsLeft);
        if (shotsLeft < 1) {
            Toolkit.getDefaultToolkit().beep();
            setupStartStop();
        } 
        //MANAGING NUMBER OF SHOTS LEFT - END
        
        //PERFORMING A CLICK - START
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //PERFORMING A CLICK - END
        
        if (jCheckBox1.isSelected() == true) {
            String storeLocation = store.getFolderLocation() + "/img" + numberOfImages + ".jpg";
            ImageIO.write(img, "jpg", new File(storeLocation));
            store.setJpgStatus(true);
        }
        
        if (jCheckBox2.isSelected() == true ) {
            String storeLocation = store.getFolderLocation() + "/img" + numberOfImages + ".png";
            ImageIO.write(img, "png", new File(storeLocation));
            store.setPngStatus(true);
        }
        
        if (jCheckBox3.isSelected() == true ) {
            String storeLocation = store.getFolderLocation() + "/img" + numberOfImages + ".bmp";
            ImageIO.write(img, "bmp", new File(storeLocation));
            store.setBmpStatus(true);
        }
    }
    
    public static boolean fileExists(String fileLoc) {                          //METHOD TO RETURN TRUE IF A FILE EXISTS OR FALSE IF IT DOES NOT EXIST
        boolean fileStatus = false;
        File checkFile = new File(fileLoc);
        if (checkFile.exists() == true) {
            fileStatus = true;
        }
        return fileStatus;
    }
    
    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // DISPLAYS DIALOG BOX TO CHOOSE FOLDER LOCATION    
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(fc);
        try {
            jTextField1.setText(fc.getSelectedFile().getPath());
            store.setFolderLocation(jTextField1.getText());
        } catch (java.lang.NullPointerException npe) { } 
    }//GEN-LAST:event_jTextField1MouseClicked
    
    public int calcTimeValue(double value, int state) {
        int returnValue = 0;
        switch (state) {
            case 0 : {
                value = value / 100;
                value  = value * 60;
                returnValue = (int) Math.round(value);
                return returnValue;
            }
            case 1 : {
                value = value / 100;
                value  = value * 60;
                returnValue = (int) Math.round(value);
                return returnValue;
            }
            case 2 : {
                value = value * 10;
                returnValue = (int) Math.round(value);
                return returnValue;
            } 
            default: return 999;
        }
    }
    
    public int[] mouseLocation() {
        int [] Location = new int[2];                                           //CREATES A TWO ELEMENT ARRAY
        PointerInfo curDetails = MouseInfo.getPointerInfo();                    //SETS A POINTER VARAIBLE AND GETS CURSOR'S DETAILS
        Point curLocation = curDetails.getLocation();                           //GETS THE CURSOR'S LOCATION FROM THE POINTER VARAIBLE
        Location[0] = (int) curLocation.getX();                                 //SETS THE FIRST ELEMENT AS X COORDINATE
        Location[1] = (int) curLocation.getY();                                 //SETS THE SECOND ELEMENT AS Y COORDINATE
        return Location;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        setupStartStop();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged
        store.setFolderLocation(jTextField1.getText());
    }//GEN-LAST:event_jTextField1InputMethodTextChanged
    
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        store.calcDelay(calcTimeValue(jSlider1.getValue(),0), calcTimeValue(jSlider2.getValue(),1), calcTimeValue(jSlider3.getValue(),2));
        this.setTitle("Screen Shot App: " + calcTimeValue(jSlider1.getValue(),0) + "m " + calcTimeValue(jSlider2.getValue(),1) + "s " + calcTimeValue(jSlider3.getValue(), 2) + "ms");
        //System.out.println("" + calcTimeValue(jSlider1.getValue(), 0)  + "   delay: " + store.getDelay());
        //jTextField2.setText("" + calcTimeValue(jSlider1.getValue(), 0));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        store.calcDelay(calcTimeValue(jSlider1.getValue(),0), calcTimeValue(jSlider2.getValue(),1), calcTimeValue(jSlider3.getValue(),2));
        this.setTitle("Screen Shot App: " + calcTimeValue(jSlider1.getValue(),0) + "m " + calcTimeValue(jSlider2.getValue(),1) + "s " + calcTimeValue(jSlider3.getValue(), 2) + "ms");
        //System.out.println("" + calcTimeValue(jSlider2.getValue(), 1) + "   delay: " + store.getDelay());
        //jTextField3.setText("" + calcTimeValue(jSlider2.getValue(), 1));
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        store.calcDelay(calcTimeValue(jSlider1.getValue(),0), calcTimeValue(jSlider2.getValue(),1), calcTimeValue(jSlider3.getValue(),2));
        this.setTitle("Screen Shot App: " + calcTimeValue(jSlider1.getValue(),0) + "m " + calcTimeValue(jSlider2.getValue(),1) + "s " + calcTimeValue(jSlider3.getValue(), 2) + "ms");
        //System.out.println("" + calcTimeValue(jSlider3.getValue(), 2) + "   delay: " + store.getDelay());
        //jTextField4.setText("" + calcTimeValue(jSlider3.getValue(), 2));
    }//GEN-LAST:event_jSlider3StateChanged

    private void jCheckBox3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox3StateChanged
        boolean cbStatus = jCheckBox3.isSelected();
        store.setBmpStatus(cbStatus);
    }//GEN-LAST:event_jCheckBox3StateChanged

    private void jCheckBox2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox2StateChanged
        boolean cbStatus = jCheckBox2.isSelected();
        store.setPngStatus(cbStatus);
    }//GEN-LAST:event_jCheckBox2StateChanged

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        boolean cbStatus = jCheckBox1.isSelected();
        store.setJpgStatus(cbStatus);
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        SASVmethod();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SASVmethod() {
        if (SASV == true) {
            jPanel4.setVisible(false);
            jPanel4.setSize(0,0);
            this.setSize(this.getWidth(), this.getHeight() - 107);
            SASV = false;
        } else {
            jPanel4.setVisible(true);
            jPanel4.setSize(300,1000);
            this.setSize(this.getWidth(), this.getHeight() + 107);
            SASV = true;
        }
    }
    /**
     * @param args the command line arguments s
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(printScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printScreen().setVisible(true);
            }
        }); 
        //jButton2.doClick();
    }
    
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    static class Storage {
        private String folderLocation = "";                                     //STRING INDICATING THE FOLDER LOCATION
        private boolean folderExists = false;                                   //TRUE IF THE FOLDER EXITS
        private boolean folderSelected = false;                                 //TRUE WHEN THE STORAGE FOLDER HAS BEEN SELECTED
        private boolean timerOn = false;                                        //TRUE IF THE SCREEN SHOT APP IS ON. FALSE IF OFF
        private int delay = 50;                                                 //THE DELAY FOR THE SCREEN SHOT
        private boolean jpgStatus = true;                                       //STATUS TO SHOW IF THE STORE FORMAT IS TRUE
        private boolean pngStatus = false;                                      ////STATUS TO SHOW IF THE STORE FORMAT IS TRUE
        private boolean bmpStatus = false;                                      //STATUS TO SHOW IF THE STORE FORMAT IS TRUE
        private int shotsCount = 0;                                             //NUMBER OF SCREEN SHOTS TO BE TAKEN
        
        public void setFolderLocation(String loc) {
            folderLocation = loc;
        }
        
        public String getFolderLocation() {
            return folderLocation;
        }
        
        public void setFolderExists(boolean status) {
            folderExists = status;
        }
        
        public boolean getFolderExists() {
            return folderExists;
        }
        
        public void setFolderSelected(boolean status) {
            folderSelected = status;
        }
        
        public boolean getFolderSelected() {
            return folderSelected;
        }   
        
        public void setTimerStatus(boolean status) {
            timerOn = status;
        }
        
        public boolean getTimerStatus() {
            return timerOn;
        }
        
        public void setDelay(int timerDelay) {
            delay = timerDelay;
        }
        
        public void calcDelay(int mins, int secs, int ms) {
            int calculatedDelay = ms + (1000 * secs) + (1000 * 60 * mins);
            delay = calculatedDelay;
        }
        
        public int getDelay() {
            return delay;
        }
        
        public void setJpgStatus(boolean status) {
            jpgStatus = status;
        }

        public boolean getJpgStatus() {
            return jpgStatus;
        }
        
        public void setPngStatus(boolean status) {
            pngStatus = status;
        }
        
        public boolean getPngStauts(boolean status) {
            return pngStatus;
        }
        
        public void setBmpStatus(boolean status) {
            bmpStatus = status;
        }
        
        public boolean getBmpStatus(boolean status) {
            return bmpStatus;
        }
        
        public void setShotsCount(int count) {
            shotsCount = count;
        }
        
        public int getShotsCount() {
            return shotsCount;
        }
    }
    
}
