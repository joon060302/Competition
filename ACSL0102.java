package Competition;

import java.util.Scanner;

public class ACSL0102 {
    //Contest #1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++){
            int input = ((int) (sc.next().charAt(0))) - ('A'-1);
            if(input <= 5){
                input = (input*2);
                
            }
            else if (input <= 10){
                input = ((input%3)*5);
                
            }
            else if (input <= 15){
                input = ((input/4)*8);
                
            }
            else if (input <= 20){
                input = (((input%10) + (input/10)) * 10);
                
            }
            else if (input <= 26){
                int biggestFactor = 1;
                for(int j=2; j<=(input/2); j++){
                    if (input%j == 0){
                        biggestFactor = j;
                    }
                }
                input = (biggestFactor * 12);
            }
            
            if(input == 0){
                System.out.println('#');
            }
            else{
                input = (input%26) + ('A'-1);
                if(input == ('A'-1)){
                    input = input + 26;
                }
                System.out.println("output: " + (char)(input));
            }
            System.out.println();
        }
    }
}
