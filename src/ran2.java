import java.util.*;

class ran2
{
		public int c1[],c2[],c3[],c4[],c5[];
		public int cf1,cf2,cf3,cf4,cf5, temp1,temp2,i,j;
		public int cgr[][];
		ran2()
		{
			Random r= new Random();
			cf1=0;
			cf2=0;
			cf3=0;
			cf4=0;
			cf5=0;
			c1= new int[2];
			c2= new int[4];	
			c3=	new int[6];
			c4=	new int[8];
			c5=	new int[10];
			System.out.println(cf5);			
			System.out.println("dcjhdsg");
			
			
			
			cgr= new int[10][10];
			for(i=0;i<10;i++)
			for(j=0;j<10;j++)
			cgr[i][j]=0;
			
			while(cf1==0)
			{	
				temp1=r.nextInt(9);
				temp2=r.nextInt(9);
				cgr[temp1][temp2]=1;
				c1[0]=temp1;
				c1[1]=temp2;
				
				
				cf1=1;
			}
			
			i=0;
				while(i<1)
				{
					c2[0]=r.nextInt(9);
					c2[1]=r.nextInt(9);
					if(cgr[c2[0]][c2[1]]==1 )
					i=0;
					else
					{
					
					i++;
					}
					System.out.println(c2[0]+" "+c2[1]);
				
					if(cgr[c2[0]][c2[1]+1]!=1  && ( c2[1]!= 9))
					{	
						c2[2]=c2[0];
						c2[3]= c2[1]+1;
						cgr[c2[0]][c2[1]]=1;
						cgr[c2[2]][c2[3]]=1;
						
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
					{
					i++;
					}
					System.out.println(c3[0]+" "+c3[1]);
					System.out.println(c3[0]<8);
				
					if((i!=0)&&( c3[0]<8) && (cgr[c3[0]+1][c3[1]]!=1) && (cgr[c3[0]+2][c3[1]]!=1) )
					{	
						c3[2]=c3[0]+1;
						c3[3]=c3[1];
						c3[4]=c3[0]+2;
						c3[5]=c3[1];
						cgr[c3[0]][c3[1]]=1;
						cgr[c3[2]][c3[3]]=1;
						cgr[c3[4]][c3[5]]=1;
						
					
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
					{
					i++;
					}
					System.out.println(c4[0]+" "+c4[1]);
					System.out.println(c4[0]<7);
				
					if((i!=0)&&( c4[0]<7) && (cgr[c4[0]+1][c4[1]]!=1) && (cgr[c4[0]+2][c4[1]]!=1) && (cgr[c4[0]+3][c4[1]]!=1))
					{	
						c4[2]=c4[0]+1;
						c4[3]=c4[1];
						c4[4]=c4[0]+2;
						c4[5]=c4[1];
						c4[6]=c4[0]+3;
						c4[7]=c4[1];
						cgr[c4[0]][c4[1]]=1;
						cgr[c4[2]][c4[3]]=1;
						cgr[c4[4]][c4[5]]=1;
						cgr[c4[6]][c4[7]]=1;
						
						
					
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
					{
					i++;
					}
					System.out.println(c5[0]+" "+c5[1]);
					System.out.println(c5[1]<6);
				
					if((i!=0)&&( c5[1]<6) && (cgr[c5[0]][c5[1]+1]!=1) && (cgr[c5[0]][c5[1]+2]!=1) && (cgr[c5[0]][c5[1]+3]!=1) && (cgr[c5[0]][c5[1]+4]!=1) )
					{	
						
						c5[2]=c5[0];
						c5[3]= c5[1]+1;
						c5[4]=c5[0];
						c5[5]= c5[1]+2;
						c5[6]=c5[0];
						c5[7]= c5[1]+3;
						c5[8]=c5[0];
						c5[9]= c5[1]+4;
						cgr[c5[0]][c5[1]]=1;
						cgr[c5[2]][c5[3]]=1;
						cgr[c5[4]][c5[5]]=1;
						cgr[c5[6]][c5[7]]=1;
						cgr[c5[8]][c5[9]]=1;
					
					}
					else
					i=0;
				}

			
			
			
			System.out.println("final "+c1[0]+" "+c1[1]);
			System.out.println(c2[0]+" "+c2[1]+" "+c2[2]+" "+c2[3]);
			System.out.println(c3[0]+" "+c3[1]+" "+c3[2]+" "+c3[3]+" "+c3[4]+" "+c3[5]);
			System.out.println(c4[0]+" "+c4[1]+" "+c4[2]+" "+c4[3]+" "+c4[4]+" "+c4[5] +" "+c4[6]+" "+c4[7]);
			System.out.println(c5[0]+" "+c5[1]+" "+c5[2]+" "+c5[3]+" "+c5[4]+" "+c5[5] +" "+c5[6]+" "+c5[7]+" "+c5[8]+" "+c5[9]);
			System.out.println();
			System.out.println();
			
			for(i=0;i<10;i++)
			{
				for(j=0;j<10;j++)
				System.out.print(cgr[i][j]+" ");
				System.out.println();
				
					
			
			}
	
		}

		public static void main(String[] args) {

			ran2 ra= new ran2();
			



		}

}