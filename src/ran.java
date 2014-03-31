import java.util.*;

class ran
{
		public int p1[],p2[],p3[],p4[],p5[];
		public int f1,f2,f3,f4,f5, temp,i,j;
		ran()
		{
			Random r= new Random();
			f1=f2=f3=f4=f5=0;
			p1= new int[2];
			p2= new int[4];	
			p3=	new int[6];			
			System.out.println("dcjhdsg");
			
			while(f1==0)
			{i=0;
				while(i<2)
				{
				
					p1[i]= r.nextInt(10);
					i++;
				}
				f1=1;
			}
			
			while(f2==0)
			{	i=0;
				while(i<2)
				{
					p2[i]= r.nextInt(10);
					
					if(p1[i]==p2[i])
						i=-1;
					i++;
				}
				
				if(p2[1]+1!=p1[1] )
				{
				
					p2[i]=p2[0];
					p2[i+1]=p2[1]+1;
				
				}
				f2=1;
				
			}
			while(f3==0)
			{	i=0;
				while(i<2)
				{
					p3[i]= r.nextInt(10);
					
					if(p1[i]==p3[i])
						i=-1;
					if(i!=-1 && p2[i]==p3[i])
						i=-1;
					if(i!=-1 && p2[i+2]==p3[i] )
						i=-1;
					
					i++;
				}
				
				if(p3[0]-1!=p1[0] && p3[0]-1 !=p2[0] && p3[0]-1 !=p2[2] )
				{
				
					p3[i]=p3[0]-1;
					p3[i+1]=p3[1];
				
				}
				i=i+2;
				if(p3[2]-1!=p1[0] && p3[2]-1 !=p2[0] && p3[2]-1 !=p2[2] )
				{
				
					p3[i]=p3[0]-1;
					p3[i+1]=p3[1];
				
				}
				f2=1;
				
			}
			
			
			System.out.println(p1[0]+" "+p1[1]);
			System.out.println(p2[0]+" "+p2[1]+" "+p2[2]+" "+p2[3]);
		
		
		}

		public static void main(String[] args) {

			ran ra= new ran();
			



		}

}