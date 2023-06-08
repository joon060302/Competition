package Competition;

import java.util.*;

public class ACSL1718_3 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Scanner sc = new Scanner(System.in);
        String in = "";
        for(int i=0; i<4; i++){
            in = sc.next();
            if(in.length()<4){
                while(in.length()<4){
                    in = "0"+in;
                }
            }
            for(int j=0; j<in.length(); j++){
                arr[i][j] = Integer.parseInt(in.substring(j, j+1));
            }
        }

        int intx=sc.nextInt() -1;
        int inty=sc.nextInt() -1;
        
        for(int i=0; i<6; i++){

            int tempx=intx;
            int tempy=inty;


            if(arr[intx][inty] == 0){
                inty++;
            }
            else if(arr[intx][inty] == 1){
                inty--;
            }
            else if(arr[intx][inty] == 2){
                intx--;
            }
            else if(arr[intx][inty] == 3){
                intx++;
            }


            if(intx>3){
                intx=0;
            }
            else if (intx<0){
                intx=3;
            }
            else if (inty>3){
                inty=0;
            }
            else if (inty<0){
                inty=3;
            }


            arr[tempx][tempy]=arr[tempx][tempy]+1;
            if(arr[tempx][tempy]>3){
                arr[tempx][tempy]=0;
            }
        }

        System.out.println((intx+1)+", "+(inty+1));
    }
}
