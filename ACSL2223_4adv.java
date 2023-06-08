package Competition;
import java.util.*;
public class ACSL2223_4adv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String targets = sc.nextLine();
        int[][] grid = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j ++){
                grid[i][j]=0;
            }
        }
        
        targets = targets.trim();
        String[] input = targets.split(" ");
        int[] result = new int[input.length];
        for(int i=0; i<input.length; i++){
            grid[Integer.valueOf(input[i].substring(0, 1))][Integer.valueOf(input[i].substring(1, 2))] = 1;
        }

        for(int i=0; i<input.length; i++){
            int row = Integer.valueOf(input[i].substring(0, 1));
            int col = Integer.valueOf(input[i].substring(1, 2));
            while(row!=0){
                row--;
                if(grid[row][col]==1){
                    break;
                }
                if(row==0){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(row!=0 && col!=0){
                row--;
                col--;
                if(grid[row][col]==1){
                    break;
                }
                if(row==0 || col==0){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(col!=0){
                col--;
                if(grid[row][col]==1){
                    break;
                }
                if(col==0){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(col!=0 && row!=size-1){
                col--;
                row++;
                if(grid[row][col]==1){
                    break;
                }
                if(col==0 || row==size-1){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(row!=size-1){
                row++;
                if(grid[row][col]==1){
                    break;
                }
                if(row==size-1){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(row!=size-1 && col!=size-1){
                row++;
                col++;
                if(grid[row][col]==1){
                    break;
                }
                if(row==size-1 || col==size-1){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(col!=size-1){
                col++;
                if(grid[row][col]==1){
                    break;
                }
                if(col==size-1){
                    result[i]++;
                }
            }
            row = Integer.valueOf(input[i].substring(0, 1));
            col = Integer.valueOf(input[i].substring(1, 2));
            while(row!=0 && col!=size-1){
                row--;
                col++;
                if(grid[row][col]==1){
                    break;
                }
                if(row==0 || col==size-1){
                    result[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        int max=0;
        int count=0;
        for(int i=0; i<result.length; i++){
            if(result[i]>max){
                max = result[i];
            }
        }
        for(int i=0; i<result.length; i++){
            if(result[i]==max){
                count++;
            }
        }
        System.out.println(max);
        System.out.println(count);
        String[] outputarray = new String[count];
        int newcounter=0;
        for(int i=0; i<result.length; i++){
            if(result[i]==max){
                outputarray[newcounter] = input[i];
                newcounter++;
            }
        }
        Arrays.sort(outputarray);
        System.out.println(Arrays.toString(outputarray));
        String out = outputarray[0];
        for(int i=1; i<outputarray.length; i++){

            out = out +", "+ outputarray[i];
        }
        System.out.println(out);
    }
}
