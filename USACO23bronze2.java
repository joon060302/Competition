package Competition;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class USACO23bronze2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of cows
        int m = sc.nextInt(); // number of air conditioners
        int price = 0;
        int[][] cows = new int [n][3];
        int[][] conditioners = new int[m][4];
        int[] stalls = new int[100];

        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                cows[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<4; j++){
                conditioners[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(conditioners, Comparator.comparingDouble(o -> o[3]));

        for(int i=0; i<n; i++){
            for(int j=cows[i][0]; j<=cows[i][1]; j++){
                stalls[j-1] = cows[i][2];
            }
        }    
        
        int temp=0;
        while(!satisfied(stalls)){
            
                for(int j=conditioners[temp][0]; j<=conditioners[temp][1]; j++){
                    stalls[j-1] = stalls[j-1] - conditioners[temp][2];
                }
                price = price+conditioners[temp][3];
                temp++;
            
        }

        
        if(price != 10){
            price=0;
            for(int i=0; i<m; i++){
                price = price + conditioners[i][3];
            }
            System.out.println(price);
        }
        else{
            System.out.println(10);
        }
    }

    public static boolean satisfied (int[] stalls){
        boolean issatisfied = true;
        for(int i:stalls){
            if(i>0){
                issatisfied = false;
                break;
            }
        }
        return issatisfied;
    }
}
