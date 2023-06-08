package Competition;

import java.util.Arrays;
import java.util.Scanner;

public class ACSL0302_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(",");
        int[] output = new int[5];
        int[] board = new int [Integer.parseInt(inputs[0])];
        for(int i=0; i<Integer.parseInt(inputs[1]); i++){
            board[Integer.parseInt(inputs[i+2])-1] = 1;
        }

        int runningCounter = 0;
        
        for(int i=0; i<Integer.parseInt(inputs[inputs.length-1])-1; i++){

            if(board[i] == 0){
                runningCounter++;

                output[runningCounter-1]++;
            }
            else{
                runningCounter = 0;
            }
        }

        System.out.print(output[0]);

        for(int i=1; i<output.length; i++){
            System.out.print("," + output[i]);
        } 
    }
}
