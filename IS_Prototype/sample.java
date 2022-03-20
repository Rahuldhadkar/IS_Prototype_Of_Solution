import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


class FDemo extends JFrame
{
	JPDemo jp1;
	FDemo()
	{
		jp1=new JPDemo();
		add(jp1);
        jp1.connectToServer();
        super.setTitle("Player "+(jp1.playerId));
	}
}
class JPDemo extends JPanel implements ActionListener
{
    //private ClientSideConnection csc;
	ImageIcon img1,img2,img3, img4;
	ImageIcon img5, img6,img7;
	ImageIcon img8, img9;
	ImageIcon img10,img11,img13;
	Image swt,board,s1,start;
	Image player1,player2;
	Image player11,player12;
	Image dice,dice1;
	Image winner;
	public int playerId;
	
	private playersprite me;
	private playersprite enemy;
	private Socket socket;
	//private DrawingComponent dc;
	//this.setTitle("Player #"+ playerId);
	int px1=40;
	int py1=620;
	int p=1;
	int px2=120;
	int py2=620;
	int nu=0,nu1=0;
	int o=0,se=0;
	String input1,input2;
	boolean d=false,s=false;

	boolean one=true,second=false;

	
	JButton b1, b2,b3,b4;
	JTextField tx1,tx2,tx3;
	
   private ReadFromServer rfsRunnable;
   private WriteToServer  wtsRunnable;

   


   //********************************** */
   class playersprite //extends JPDemo
   {
	  private double x,y,size;
	  private Color color;
  
	  public playersprite(double a, double b,double s,Color c)
	  {
		  x=a;
		  y=b;
		  size=s;
		  color=c;
  
	  }
	  public void drawSprite(Graphics2D g2d)
	  {  
	   Rectangle2D.Double square=new Rectangle2D.Double(x,y,size,size);
	   g2d.setColor(color);
		g2d.fill(square);
	  
	  }
	   public int getX()
	  {
		  return px1;
	  }
	 public int getY()
	 {
		 return py1;
	 } 
	 public int getCount(){
		 return nu;
	 }
	 public void setX(int x1){
		px2=x1;
	 }
	 public void setY(int y1){
		 py2=y1;
	   }
      public void wins(int nup)
	  {
		nu1=nup;  
		winner();
		
	  }
	  public void setTurn(int op)
	  {

         se=op;
	  }
	  public int getTurn(){
       return o;
	  }

	  public String getName()
	  {  
		  return input1;
	  }

	  public void setName(String name)
	  {
		  input2=name;
		  tx3.setText(input2);
		  
	  }
	  
	  
  
  }
//***************************************************** */  









	JPDemo()
	{
		setBackground(Color.black);
		
		img1=new ImageIcon("swt.jpg");
		swt=img1.getImage();
		img2=new ImageIcon("board.jpg");
		board=img2.getImage();
		img3=new ImageIcon("s1.png");
		s1=img3.getImage();
		img4=new ImageIcon("start.png");
		start=img4.getImage();
		
		img5=new ImageIcon("about.gif");
		img6=new ImageIcon("reset.png");
		img7=new ImageIcon("start.gif");
		
		img8=new ImageIcon("player1.png");
		player1=img8.getImage();
		img9=new ImageIcon("player2.png");
		player2=img9.getImage();
		
		player11=img8.getImage();
		player12=img9.getImage();

		
		
		img13=new ImageIcon("winner.gif");
	    winner=img13.getImage();
		img10=new ImageIcon("dice(1).gif");
		dice=img10.getImage();
		img11=new ImageIcon("dice.png");
		dice1=img11.getImage();
		
		setLayout(null);
		b1=new JButton(img5);
		b1.setBounds(50,120,100,30);
		add(b1);
		b1.setBackground(new Color(4,129,255));
		
		b2=new JButton(img6);
		b2.setBounds(50,180,100,30);
		add(b2);
		b1.setBackground(new Color(4,129,255));
		
		Font f=new Font("Bauhaus 93",Font.ITALIC,20);
		
		tx1=new JTextField("Start Game");
		tx1.setText("Start Game");
		tx1.setBounds(50,230,150,35);
		add(tx1);
		tx1.setBackground(Color.black);
		tx1.setForeground(Color.green);
		tx1.setFont(f);
        
		
		tx2=new JTextField("You");
		tx2.setBounds(50,290,150,35);
		add(tx2);
		tx2.setBackground(Color.black);
		tx2.setForeground(Color.green);
		tx2.setFont(f);

        tx3=new JTextField("Opponent");
		tx3.setBounds(50,375,150,35);
		add(tx3);
		tx3.setBackground(Color.black);
		tx3.setForeground(Color.green);
		tx3.setFont(f);
		
		
		
		b3=new JButton("Roll");
		b3.setBounds(50,500,100,30);
		add(b3);
		b3.setFont(f);
		b3.setForeground(Color.red);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		b4=new JButton(img7);
		b4.setBounds(25,560,150,60);
		add(b4);
		b4.setFont(f);
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		createSprite();
		
	}

private void createSprite(){
	if(playerId==1)
	{
	me=new playersprite(px1,py1,40,Color.BLACK);
	enemy=new playersprite(px2, py2, 40,Color.red );
	}
	else
	{
		enemy=new playersprite(px1,py1,40,Color.BLACK);
	    me=new playersprite(px2, py2, 40,Color.red );
	}
}



public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	g.setColor(new Color(4,129,255));
	g.fillRect(0,0,200,735);
	
	g.drawImage(swt,0,0,this);
	g.drawImage(board,200,0,this);
	g.drawImage(s1,920,0,this);
	g.drawImage(start,20,550,this);
	
	createSprite();
	Graphics2D g2d= (Graphics2D) g;
	       enemy.drawSprite(g2d);
	        me.drawSprite(g2d);
	
	g.drawImage(player11,10,360,this);
	g.drawImage(player12,10,280,this);
	
	g.drawImage(dice,10,420,this);
	g.drawImage(dice1,110,420,this);
	
	  setTurn();
	 if(d)
	  {
	    g.drawImage(winner,230,70,this);
	  }
	
}	

public void winner()
{
	
    if(nu1==100)
	{
		d=true;
		System.out.println(nu1);
		JOptionPane.showMessageDialog(null,"Opponent player " + "is winner","Display Message", JOptionPane.
			 INFORMATION_MESSAGE);
		px1=40;
		py1=620;
		px2=120;
		py2=620;
		s=false;
		nu1=0;
		nu=0;
		//c++;
		//d=false;
		createSprite();
		repaint();
	}
}

public void setTurn()
{
	if(o==se)
	{
		tx1.setText("Turn:- Player 1");
	}
	else
	{
		tx1.setText("Turn:- Player 2");
	}
}

public void actionPerformed(ActionEvent e)
{
	
	 
	   
	if(e.getSource()==b2)
	{
		px1=40;
		py1=620;
		px2=120;
		py2=620;
		// nu1=0;
		// nu=0;
		d=false;
		se=0;
		o=0;
		createSprite();
        repaint();
	}
	
	if(e.getSource()==b4)
	{
        
	    s=true;
		nu=0;
		nu1=0;
				
	}
	if(s && playerId==1 && (se-o==0))
	{	
		
        if(e.getSource()==b3)
            { 
				
				  
				  o++;
				  
               int random=(int)Math.round(Math.random()*5+1);
		        if(nu==95&&random==6)
		           {
			          nu=89;
		           }
		        if(nu==96&&random>4)
		           {
			           if(random==5)
			            {
				          nu=91;
			            }
			           if(random==6)
			            {
				           nu=90;
			            }
		           }
		        if(nu==97&&random>3)
		           {
			           if(random==4)
			             {
				           nu=93;
			             }
			           if(random==5)
			             {
				           nu=92;
			             }
			           if(random==6)
			              {
				            nu=91;
			              }
		           }
		        if(nu==98&&random>2)
		          {
			           if(random==3)
			              {
				            nu=95;
			              }
			           if(random==4)
			              {
				            nu=94;
			              }
			           if(random==5)
			              {
				            nu=93;
			              }
			           if(random==6)
			              {
				            nu=92;
			              }
		          }
		        if(nu==99&&random>1)
		          {
			          if(random==2)
			             {
				           nu=97;
			             }
			          if(random==3)
			             {
				           nu=96;
			             }
			          if(random==4)
			             {
				             nu=95;
			             }
			          if(random==5)
			             {
				            nu=96;
			             }
			          if(random==6)
			             {
				            nu=97;
			             }
		          }
		
		px1=225;
		py1=645;
		 int k=1;
		int count=random;	
		nu+=count;
		int count1=0;
		
	    M:
		for(int i=1;i<=	10;i++)
		{
			
			if(k==11)
			{
				px1-=70;
				k--;
			}
			if(k==0)
			{
				px1+=70;
				k++;
			}
			for(int j=1;j<=10;j++)
			{
				count1++;
				
				
            if(nu==4)
			{
				nu=25;
			}
			if(nu==13)
			{
				nu=46;
			}
			if(nu==33)
			{
				nu=49;
			}
			if(nu==42)
			{
				nu=63;
			}
			if(nu==50)
			{
				nu=69;
			}
			if(nu==62)
			{
				nu=81;
			}
			if(nu==74)
			{
				nu=92;
			}
			if(nu==27)
			{
				nu=5;
			}
			if(nu==40)
			{
				nu=3;
			}
			if(nu==43)
			{
				nu=18;
			}
			if(nu==54)
			{
				nu=31;
			}
			if(nu==66)
			{
				nu=45;
			}
			if(nu==76)
			{
				nu=58;
			}
			if(nu==89)
			{
				nu=53;
			}
			if(nu==99)
			{
				nu=41;
			}
			if(count1==100)
			 {
				d=true;
				JOptionPane.showMessageDialog(null,"player "+playerId+ "is winner","Display Message", JOptionPane.
                     INFORMATION_MESSAGE);
				px1=40;
				py1=620;
				px2=120;
				py2=620;
				// nu=0;
				// nu1=0;
				// count1=0;
				s=false;
				repaint();
			}
			else
			{
				d=false;
			}
			
		switch(random)
		{
			case 1:
			img11=new ImageIcon("dice1.png");		
			break;
			case 2:
			img11=new ImageIcon("dice2.png");
			break;
			case 3:
			img11=new ImageIcon("dice3.png");
			break;
			case 4:
			img11=new ImageIcon("dice4.png");
			break;
			case 5:
			img11=new ImageIcon("dice5.png");
			break;
			case 6:
			img11=new ImageIcon("dice6.png");
			break;		
		}
		
		dice1=img11.getImage();
		createSprite();
		repaint();
		
		if(count1==nu)
		   break M;
		if(i%2==1)
			{
				px1+=70;
				k++;
				}
	     if(i%2==0)
			{
				px1-=70;
				k--;
			}
		
			}
	      py1-=70;
		}
	}
	
	
        // setTurn();
	
}



/*  player 2 */

if(s && playerId==2 && (se-o==1 ))
	{	
		

		if(e.getSource()==b3)
            { 
				
				  
				  o++;
		   
		          int random=(int)Math.round(Math.random()*5+1);
		        if(nu==95&&random==6)
		           {
			          nu=89;
		           }
		        if(nu==96&&random>4)
		           {
			           if(random==5)
			            {
				          nu=91;
			            }
			           if(random==6)
			            {
				           nu=90;
			            }
		           }
		        if(nu==97&&random>3)
		           {
			           if(random==4)
			             {
				           nu=93;
			             }
			           if(random==5)
			             {
				           nu=92;
			             }
			           if(random==6)
			              {
				            nu=91;
			              }
		           }
		        if(nu==98&&random>2)
		          {
			           if(random==3)
			              {
				            nu=95;
			              }
			           if(random==4)
			              {
				            nu=94;
			              }
			           if(random==5)
			              {
				            nu=93;
			              }
			           if(random==6)
			              {
				            nu=92;
			              }
		          }
		        if(nu==99&&random>1)
		          {
			          if(random==2)
			             {
				           nu=97;
			             }
			          if(random==3)
			             {
				           nu=96;
			             }
			          if(random==4)
			             {
				             nu=95;
			             }
			          if(random==5)
			             {
				            nu=96;
			             }
			          if(random==6)
			             {
				            nu=97;
			             }
		          }
		
		px1=225;
		py1=645;
		 int k=1;
		int count=random;	
		nu+=count;
		int count1=0;
		
	    M:
		for(int i=1;i<=	10;i++)
		{
			
			if(k==11)
			{
				px1-=70;
				k--;
			}
			if(k==0)
			{
				px1+=70;
				k++;
			}
			for(int j=1;j<=10;j++)
			{
				count1++;
				
				
            if(nu==4)
			{
				nu=25;
			}
			if(nu==13)
			{
				nu=46;
			}
			if(nu==33)
			{
				nu=49;
			}
			if(nu==42)
			{
				nu=63;
			}
			if(nu==50)
			{
				nu=69;
			}
			if(nu==62)
			{
				nu=81;
			}
			if(nu==74)
			{
				nu=92;
			}
			if(nu==27)
			{
				nu=5;
			}
			if(nu==40)
			{
				nu=3;
			}
			if(nu==43)
			{
				nu=18;
			}
			if(nu==54)
			{
				nu=31;
			}
			if(nu==66)
			{
				nu=45;
			}
			if(nu==76)
			{
				nu=58;
			}
			if(nu==89)
			{
				nu=53;
			}
			if(nu==99)
			{
				nu=41;
			}
			if(count1==100)
			 {
				d=true;
				JOptionPane.showMessageDialog(null,"player "+playerId+ "is winner","Display Message", JOptionPane.
                     INFORMATION_MESSAGE);
				px1=40;
				py1=620;
				px2=120;
				py2=620;
				// nu=0;
				// nu1=0;
				// count1=0;
				s=false;
				repaint();
			}
			else
			{
				d=false;
			}
			
		switch(random)
		{
			case 1:
			img11=new ImageIcon("dice1.png");		
			break;
			case 2:
			img11=new ImageIcon("dice2.png");
			break;
			case 3:
			img11=new ImageIcon("dice3.png");
			break;
			case 4:
			img11=new ImageIcon("dice4.png");
			break;
			case 5:
			img11=new ImageIcon("dice5.png");
			break;
			case 6:
			img11=new ImageIcon("dice6.png");
			break;		
		}
		
		dice1=img11.getImage();
		createSprite();
		repaint();
		
		if(count1==nu)
		   break M;
		if(i%2==1)
			{
				px1+=70;
				k++;
				}
	     if(i%2==0)
			{
				px1-=70;
				k--;
			}
		
			}
	      py1-=70;
		}
	}
	
	

	
}

    //setTurn();
	
}


 
// client Connection
 
    public void connectToServer(){
        System.out.println("---Client---");
        try{
            socket=new Socket("192.168.1.11",51734);
            DataInputStream in=new DataInputStream(socket.getInputStream());
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			playerId=in.readInt();
			System.out.println("connected to server as Player #"+ playerId + ".");

			rfsRunnable=new ReadFromServer(in);
			wtsRunnable=new WriteToServer(out);
			rfsRunnable.waitForStartMsg();
        }

        catch(IOException ex){
            System.out.println("IO exception from csc constructor");
        }
    

}
private class ReadFromServer implements Runnable{
	private DataInputStream dataIn;
	public ReadFromServer(DataInputStream in)
	{
		dataIn=in;
		System.out.println("RFS Runnable Created");
	}
	public void run(){
          try{
			  while(true){
				  if(enemy!=null){
				  enemy.setX(dataIn.readInt());
				  enemy.setY(dataIn.readInt());
				  enemy.wins(dataIn.readInt());
				  enemy.setTurn(dataIn.readInt());
				  
                   
				  
				  }
				  
			  }
			  

		  }catch(IOException ex)
		  {
			  System.out.println("IOException from RFS run()");
		  }
	}

	public void waitForStartMsg(){
		try{
             String startMsg=dataIn.readUTF();
			 System.out.println("Message from server: "+ startMsg);
			 Thread readThread=new Thread(rfsRunnable);
			 Thread writeThread=new Thread(wtsRunnable);
			 readThread.start();
			 writeThread.start();
		}catch(IOException ex){
			System.out.println("IOException from waitForSignalMsg()");
		}
	}
}

private class WriteToServer implements Runnable{
	private DataOutputStream dataOut;
	public WriteToServer(DataOutputStream out)
	{
		dataOut=out;
		System.out.println("WTS Runnable Created");
	}
	public void run(){
		try{
               while(true){
				   if(me !=null){
				   dataOut.writeInt(me.getX());
				   dataOut.writeInt(me.getY());
				   dataOut.writeInt(me.getCount());
				   dataOut.writeInt(me.getTurn());
				   
				   
				   if(nu==100)
				   {
					   nu=0;
				   }
				   
                   dataOut.flush();
				 }
				   
				   try{
                       Thread.sleep(25);
				   }
				   catch(InterruptedException ex)
				   {
					   System.out.println("Interuppted Exception from WTS Run(");
				   }
			   }
		}catch(IOException ex){
               System.out.println("IOException from WTS run()");
		}
	}
}

}



public class Player {
public static void main(String ar[])
{
	FDemo f=new FDemo();
    
	f.setVisible(true);
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension d = t.getScreenSize();
	int w=990;
	int h=735;
	int x=(d.width-w)/2;
	int y=(d.height-h)/2;
	f.setBounds(x,y,w,h);
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
}
}
 
