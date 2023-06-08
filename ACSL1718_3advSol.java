package Competition;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ACSL1718_3advSol {

	private static int row=0;
	private static int col=0;
	private static String d="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
B2, F, F3, A1, 4E, 3, 78, B
C, C7, 85, D6, 46, D7, E6, 87	
*/
		Scanner input=new Scanner(System.in);
		String[] s=input.nextLine().split(", ");
		int[][] t=new int[8][8];
		for(int i=0;i<s.length;i++)
		{
			//int n=HexToDecimal(s[i]);
			//System.out.println(n);
			//s[i]=DecimalToBinary(n);
			s[i]=Integer.toBinaryString(Integer.parseInt(s[i],16));
			System.out.println(s[i]);

		}

		for(int i=0;i<s.length;i++)
		{
			int j=0;
			int n=8-s[i].length();
			while(j<n)
			{
				t[i][j]=0;
				++j;
			}
			int k=0;
			while(k<s[i].length())
			{
				t[i][j]=Integer.parseInt(s[i].charAt(k)+"");
				++j;
				++k;
			}
		}

		for(int i=0;i<t.length;i++)
		{
			for(int j=0;j<t[i].length;j++)
			{
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		

		System.out.print("Input positions,Direction,Numeber of Move : ");
		String ss=input.nextLine();
		StringTokenizer st=new StringTokenizer(ss,", ");
		row=Integer.parseInt(st.nextToken())-1;
		col=Integer.parseInt(st.nextToken())-1;
		d=st.nextToken();
		int moves=Integer.parseInt(st.nextToken());
		for(int i=1;i<=moves;i++)
		{
			System.out.println((row + 1) + ", " + (col + 1));
			switch(d) {
			case("L"):
				LfinalLocation(t);
			break;
			case("R"):
				RfinalLocation(t);
			break;
			case("B"):
				BfinalLocation(t);
			break;
			case("A"):
				AfinalLocation(t);
			break;
			}
		}
		System.out.println((row + 1) + ", " + (col + 1));

	}
	
	public static void LfinalLocation(int[][] t)
	{
		if(t[row][col] == 0) 
		{
			if(col == 7) col=0;
			else col++;
		}
		else 
		{
			if(t[row][col] % 4 == 1) 
			{
				t[row][col]++;
				d = "B";
				if(row == 0) row = 7;
				else row--;	
			}
			else if(t[row][col] % 4 == 2) 
			{
				t[row][col]++;
				d = "L";
				if(col == 7) col = 0;
				else col++;
			}
			else if(t[row][col] % 4 == 3) 
			{
				t[row][col]++;
				d = "A";
				if(row == 7) row = 0;
				else row++;
			}
			else if(t[row][col] % 4 == 0) 
			{
				t[row][col]++;
				d = "R";
				if(col == 0) col = 7;
				else col--;
			}		
		}
	}
       
	public static void RfinalLocation(int[][] t)
	{
		if(t[row][col] == 0) 
		{
			if(col == 0) col = 7;
			else col--;
		}
		else {
			if(t[row][col] % 4 == 1) 
			{
				t[row][col]++;
				d = "A";
				if(row == 7) row = 0;
				else row++;
			}
			else if(t[row][col] % 4 == 2) 
			{
				t[row][col]++;
				d = "R";
				if(col == 0) col = 7;
				else col--;
			}
			else if(t[row][col] % 4 == 3) 
			{
				t[row][col]++;
				d = "B";
				if(row == 0) row = 7;
				else row--;
			}
			else if(t[row][col] % 4 == 0) 
			{
				t[row][col]++;
				d = "L";
				if(col == 7) col = 0;
				else col++;
			}		
		}
	}
	
	public static void BfinalLocation(int[][] t)
	{
		if(t[row][col] == 0) 
		{
			if(row == 0) row  = 7;
			else row--;
		}
		else {
			if(t[row][col] % 4 == 1) 
			{
				t[row][col]++;
				d = "R";
				if(col == 0) col = 7;
				else col--;
			}
			else if(t[row][col] % 4 == 2) 
			{
				t[row][col]++;
				d = "B";
				if(row == 0) row = 7;
				else row--;
			}
			else if(t[row][col] % 4 == 3) 
			{
				t[row][col]++;
				d = "L";
				if(col == 7) col = 0;
				else col++;
			}
			else if(t[row][col] % 4 == 0) 
			{
				t[row][col]++;
				d = "A";
				if(row == 7) row = 0;
				else row++;
			}		
		}
	}
		
	public static void AfinalLocation(int[][] t)
	{
		if(t[row][col] == 0) 
		{
			if(row == 7) row = 0;
			else row++;
		}
		else {
			if(t[row][col] % 4 == 1) 
			{
				t[row][col]++;
				d = "L";
				if(col == 7) col = 0;
				else col++;
			}
			else if(t[row][col] % 4 == 2) 
			{
				t[row][col]++;
				d = "A";
				if(row == 7) row = 0;
				else row++;
			}
			else if(t[row][col] % 4 == 3) 
			{
				t[row][col]++;
				d = "R";
				if(col == 0) col = 7;
				else col--;
			}
			else if(t[row][col] % 4 == 0) 
			{
				t[row][col]++;
				d = "B";
				if(row == 0) row = 7;
				else row--;
			}		
		}	
	}
}