import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Server extends JFrame implements ActionListener{
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    
    Server(){

       setTitle("Mobile Screen");
       setBounds(30,20,480,700);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);

       setLayout(new BorderLayout());
       setContentPane(new JLabel(new ImageIcon("Images//mobile.jpg")));
       setLayout(null);

       b1 = new JButton("Image Button", new ImageIcon("Images//b1.jpg"));
       b1.setBounds(137, 160, 50, 50);
       b1.setHorizontalTextPosition(AbstractButton.CENTER);
       b1.setVerticalTextPosition(AbstractButton.BOTTOM);
       b1.setBackground(new Color(8, 94, 84));
       b1.addActionListener(this);
       add(b1);

       b2 = new JButton("Image Button", new ImageIcon("Images//b2.png"));
       b2.setHorizontalTextPosition(AbstractButton.CENTER);
       b2.setBounds(202,160, 50, 50);
       b2.addActionListener(this);
       add(b2);

       b3 = new JButton("Image Button", new ImageIcon("Images//b3.png"));
       b3.setBounds(270, 160, 50, 50);
       b3.setHorizontalTextPosition(AbstractButton.CENTER);
       b3.addActionListener(this);
       add(b3);

       b4 = new JButton("Image Button", new ImageIcon("Images//b4.png"));
       b4.setBounds(137, 270, 50, 50);
       b4.setHorizontalTextPosition(AbstractButton.CENTER);
       b4.addActionListener(this);
       add(b4);

       b5 = new JButton("Image Button", new ImageIcon("Images//b5.png"));
       b5.setBounds(202, 270, 50, 50);
       b5.setHorizontalTextPosition(AbstractButton.CENTER);
       b5.addActionListener(this);
       add(b5);

       b6 = new JButton("Image Button", new ImageIcon("Images//b6.png"));
       b6.setBounds(270, 270, 50, 50);
       b6.setHorizontalTextPosition(AbstractButton.CENTER);
       b6.addActionListener(this);
       add(b6);

       b7 = new JButton("Image Button", new ImageIcon("Images//b7.jpg"));
       b7.setBounds(137, 380, 50, 50);
       b7.setHorizontalTextPosition(AbstractButton.CENTER);
       b7.addActionListener(this);
       add(b7);

       b8 = new JButton("Image Button", new ImageIcon("Images//b8.png"));
       b8.setBounds(202, 380, 50, 50);
       b8.setHorizontalTextPosition(AbstractButton.CENTER);
       b8.addActionListener(this);
       add(b8);

       b9 = new JButton("Image Button", new ImageIcon("Images//b9.png"));
       b9.setBounds(270, 380, 50, 50);
       b9.setHorizontalTextPosition(AbstractButton.CENTER);
       b9.addActionListener(this);
       add(b9);
    }

    public void actionPerformed(ActionEvent ae){
       
        String output="";
      
        if(ae.getSource()==b1)
        {
            int check=dialogbox("NETFLIX");
            if(check==1) {
                output="NETFLIX";
            } 
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b2)
        {
            int check=dialogbox("AMAZON PRIME");
            if(check==1) {
                output="AMAZON_PRIME";
            } 
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b3)
        {
            int check=dialogbox("HOTSTAR");
            if(check==1) {
                output="HOTSTAR";
            } 
            else {
                output="UTX100_484A_ERROR";
            }
        }
        else if(ae.getSource()==b4)
        {
            int check=dialogbox("ZEE");
            if(check==1) {
                output="ZEE";
            } 
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b5)
        {
            int check=dialogbox("VOOT");
            if(check==1) {
                output="VOOT";
            }
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b6)
        {
            int check=dialogbox("UTUBE");
            if(check==1) {
                output="UTUBE";
            }
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b7)
        {
            int check=dialogbox("PHONE BOOK");
            if(check==1) {
                output="PHONE_BOOK";
            }
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b8)
        {
            int check=dialogbox("GALLERY");
            if(check==1) {
                output="GALLERY";
            }
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        else if(ae.getSource()==b9)
        {
            int check=dialogbox("GMAIL");
            if(check==1) {
                output="GMAIL";
            }
            else {
                output="UTX100_484A_ERROR";
            } 
        }
        
        try{
            if(output.equals("UTX100_484A_ERROR")){
                dout.writeUTF(output);   
                JOptionPane.showMessageDialog(null,"YOUR PHONE IS DISCONNECTED NOW!! \n");  
            }
            else{
                dout.writeUTF(output);
            } 
            }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static int dialogbox(String app)
    {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "YOUR CONNECTION DEVICE WANT TO ACCESS YOUR APP !! \n IF YOU DENY THIS PERMISSION, BASIC FEATURES OF YOUR DEVICE MAY NO LONGER FUNCTION AS INTENDED. ", "PERMISSION : "+app, dialogButton);
            if(dialogResult == 0) {
                return 1;
            }
            else {
                return 0;
            }
    }   

    public static void main(String[] args){
    
        new Server().setVisible(true);
        
        String msginput = "";
        try{
            
            skt = new ServerSocket(6001);
            
            while(true){
                s = skt.accept();
                System.out.println("Connected");
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());      
            }
            
        }catch(Exception e){}
    }    
}

