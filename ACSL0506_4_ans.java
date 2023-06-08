package Competition;
//solution
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACSL0506_4_ans {

	private static int[][] t=new int[6][6];
	private static ArrayList<Integer> pathway=new ArrayList<Integer>();
  
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		//1,1,2,2,3,2,4,3,4,4,5,5,5,1,0,0
		//1,5,2,3,2,4,3,2,3,5,4,2,4,5,5,2,5,5,0,0
		System.out.print("Input data : ");
		String[] a=input.nextLine().split(",");
		
		for(int i=0;i<a.length-1;i+=2)
		{
			int row=Integer.parseInt(a[i]);
			int col=Integer.parseInt(a[i+1]);
			if(row!=0&& col!=0)
			{
				t[row][col]=1;
			}
		}
		
		for(int i=1;i<t.length;i++)
		{
			for(int j=1;j<t[i].length;j++)
			{
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.print("Input pair of nodes : ");
		String[] n=input.nextLine().split(",");
		int n1=Integer.parseInt(n[0]);
		int n2=Integer.parseInt(n[1]);
		int n3=Integer.parseInt(n[2]);
		int n4=Integer.parseInt(n[3]);
		
		if(t[n1][n2]==1)
		{
			pathway.add(n1);
			pathway.add(n2);
		}
		boolean path=findPathway(n1,n2,n3,n4);
			
		if(!path)
		{
			System.out.println("None");
		}
		else
		{
			System.out.println(pathway);
		}
	}
	
	public static boolean findPathway(int m1, int m2, int m3, int m4)
	{
		boolean visit=true;
		if(m1<m3 && m2<m4)
		{
			if(t[m1+1][m2]==1)
			{
				m1++;
			}
			else if(t[m1+1][m2+1]==1)
			{
				m1++;
				m2++;
			}
			else if(t[m1][m2+1]==1)
			{
				m2++;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);
			}
		}
		else if(m1<m3 && m4<m2)
		{
			if(t[m1+1][m2]==1)
			{
				m1++;
			}
			else if(t[m1+1][m2-1]==1)
			{
				m1++;
				m2--;
			}
			else if(t[m1][m2-1]==1)
			{
				m2--;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);
			}
		}
		else if(m3<m1 && m2<m4)
		{
			if(t[m1-1][m2]==1)
			{
				m1--;
			}
			else if(t[m1-1][m2+1]==1)
			{
				m1--;
				m2++;
			}
			else if(t[m1][m2+1]==1)
			{
				m2++;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);
			}
		}
		else if(m3<m1 && m4<m2)
		{
			if(t[m1-1][m2]==1)
			{
				m1--;
			}
			else if(t[m1-1][m2-1]==1)
			{
				m1--;
				m2--;
			}
			else if(t[m1][m2-1]==1)
			{
				m2--;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);
			}
		}
		else if(m1<m3 && m2==m4)
		{
			if(t[m1+1][m2]==1)
			{
				m1++;
			}
			else if(t[m1+1][m2-1]==1)
			{
				m1++;
				m2--;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);		
			}
		}

		
		
		else if(m3<m1 && m2==m4)
		{
			if(t[m1-1][m2]==1)
			{
				m1--;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);		
			}
		}
		
		else if(m1==m3 && m2<m4)
		{
			if(t[m1][m2+1]==1)
			{
				m2++;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);	
			}
		}
		else if(m1==m3 && m4<m2)
		{
			if(t[m1][m2-1]==1)
			{
				m2--;
			}
			else
			{
				visit=false;
			}
			if(visit)
			{
				pathway.add(m1);
				pathway.add(m2);
				return findPathway(m1,m2,m3,m4);	
			}
		}
		return visit;
	}
}


