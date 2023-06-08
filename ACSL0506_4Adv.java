package Competition;
import java.util.*;
public class ACSL0506_4Adv {

    

     
    private static int[][] board = new int[7][7];
    private static ArrayList<int[][]> boardHis = new ArrayList<int[][]>();
    private static ArrayList<Integer> pathway = new ArrayList<Integer>();
    private static int count = 0;

    public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		//1,1,2,2,2,3,3,2,3,3,4,3,4,4,5,4,5,5,5,1,0,0
		//1,5,2,3,2,4,2,5,3,2,3,5,4,2,4,5,5,2,5,5,1,4,1,2,0,0

		int[][] t=new int[6][6];
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
		
        /* 
		for(int i=1;i<t.length;i++)
		{
			for(int j=1;j<t[i].length;j++)
			{
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		System.out.print("Input pair of nodes : ");
		String[] n=input.nextLine().split(",");
		int n1=Integer.parseInt(n[0]);
		int n2=Integer.parseInt(n[1]);
		int n3=Integer.parseInt(n[2]);
		int n4=Integer.parseInt(n[3]);
		
		int path=findPathway(ArrayCopy(t),n1,n2,n3,n4);
			
		if(path>0)
		{
			System.out.println(path);
		}
		else
		{
			System.out.println("NONE");
		}
	}
	
	public static int[][] ArrayCopy(int[][] src) {
		int[][] dest = new int[src.length][src[0].length];
		for (int i = 1; i < src.length; i++)
		{
			for (int j = 1; j < src[0].length; j++)
			{
				dest[i][j] = src[i][j];
			}
		}
		return dest;
	}
	
	public static int findPathway(int[][] unused, int m1, int m2, int m3, int m4)
	{
		if (m1 == m3 && m2 == m4) 
		{
			return 1;
		}
		if (unused[m1][m2]==0)
		{
			return 0;
		}

		unused[m1][m2] = 0;
		int numPaths = 0;
				
		if (m1-1 >= 0)
		{
			if (unused[m1-1][m2]==1)
			{
				numPaths += findPathway(ArrayCopy(unused), m1-1, m2, m3, m4);
			}
		}

		if (m1+1 < unused.length)
		{
			if (unused[m1+1][m2]==1)
			{
				numPaths += findPathway(ArrayCopy(unused), m1+1, m2, m3, m4);
			}
		}
		
		if (m2-1 >= 0)
		{
			if (unused[m1][m2-1]==1)
			{
				numPaths += findPathway(ArrayCopy(unused),m1, m2-1, m3, m4);
			}
		}
		
		if (m2+1 < unused[0].length)
		{
			if (unused[m1][m2+1]==1)
			{
				numPaths += findPathway(ArrayCopy(unused), m1, m2+1, m3, m4);
			}
		}
		return numPaths;
	}
}