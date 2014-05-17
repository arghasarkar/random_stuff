package remotedesktop.tests;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author arghasarkar
 */
public class testServer extends javax.swing.JFrame {

    //GLOBAL VARIABLES ---------------------------------------------------------
    static ServerSocket ourSocket = null;
    int port;
    static Socket clientSocket = null;
    boolean setupComplete = false;
    
    static PrintWriter writer = null;
    static BufferedReader reader = null;
    
    ActionListener taskPerformer;                                               //DECLARES A NEW ACTION LISTENER TO BE USED FOR THE TIMER
    Timer doTask;
    
    //GLOBAL VARIABLES/---------------------------------------------------------
    
    public testServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Port:");

        jButton1.setText("Start Server");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField1.setText("8000");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(0, 6, Short.MAX_VALUE)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        setup();
        communicate();
    }//GEN-LAST:event_jButton1MouseClicked

    
    private void setup() {
        
        port = Integer.parseInt(jTextField1.getText());
        try {
            ourSocket = new ServerSocket(port);
            JOptionPane.showMessageDialog(null, "Port Opened: " + port);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot open port: " + port);
            System.exit(-1);
        }
        
        
        try {
            clientSocket = ourSocket.accept();
            JOptionPane.showMessageDialog(null, "Connection accepted on port: " + clientSocket.getPort());
        } catch (IOException e) {
            System.out.println("Accept failed: 4444");
            System.exit(-1);
        }
      
        
    }
    
    public void communicate() {
               
        try {
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error");
        }
        
        try {         
            String curLine = reader.readLine();
            while (true){
                this.setTitle(curLine);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error");
            System.out.println("error");
        }
        try {
            closeAll();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot close connections!");
        }
    
    }
    
    private void closeComs() throws IOException {
        writer.close();
        reader.close();
    }
    
    private void closeAll() throws IOException {
        ourSocket.close();
        clientSocket.close();
        writer.close();
        reader.close();
    }
    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(testServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testServer().setVisible(true);
            }
        });
        
        //------------------------------------------------------------------------------------------------------------------
        
        
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
