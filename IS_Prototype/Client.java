import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.*;


public class Client extends JFrame{
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    static JFrame J1,J2,J3,J4,J5,J6,J7,J8,J9,J10;    
        
    Client(){
         J1 = new JFrame("TV SCREEN - HOME");
         J1.add(new JLabel(new ImageIcon("Image1.jpg")));
         
         J2 = new JFrame("TV SCREEN - NETFLIX");
         J2.add(new JLabel(new ImageIcon("Image2.jpg")));
         
         J3 = new JFrame("TV SCREEN - AMAZON PRIME");
         J3.add(new JLabel(new ImageIcon("Image3.jpg")));
         
         J4 = new JFrame("TV SCREEN - HOTSTAR");
         J4.add(new JLabel(new ImageIcon("Image4.jpg")));
         
         J5 = new JFrame("TV SCREEN - ZEE");
         J5.add(new JLabel(new ImageIcon("Image5.jpg")));
         
         J6 = new JFrame("TV SCREEN - VOOT");
         J6.add(new JLabel(new ImageIcon("Image6.jpg")));
        
         J7 = new JFrame("TV SCREEN - UTUBE");
         J7.add(new JLabel(new ImageIcon("Image7.jpg")));
         
         J8 = new JFrame("TV SCREEN - PHONE BOOK");
         J8.add(new JLabel(new ImageIcon("Image8.jpg")));
        
         J9 = new JFrame("TV SCREEN - GALLERY");
         J9.add(new JLabel(new ImageIcon("Image9.jpg")));
        
         J10 = new JFrame("TV SCREEN - GMAIL");
         J10.add(new JLabel(new ImageIcon("Image10.jpg")));
         
         J1.setBounds(600,100,740,495);
         J2.setBounds(600,100,740,495);
         J3.setBounds(600,100,740,495);
         J4.setBounds(600,100,740,495);
         J5.setBounds(600,100,740,495);
         J6.setBounds(600,100,740,495);
         J7.setBounds(600,100,740,495);
         J8.setBounds(600,100,740,495);
         J9.setBounds(600,100,740,495);
         J10.setBounds(600,100,740,495);     
    }
    
    public static void main(String[] args){
        
        Client temp1=new Client();
        temp1.J1.setVisible(true);
        
        try{   
            s = new Socket("127.0.0.1", 6001);
            din  = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
	    while(true){
                String msginput;
	            msginput = din.readUTF();
            	System.out.println(msginput);
                if(msginput.equals("NETFLIX"))
                {
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(true);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("AMAZON_PRIME")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(true);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("HOTSTAR")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(true);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("ZEE")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(true);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("VOOT")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(true);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("UTUBE")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(true);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("PHONE_BOOK")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(true);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("GALLERY")){
                    System.out.println("Hellow"+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(true);
                    temp1.J10.setVisible(false);
                }
                else if(msginput.equals("GMAIL")){
                    System.out.println("Hellow "+msginput);
                    temp1.J1.setVisible(false);
                    temp1.J2.setVisible(false);
                    temp1.J3.setVisible(false);
                    temp1.J4.setVisible(false);
                    temp1.J5.setVisible(false);
                    temp1.J6.setVisible(false);
                    temp1.J7.setVisible(false);
                    temp1.J8.setVisible(false);
                    temp1.J9.setVisible(false);
                    temp1.J10.setVisible(true);
                }
                else if(msginput.equals("UTX100_484A_ERROR")){
                    System.out.println("Hellow "+msginput);
                    System.exit(0);   
                }
                }
            }
            catch(Exception e){}
    }    
}