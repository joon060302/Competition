package Competition.usaco2023feb;

import java.util.Scanner;

public class eat_hay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();               // input Cow(N), AirCon(M)
        String[] numbers = userInput.split(" ");  // " " seperate number
        int line = Integer.parseInt(numbers[0]);
        long T_day = Long.parseLong(numbers[1]);

        long[] d_day = new long[line]; 
        long[] b_hay = new long[line];

        for(int i=0; i<line; i++) {
            userInput = sc.nextLine();
            numbers = userInput.split(" ");
            d_day[i] = Long.parseLong(numbers[0]);
            b_hay[i] = Long.parseLong(numbers[1]);
        }

        long hay_total = 0;
        long eat_hay = 0;
        int k = 0;
        for (long i=0; i<T_day; i++){
            for(int j=k; j<line; j++){    //calculate total hay;
                if(d_day[j] == (i+1)){
                    hay_total = hay_total + b_hay[j];    
                    k=j+1;    
                }

                //System.out.printf("hay_total : %d", hay_total);
            }

            if(hay_total>0){
                eat_hay = eat_hay + 1;
                hay_total = hay_total - 1;
            }

            
        }       
        System.out.printf("%d", eat_hay);
    }    
}