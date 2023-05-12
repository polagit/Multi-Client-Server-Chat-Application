package MultiClientServerChat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author POLA
 */
public class ClientHandler extends Thread{
    Socket client;
    boolean isOn;
    String Name;
    DataInputStream input;
    DataOutputStream output;
    ArrayList<String>ReceivedMassages=new ArrayList<>();
    ClientHandler(Socket clientSocket,String Name){
        client =clientSocket;
        isOn=true;
        this.Name=Name;
        try {
            input=new DataInputStream(client.getInputStream());
             output=new DataOutputStream(client.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        try{
            String str;
            while(isOn){
              str= input.readUTF();
              synchronized(ReceivedMassages){
                ReceivedMassages.add(str);
            }
        }
        }catch(IOException e){
        
            e.printStackTrace();
        }
        try {
            if(output!=null){
            output.close();}
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
              if(input!=null){
            input.close();}
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
             if(client!=null){
            client.close();}
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendMassage(String str){
    
    try{
        if (isOn){
        output.writeUTF(str);}
        }catch(IOException e){
        
            e.printStackTrace();
        }
    }
    public ArrayList<String>getMassages(){
    return ReceivedMassages;
    
    }
    public void setClientName(String Name){
    this.Name=Name;
    
    }
    public String GetClientName(){
     return Name;
             
    }
    public void closeAll(){
        isOn=false;
        try{client.close();}catch(Exception e){}
        try{input.close();}catch(Exception e){}
        try{output.close();}catch(Exception e){}
    
    }
    
}
