package MultiClientServerChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;


public class ClientGUI extends javax.swing.JFrame {
    String name;
    InetAddress Ip;
    Socket other ;
    DataInputStream otherReadSource;
    DataOutputStream otherWriteSource;
    DefaultListModel<String> dm;

            
    
    public ClientGUI(String name) throws IOException {
        this.Ip = InetAddress.getLocalHost();
        this.other = new Socket(this.Ip, 22000);
        this.name = name; 
        otherReadSource = new DataInputStream(other.getInputStream());
        otherWriteSource = new DataOutputStream(other.getOutputStream());
        otherWriteSource.writeUTF("clientName@"+name);
        initComponents();
        ClientName.setText(name);
        new Client().start();
        dm = new DefaultListModel<String>();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ChatTA2 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        MsgTF2 = new javax.swing.JTextField();
        SendButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        ClientName = new javax.swing.JLabel();
        ActiveClientList = new javax.swing.JTextArea();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(450, 400));

        jLabel7.setText(" Hello : ");

        ChatTA2.setColumns(20);
        ChatTA2.setRows(5);
        ChatTA2.setFocusable(false);
        jScrollPane5.setViewportView(ChatTA2);

        jLabel8.setText("Your Msg");

        MsgTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgTF2ActionPerformed(evt);
            }
        });

        SendButton2.setText("Send");
        SendButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Clients");

        Exit.setText("Disconnect");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        ClientName.setText(".................");

        ActiveClientList.setColumns(20);
        ActiveClientList.setRows(5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClientName))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MsgTF2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(SendButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ActiveClientList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Exit)
                    .addComponent(ClientName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(ActiveClientList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(MsgTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SendButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 476, 438);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        try {
            otherWriteSource.writeUTF("exit@"+name);
            this.dispose();
            System.exit(0);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void SendButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButton2ActionPerformed
        try {  
            otherWriteSource.writeUTF(MsgTF2.getText());
            MsgTF2.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }//GEN-LAST:event_SendButton2ActionPerformed

    private void MsgTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MsgTF2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClientGUI("").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    class Client extends Thread {

        Client() {
            try {
                
                Scanner scan = new Scanner(System.in);
                Thread t = new Thread() {
                    public void run() {
                        String str = "";
                        try {
                            while (true) {
                               
                                str = otherReadSource.readUTF();
                                if (str.contains("#") && str.length() > 2) {
                                    String s[]=str.split("#");
                                    ActiveClientList.setText("");
                                    for (int i = 1; i < s.length; i++) {
                                        if(!name.equals(s[i])){
                                         ActiveClientList.append(s[i]+"\n");
                                         }
                                    }
                                }else {
                                    ChatTA2.append(str+"\n");
                                }
                            }
                        } catch (Exception e) {
                        }
                    }

                };
                t.start();
            } catch (Exception e) {
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ActiveClientList;
    private javax.swing.JTextArea ChatTA2;
    private javax.swing.JLabel ClientName;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField MsgTF2;
    private javax.swing.JButton SendButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
