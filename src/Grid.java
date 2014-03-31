

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.*;

public class Grid  extends JFrame {

    private int i,j;
    public JButton player[][];
    public JButton computer[][];
    private JPanel panelp,panelc,panelpship,panelcship , panelbottom;
    public JButton playership[];
    public JButton computership[];
	public JButton Start, Rules, Exit;
	public int p1[],p2[],p3[],p4[],p5[],c1[],c2[],c3[],c4[],c5[] ;
	public int pf1,pf2,pf3,pf4,pf5,cf1,cf2,cf3,cf4,cf5, temp1,temp2, f51,f52,f53,f54,f55,f41,f42,f43,f44,f31,f32,f33,f21,f22,f11;
	public int pgr[][],cgr[][];
	public boolean playerwin, computerwin;
	
		
	
    public Grid()
    {
        super("The title");
            setLayout(new FlowLayout());
            player= new JButton[10][10];
            computer= new JButton[10][10];
            playership= new JButton[5];
            computership= new JButton[5];
			Start= new JButton("Start");
			Rules= new JButton("Rules");
			Exit= new JButton("Exit");
                      
            GridLayout ground=new GridLayout(10,10,0,-0) ;
            GridLayout ship= new GridLayout(5,1,0,0);
			GridLayout bottom = new GridLayout(1,3,0,0);
			panelp= new JPanel(ground);
            panelc= new JPanel(ground);
			panelpship= new JPanel(ship);
            panelcship= new JPanel(ship);
			panelbottom= new JPanel(bottom);
            panelp.setLayout(ground);
            panelc.setLayout(ground);
            panelpship.setLayout(ship); 
            panelcship.setLayout(ship);
			panelbottom.setLayout(bottom);
			panelbottom.add(Rules);
			panelbottom.add(Start);
			panelbottom.add(Exit);
			p1= new int[2];
			p2= new int[4];
			p3= new int[6];
			p4= new int[8];
			p5= new int[10];
			c1= new int[2];
			c2= new int[4];	
			c3=	new int[6];
			c4=	new int[8];
			c5=	new int[10];
			pgr= new int[10][10];
			cgr= new int[10][10];
			pf1=pf2=pf3=pf4=pf5=cf1=cf2=cf3=cf4=cf5=0;
			f51=f52=f53=f54=f55=0;
			f41=f42=f43=f44=0;
			f31=f32=f33=0;
			f21=f22=f11=0;
			playerwin=false;
			computerwin=false;
		
            for( i=0;i<5;i++)
            {
				 // playership[i]= new JButton("Ship"+ (i+1));
				 playership[i]= new JButton("P Ship");
                  playership[i].setPreferredSize(new Dimension(60, 60));
				  panelpship.add(playership[i]);  
            }
            for( i=0;i<5;i++)
            {
                  computership[i]= new JButton("C Ship");
				 // computership[i]= new JButton("Ship"+ (i+1));
                  computership[i].setPreferredSize(new Dimension(60, 60));
				  panelcship.add(computership[i]);
                 
            }
            for(i=0;i<10;i++)
            {
                for(j=0;j<10;j++)
                {
                  //player[i][j]= new JButton("P("+i+","+j+")");
				  player[i][j]= new JButton("-P-");
                  player[i][j].setPreferredSize(new Dimension(60, 60));
				  player[i][j].setEnabled(false); 

                  panelp.add(player[i][j]);
                   
                }
			}
            for( i=0;i<10;i++)
            {
                for(j=0;j<10;j++)
                {
                  //computer[i][j]= new JButton("C("+i+","+j+")");
				   computer[i][j]= new JButton("-C-");
                  computer[i][j].setPreferredSize(new Dimension(60, 60));
                   panelc.add(computer[i][j]);
                }
            }
			
            add(panelpship,BorderLayout.WEST);
            add(panelp,BorderLayout.WEST);
            add(panelc,BorderLayout.EAST);
            add(panelcship,BorderLayout.EAST);
			//add(panelbottom,BorderLayout.SOUTH);
			panelp.setEnabled(false);
             
            HandlerClass handler= new HandlerClass();
            for( i=0;i<10;i++)
            {
				for(j=0;j<10;j++)
                {
				player[i][j].putClientProperty("column",i);
				player[i][j].putClientProperty("row",j);
				computer[i][j].putClientProperty("column",i);
				computer[i][j].putClientProperty("row",j);
                player[i][j].addActionListener(handler);
				computer[i][j].addActionListener(handler);
                }
            }
			setships();
	}		
	public void setships()
	{
		Random r= new Random();
		temp1=r.nextInt(9);
		temp2=r.nextInt(9);
		pgr[temp1][temp2]=1;
		p1[0]=temp1;
		p1[1]=temp2;
		i=0;
		while(i<1)
		{
			p2[0]=r.nextInt(9);
			p2[1]=r.nextInt(9);
			if(pgr[p2[0]][p2[1]]==1 )
				i=0;
			else
			{
				i++;
			}
			//System.out.println(p2[0]+" "+p2[1]);
				
			if(pgr[p2[0]][p2[1]+1]==0  && ( p2[1]!= 9))
			{	
				p2[2]=p2[0];
				p2[3]= p2[1]+1;
				pgr[p2[0]][p2[1]]=2;
				pgr[p2[2]][p2[3]]=2;
						
			}
			else
				i=0;
		}
				
			
		
		i=0;
		while(i<1)
		{
			p3[0]=r.nextInt(9);
			p3[1]=r.nextInt(9);
			if(pgr[p3[0]][p3[1]]==1 )
				i=0;
			else
				i++;
					
			//System.out.println(p3[0]+" "+p3[1]);
			//System.out.println(p3[0]<8);
				
			if((i==1)&&( p3[0]<8) && (pgr[p3[0]+1][p3[1]]==0) && (pgr[p3[0]+2][p3[1]]==0) )
			{	
				p3[2]=p3[0]+1;
				p3[3]=p3[1];
				p3[4]=p3[0]+2;
				p3[5]=p3[1];
				pgr[p3[0]][p3[1]]=3;
				pgr[p3[2]][p3[3]]=3;
				pgr[p3[4]][p3[5]]=3;
						
					
			}
			else
				i=0;
		}
		i=0;
		while(i<1)
		{
			p4[0]=r.nextInt(9);
			p4[1]=r.nextInt(9);
			if(pgr[p4[0]][p4[1]]==1 )
				i=0;
			else
				i++;
			//System.out.println(p4[0]+" "+p4[1]);
			//System.out.println(p4[0]<7);
				
			if((i==1)&&( p4[0]<7) && (pgr[p4[0]+1][p4[1]]==0) && (pgr[p4[0]+2][p4[1]]==0) && (pgr[p4[0]+3][p4[1]]==0))
			{	
				p4[2]=p4[0]+1;
				p4[3]=p4[1];
				p4[4]=p4[0]+2;
				p4[5]=p4[1];
				p4[6]=p4[0]+3;
				p4[7]=p4[1];
				pgr[p4[0]][p4[1]]=4;
				pgr[p4[2]][p4[3]]=4;
				pgr[p4[4]][p4[5]]=4;
				pgr[p4[6]][p4[7]]=4;
			}
			else
				i=0;
		}
		i=0;
		while(i<1)
		{
			p5[0]=r.nextInt(9);
			p5[1]=r.nextInt(9);
			if(pgr[p5[0]][p5[1]]==1 )
				i=0;
			else
				i++;
			//System.out.println(p5[0]+" "+p5[1]);
			//System.out.println(p5[1]<6);
				
			if((i==1)&&( p5[1]<6) && (pgr[p5[0]][p5[1]+1]==0) && (pgr[p5[0]][p5[1]+2]==0) && (pgr[p5[0]][p5[1]+3]==0) && (pgr[p5[0]][p5[1]+4]==0) )
			{	
				p5[2]=p5[0];
				p5[3]= p5[1]+1;
				p5[4]=p5[0];
				p5[5]= p5[1]+2;
				p5[6]=p5[0];
				p5[7]= p5[1]+3;
				p5[8]=p5[0];
				p5[9]= p5[1]+4;
				pgr[p5[0]][p5[1]]=5;
				pgr[p5[2]][p5[3]]=5;
				pgr[p5[4]][p5[5]]=5;
				pgr[p5[6]][p5[7]]=5;
				pgr[p5[8]][p5[9]]=5;
					
			}
			else
				i=0;
		}
		/*	System.out.println("final "+p1[0]+" "+p1[1]);
			System.out.println(p2[0]+" "+p2[1]+" "+p2[2]+" "+p2[3]);
			System.out.println(p3[0]+" "+p3[1]+" "+p3[2]+" "+p3[3]+" "+p3[4]+" "+p3[5]);
			System.out.println(p4[0]+" "+p4[1]+" "+p4[2]+" "+p4[3]+" "+p4[4]+" "+p4[5] +" "+p4[6]+" "+p4[7]);
			System.out.println(p5[0]+" "+p5[1]+" "+p5[2]+" "+p5[3]+" "+p5[4]+" "+p5[5] +" "+p5[6]+" "+p5[7]+" "+p5[8]+" "+p5[9]);
			System.out.println();
		*/	
		System.out.println();
			
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
				System.out.print(pgr[i][j]+" ");
			System.out.println();		
			
		}
			
			
			temp1=r.nextInt(9);
			temp2=r.nextInt(9);
			cgr[temp1][temp2]=1;
			c1[0]=temp1;
			c1[1]=temp2;
			
		
			
		i=0;
		while(i<1)
		{
			c2[0]=r.nextInt(9);
			c2[1]=r.nextInt(9);
			if(cgr[c2[0]][c2[1]]==1 )
				i=0;
			else
				i++;
			//System.out.println(c2[0]+" "+c2[1]);
			if(cgr[c2[0]][c2[1]+1]==0  && ( c2[1]!= 9))
			{	
				c2[2]=c2[0];
				c2[3]= c2[1]+1;
				cgr[c2[0]][c2[1]]=2;
				cgr[c2[2]][c2[3]]=2;
			//	System.out.println("final+" +c2[0]+" "+c2[1]);
			//	System.out.println(c2[2]+" "+c2[3]);
						
			}
			else
				i=0;
		}
				
		i=0;
		while(i<1)
		{
			c3[0]=r.nextInt(9);
			c3[1]=r.nextInt(9);
			if(cgr[c3[0]][c3[1]]==1 )
				i=0;
			else
				i++;
			//System.out.println(c3[0]+" "+c3[1]);
			//System.out.println(c3[0]<8);
				
			if((i!=0)&&( c3[0]<8) && (cgr[c3[0]+1][c3[1]]==0) && (cgr[c3[0]+2][c3[1]]==0) )
			{	
				c3[2]=c3[0]+1;
				c3[3]=c3[1];
				c3[4]=c3[0]+2;
				c3[5]=c3[1];
				cgr[c3[0]][c3[1]]=3;
				cgr[c3[2]][c3[3]]=3;
				cgr[c3[4]][c3[5]]=3;
			//	System.out.println("Final" +c3[0]+" "+c3[1]);
			//	System.out.println("Final" +c3[2]+" "+c3[3]);
			//	System.out.println("Final" +c3[4]+" "+c3[5]);
						
			}
			else
				i=0;
		}
		i=0;
		while(i<1)
		{
			c4[0]=r.nextInt(9);
			c4[1]=r.nextInt(9);
			if(cgr[c4[0]][c4[1]]==1 )
				i=0;
			else
				i++;
			//System.out.println(c4[0]+" "+c4[1]);
			//System.out.println(c4[0]<7);
				
			if((i==1)&&( c4[0]<7) && (cgr[c4[0]+1][c4[1]]==0) && (cgr[c4[0]+2][c4[1]]==0) && (cgr[c4[0]+3][c4[1]]==0))
			{	
				c4[2]=c4[0]+1;
				c4[3]=c4[1];
				c4[4]=c4[0]+2;
				c4[5]=c4[1];
				c4[6]=c4[0]+3;
				c4[7]=c4[1];
				cgr[c4[0]][c4[1]]=4;
				cgr[c4[2]][c4[3]]=4;
				cgr[c4[4]][c4[5]]=4;
				cgr[c4[6]][c4[7]]=4;
						
			}
			else
				i=0;
		}
				
		i=0;
		while(i<1)
		{
			c5[0]=r.nextInt(9);
			c5[1]=r.nextInt(9);
			if(cgr[c5[0]][c5[1]]==1 )
				i=0;
			else
				i++;
			//System.out.println(c5[0]+" "+c5[1]);
			//System.out.println(c5[1]<6);
				
			if((i==1)&&( c5[1]<6) && (cgr[c5[0]][c5[1]+1]==0) && (cgr[c5[0]][c5[1]+2]==0) && (cgr[c5[0]][c5[1]+3]==0) && (cgr[c5[0]][c5[1]+4]==0) )
			{	
				c5[2]=c5[0];
				c5[3]= c5[1]+1;
				c5[4]=c5[0];
				c5[5]= c5[1]+2;
				c5[6]=c5[0];
				c5[7]= c5[1]+3;
				c5[8]=c5[0];
				c5[9]= c5[1]+4;
				cgr[c5[0]][c5[1]]=5;
				cgr[c5[2]][c5[3]]=5;
				cgr[c5[4]][c5[5]]=5;
				cgr[c5[6]][c5[7]]=5;
				cgr[c5[8]][c5[9]]=5;		
					
			}
			else
				i=0;
		}
		System.out.println();
		System.out.println();
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
				System.out.print(cgr[i][j]+" ");
			System.out.println();		
			
		}
			
		//panelp.setEnabled(false);
           
     }
		  
    public void playSound(String sound)
           {
				try 
				{	
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile( ));
					Clip clip = AudioSystem.getClip( );
					clip.open(audioInputStream);
					clip.start( );
				}
				catch(Exception ex)
				{
					System.out.println("Error with playing sound.");
					ex.printStackTrace( );
				}
			}
    
    
    private class HandlerClass implements ActionListener{
              public int col,row, temp, flag, tr ;  
            public void actionPerformed(ActionEvent event){
            ((JButton)event.getSource()).setText("##");
			
			JButton btn=(JButton)event.getSource();
 //System.out.println("clicked column" + btn.getClientProperty("column") + ",row" + btn.getClientProperty("row") + btn.getClientProperty("Name"));
        ((JButton)event.getSource()).setEnabled(false); 
         
		col=(int)btn.getClientProperty("column");
		row=(int)btn.getClientProperty("row");
		
		//System.out.println("col n row" +col +" "+ row);
		//System.out.println(cgr[col][row]);
		
		if(cgr[col][row]!=0)
		{	//System.out.println("in main if loop");
				if(cgr[col][row]==1)
				{
				((JButton)event.getSource()).setBackground(Color.RED);
					computership[0].setBackground(Color.RED);
					
				playSound("explosion_6.wav");
					cf1=1;
				}
				else if(cgr[col][row]==2)
				{
						((JButton)event.getSource()).setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						cgr[col][row]=-2;
						if((cgr[c2[0]][c2[1]]==-2) && (cgr[c2[2]][c2[3]]==-2))
						{
							computer[c2[0]][c2[1]].setBackground(Color.RED);
							computer[c2[2]][c2[3]].setBackground(Color.RED);
							computership[1].setBackground(Color.RED);
							playSound("explosion_6.wav");
								cf2=1;
							
						}
				}
				else if(cgr[col][row]==3)
				{
						((JButton)event.getSource()).setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						cgr[col][row]=-3;
						if((cgr[c3[0]][c3[1]]==-3) && (cgr[c3[2]][c3[3]]==-3) && (cgr[c3[4]][c3[5]]==-3))
						{
							computer[c3[0]][c3[1]].setBackground(Color.RED);
							computer[c3[2]][c3[3]].setBackground(Color.RED);
							computer[c3[4]][c3[5]].setBackground(Color.RED);
							computership[2].setBackground(Color.RED);
							playSound("explosion_6.wav");
								cf3=1;	
						}
				}
				else if(cgr[col][row]==4)
				{
						((JButton)event.getSource()).setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						cgr[col][row]=-4;
						if((cgr[c4[0]][c4[1]]==-4) && (cgr[c4[2]][c4[3]]==-4) && (cgr[c4[4]][c4[5]]==-4) && (cgr[c4[6]][c4[7]]==-4))
						{
							computer[c4[0]][c4[1]].setBackground(Color.RED);
							computer[c4[2]][c4[3]].setBackground(Color.RED);
							computer[c4[4]][c4[5]].setBackground(Color.RED);
							computer[c4[6]][c4[7]].setBackground(Color.RED);
							computership[3].setBackground(Color.RED);
							playSound("explosion_6.wav");
								cf4=1;	
						}
				}
				else if(cgr[col][row]==5)
				{
						//System.out.println("in inner if loop");
						((JButton)event.getSource()).setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						cgr[col][row]=-5;
						if((cgr[c5[0]][c5[1]]==-5) && (cgr[c5[2]][c5[3]]==-5) && (cgr[c5[4]][c5[5]]==-5) && (cgr[c5[6]][c5[7]]==-5) && (cgr[c5[8]][c5[9]]==-5))
						{
							computer[c5[0]][c5[1]].setBackground(Color.RED);
							computer[c5[2]][c5[3]].setBackground(Color.RED);
							computer[c5[4]][c5[5]].setBackground(Color.RED);
							computer[c5[6]][c5[7]].setBackground(Color.RED);
							computer[c5[8]][c5[9]].setBackground(Color.RED);
							computership[4].setBackground(Color.RED);
							playSound("explosion_6.wav");
								cf5=1;	
						}
				}
				
				if(cf1==1 && cf2==1 && cf3==1 && cf4==1 && cf5==1 && computerwin== false)
				{
					//System.out.println("you won");
					JOptionPane.showMessageDialog(null, "Game over! You WIN!");
					playerwin=true;
				
				}
				
		/*	for(i=0;i<10;i++)
			{
			for(j=0;j<10;j++)
				System.out.print(cgr[i][j]+" ");
			System.out.println();
		*/			
			
			}	
				
		
		else
		{		
			((JButton)event.getSource()).setBackground(Color.GREEN);
			btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			playSound("plop_2.wav");
		}
		//System.out.println("yo");
		Random r= new Random();		
			flag=0;
			//ai start
			while(flag==0)
			{	
			
				if( pgr[p2[0]][p2[1]]==-2 && f21<2)
				{
					if(pgr[p2[0]][p2[1]+1]>=0)
					{	
						col= p2[0];
						row= p2[1]+1;
					
					}
					else if(p2[1]>0)
					{
						col= p2[0];
						row= p2[1]-1;
					}
					f21++;
				}
				
				
				
				else if( pgr[p2[2]][p2[3]]==-2 && f22<2)
				{
					if((p2[2]<9) && (pgr[p2[2]][p2[3]+1]>=0))
					{	
						col= p2[2];
						row= p2[3]+1;
					}
					else
					{
						col= p2[2];
						row= p2[2]-1;
					}
					f22++;
				}
				else if( pgr[p3[0]][p3[1]]==-3 && f31<2)
				{
					if(pgr[p3[0]+1][p3[1]]>=0)
					{	
						col= p3[0]+1;
						row= p3[1];
					
					}
					else if(p3[0]>0)
					{
						col= p3[0]-1;
						row= p3[1];
					}
					f31++;
				}
				else if( pgr[p3[2]][p3[3]]==-4 && f32<2)
				{
					if(pgr[p3[2]+1][p3[3]]>=0)
					{	
						col= p3[2]+1;
						row= p3[3];
					}
					else
					{
						col= p3[2]-1;
						row= p3[3];
					}
					f32++;
				}
				else if( pgr[p3[4]][p3[5]]==-4 &&  f33<2)
				{
					if(p3[4]<9 && pgr[p3[4]+1][p3[5]]>=0)
					{	
						col= p3[4]+1;
						row= p3[5];
					}
					else
					{
						col= p3[4]-1;
						row= p3[5];
					}
					f33++;
				}
				
				 else if( pgr[p4[0]][p4[1]]==-4 && f41<2)
				{
					if(pgr[p4[0]+1][p4[1]]>=0)
					{	
						col= p4[0]+1;
						row= p4[1];
					
					}
					else if(p4[0]>0)
					{
						col= p4[0]-1;
						row= p4[1];
					}
					f41++;
				}
				else if( pgr[p4[2]][p4[3]]==-4 && f42<2)
				{
					if(pgr[p4[2]+1][p4[3]]>=0)
					{	
						col= p4[2]+1;
						row= p4[3];
					}
					else
					{
						col= p4[2]-1;
						row= p4[3];
					}
					f42++;
				}
				else if( pgr[p4[4]][p4[5]]==-4 &&  f43<2)
				{
					if(pgr[p4[4]+1][p4[5]]>=0)
					{	
						col= p4[4]+1;
						row= p4[5];
					}
					else
					{
						col= p4[4]-1;
						row= p4[5];
					}
					f43++;
				}
				else if( pgr[p4[6]][p4[7]]==-4 && f44 <2)
				{
					if(p4[6]<9 && pgr[p4[6]+1][p4[7]]>=0)
					{	
						col= p4[6]+1;
						row= p4[7];
					}
					else
					{
						col= p4[6]-1;
						row= p4[7];
					}
					f44++;
				}
				
				
				
				else if( pgr[p5[0]][p5[1]]==-5 && f51<2)
				{
					if(pgr[p5[0]][p5[1]+1]>=0)
					{	
						col= p5[0];
						row= p5[1]+1;
					
					}
					else
					{
						col= p5[0];
						row= p5[1]-1;
					}
					f51++;
				}
				else if( pgr[p5[2]][p5[3]]==-5 && f52<2)
				{
					if(pgr[p5[2]][p5[3]+1]>=0)
					{	
						col= p5[2];
						row= p5[3]+1;
					}
					else
					{
						col= p5[2];
						row= p5[3]-1;
					}
					f52++;
				}
				else if( pgr[p5[4]][p5[5]]==-5 &&  f53<2)
				{
					if(pgr[p5[4]][p5[5]+1]>=0)
					{	
						col= p5[4];
						row= p5[5]+1;
					}
					else
					{
						col= p5[2];
						row= p5[3]-1;
					}
					f53++;
				}
				else if( pgr[p5[6]][p5[7]]==-5 && f54 <2)
				{
					if(pgr[p5[6]][p5[7]+1]>=0)
					{	
						col= p5[6];
						row= p5[7]+1;
					}
					else
					{
						col= p5[6];
						row= p5[7]-1;
					}
					f54++;
				}
				else if( pgr[p5[8]][p5[9]]==-5 && f55<2)
				{
					if((p5[9]<9) && (pgr[p5[8]][p5[9]+1]>=0))
					{	
						col= p5[8];
						row= p5[9]+1;
					}
					else
					{
						col= p5[8];
						row= p5[9]-1;
					}
					f55++;
				}
				
			//ai end	
				else
				{
					col=r.nextInt(10);
					row=r.nextInt(10);
					if(col==10)
						col--;
					if(row==10)
						row--;
					//System.out.println("inter"+col +" "+ row);
					//if(pgr[col][row]>=0)
						//flag=1;
				}
				if(pgr[col][row]>=0)
						flag=1;
				System.out.println("ai"+col +" "+ row);
			}
		
			//System.out.println("final"+col +" "+ row);
		//	System.out.println(pgr[col][row]>0);
			
		if(pgr[col][row]>0)
		{
				//System.out.println("inside if ");
				if(pgr[col][row]==1)
				{
					player[col][row].setBackground(Color.RED);
					playership[0].setBackground(Color.RED);
					playSound("explosion_6.wav");
						pgr[col][row]=-1;
					pf1=1;
				}
				else if(pgr[col][row]==2)
				{
						player[col][row].setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						pgr[col][row]=-2;
						if((pgr[p2[0]][p2[1]]==-2) && (pgr[p2[2]][p2[3]]==-2))
						{
							player[p2[0]][p2[1]].setBackground(Color.RED);
							player[p2[2]][p2[3]].setBackground(Color.RED);
							playership[1].setBackground(Color.RED);
							playSound("explosion_6.wav");
								pf2=1;
							
						}
				}
				else if(pgr[col][row]==3)
				{
						player[col][row].setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						pgr[col][row]=-3;
						if((pgr[p3[0]][p3[1]]==-3) && (pgr[p3[2]][p3[3]]==-3) && (pgr[p3[4]][p3[5]]==-3))
						{
							player[p3[0]][p3[1]].setBackground(Color.RED);
							player[p3[2]][p3[3]].setBackground(Color.RED);
							player[p3[4]][p3[5]].setBackground(Color.RED);
							playership[2].setBackground(Color.RED);
							playSound("explosion_6.wav");
								pf3=1;	
						}
				}
				else if(pgr[col][row]==4)
				{
						player[col][row].setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						pgr[col][row]=-4;
						if((pgr[p4[0]][p4[1]]==-4) && (pgr[p4[2]][p4[3]]==-4) && (pgr[p4[4]][p4[5]]==-4) && (pgr[p4[6]][p4[7]]==-4))
						{
							player[p4[0]][p4[1]].setBackground(Color.RED);
							player[p4[2]][p4[3]].setBackground(Color.RED);
							player[p4[4]][p4[5]].setBackground(Color.RED);
							player[p4[6]][p4[7]].setBackground(Color.RED);
							playership[3].setBackground(Color.RED);
							playSound("explosion_6.wav");
								pf4=1;	
						}
				}
				else if(pgr[col][row]==5)
				{
						player[col][row].setBackground(Color.BLUE);
						playSound("blast_5.wav");
					
						pgr[col][row]=-5;
						if((pgr[p5[0]][p5[1]]==-5) && (pgr[p5[2]][p5[3]]==-5) && (pgr[p5[4]][p5[5]]==-5) && (pgr[p5[6]][p5[7]]==-5) && (pgr[p5[8]][p5[9]]==-5))
						{
							player[p5[0]][p5[1]].setBackground(Color.RED);
							player[p5[2]][p5[3]].setBackground(Color.RED);
							player[p5[4]][p5[5]].setBackground(Color.RED);
							player[p5[6]][p5[7]].setBackground(Color.RED);
							player[p5[8]][p5[9]].setBackground(Color.RED);
							playership[4].setBackground(Color.RED);
							playSound("explosion_6.wav");
								pf5=1;	
						}
				}
		
				
				if(pf1==1 && pf2==1 && pf3==1 && pf4==1 && pf5==1 &&  playerwin==false)
				{
					//System.out.println("computer won");
					JOptionPane.showMessageDialog(null, "Game over! You LOSS!");
					computerwin=true;
					
					
				
				}
				
				
			
					
		}
		else
		{
				//System.out.println("else one");
				player[col][row].setBackground(Color.GREEN);
				pgr[col][row]=-10;
				playSound("plop_2.wav");
		
		}
	
            
            
        }
    
}
}
