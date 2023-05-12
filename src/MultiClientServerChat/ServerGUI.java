package MultiClientServerChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServerGUI extends javax.swing.JFrame {
    public static ArrayList<String> ClientsNames = new ArrayList<>();
    public ServerGUI() {
        
        initComponents();
        new Server().start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        Exit = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setText("No of clinets");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countNumOfClinets(evt);
            }
        });

        jButton2.setText("show clinets");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showClinets(evt);
            }
        });

        ta1.setColumns(20);
        ta1.setRows(5);
        ta1.setFocusable(false);
        jScrollPane2.setViewportView(ta1);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showClinets(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showClinets
        if (ClientsNames.size()== 0){
            ta1.append("No Clients Connect \n");
        }
        for (int i = 0; i < ClientsNames.size(); i++) {
            ta1.append("Client : " + ClientsNames.get(i) + "\n");
        }
    }//GEN-LAST:event_showClinets

    private void countNumOfClinets(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countNumOfClinets
        ta1.append("Number of Clients : " + ClientsNames.size() + "\n");
    }//GEN-LAST:event_countNumOfClinets

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed

        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }
   
    public class Server extends Thread {
       
        int id = 1;
        ArrayList<ClientHandler> ClientRefrance = new ArrayList<>();
        boolean serverIsOn;
        
        Server() {

            serverIsOn = true;
            try {
                ServerSocket server = new ServerSocket(22000);
                Thread handleConnection = new Thread() {
                    @Override
                    public void run() {
                        
                        try {
                            while (serverIsOn) {
                                Socket clientSocket = server.accept();
                                ClientHandler clientHandler = new ClientHandler(clientSocket, id + "");
                                id++;
                                clientHandler.start();
                                synchronized (ClientRefrance) {
                                    ClientRefrance.add(clientHandler);
                                    
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                };

                handleConnection.start();

                Thread massageHandler = new Thread() {
                    @Override
                    public void run() {
                        ArrayList<String> massages;
                        while (serverIsOn) {
                            synchronized (ClientRefrance) {
                                for (int i = 0; i < ClientRefrance.size(); i++) {
                                    try {
                                        ClientHandler cTmp = ClientRefrance.get(i);
                                        massages = cTmp.getMassages();
                                        if (!massages.isEmpty()) {
                                            synchronized (massages) {
                                                for (int j = 0; j < massages.size(); j++) {
                                                    if (cTmp == null) {
                                                        break;
                                                    }
                                                    String cmd = massages.get(j).trim();
                                                    if (cmd.contains("@") && cmd.length() > 2) {
                                                        String part1 = cmd.substring(0, cmd.indexOf("@"));
                                                        if (part1.length() == cmd.length() - 1) {
                                                            continue;
                                                        }
                                                        String part2 = cmd.substring(part1.length() + 1);
                                                        switch (part1.toLowerCase()) {
                                                            case "all":
                                                                for (int k = 0; k < ClientRefrance.size(); k++) {
                                                                    if (ClientRefrance.get(k) != cTmp) {
                                                                        ClientRefrance.get(k).sendMassage(ClientsNames.get(i) + " to all : " + part2);
                                                                    }else {
                                                                        ClientRefrance.get(k).sendMassage("You to all: " + part2);
                                                                        ta1.append(ClientsNames.get(k)+ " send to all : " + part2 + "\n");
                                                                    }
                                                                }
                                                                break;
                                                            case "to":
                                                                part1 = part2.substring(0, part2.indexOf("@"));
                                                                if (part1.length() == part2.length() - 1) {
                                                                    break;
                                                                }
                                                                part2 = part2.substring(part1.length() + 1);
                                                                if (ClientsNames.contains(part1)) {
                                                                    for (int k = 0; k < ClientRefrance.size(); k++) {
                                                                        if (ClientsNames.get(k).equals(part1)) {
                                                                            ClientRefrance.get(k).sendMassage( ClientsNames.get(i)+ " send to You :" + part2);
                                                                        }else if (i==k) {
                                                                             ClientRefrance.get(k).sendMassage("You to " + part1+ " : " + part2);
                                                                             ta1.append(ClientsNames.get(k)+ " send to "+ part1+ " : " + part2 + "\n");
                                                                        }
                                                                    }
                                                                } else {
                                                                    cTmp.sendMassage("No one Using This Name");
                                                              }
                                                                break;
                                                            case "clientname":
                                                                ClientsNames.add(part2);
                                                                ta1.append(part2+" is connected\n");
                                                               new PrepareCLientList().start(); 
                                                                break;
                                                            case "exit":
                                                                for (int k = 0; k < ClientRefrance.size(); k++) {
                                                                        if (ClientsNames.get(k).equals(part2)) {
                                                                            ta1.append(part2+" disconnected..\n");
                                                                            ClientsNames.remove(k);
                                                                            new PrepareCLientList().start(); 
                                                                                                  }
                                                                }
                                                                cTmp.closeAll();
                                                                ClientRefrance.remove(cTmp);
                                                                cTmp = null;
                                                                break;
                                                        }
                                                    }
                                                }
                                                massages.clear();
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error Occured");
                                        ClientsNames.remove(ClientRefrance.get(i).GetClientName());
                                        ClientRefrance.get(i).closeAll();
                                        ClientRefrance.remove(i);
                                        i--;
                                    }
                                }
                            }
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                            }
                        }  //endwhile
                    }
                };
                massageHandler.start();
            } catch (IOException ex) {
            }
        }
        class PrepareCLientList extends Thread { // it prepares the list of active user to be displayed on the UI
		@Override
		public void run() {
			try {
				String ids = "#";
				for(int i =0;i<ClientsNames.size();i++) {
                                    
					ids += ClientsNames.get(i) + "#";
				}
                                System.out.println(ids);
				if (ids.length() != 0) { // just trimming the list for the safe side.
					ids = ids.substring(0, ids.length() - 1);
				}
				for(int i=0 ;i<ClientRefrance.size();i++) { // iterate over all active users
					try {
                                            ClientRefrance.get(i).sendMassage(ids);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
			}
		}
	}

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta1;
    // End of variables declaration//GEN-END:variables
}
