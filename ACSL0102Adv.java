package Competition;
import java.util.*;
public class ACSL0102Adv {
    public static void main(String[] args) {
        String[] inputs;
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++){
            int index = 1;
            String inputLine = sc.nextLine();
            inputs = inputLine.substring(0, inputLine.length()-2).split(",");
            for(int k = 0; k<inputs.length; k++){
            
                int input = ((int) (inputs[k].charAt(0))) - ('A'-1);
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

            
                input = (input + index);
                input = input%26;
                if(input == 0){
                    input = 26;
                }
                index = input;
                System.out.print((char) (input+('A'-1)) + " ");
            }
            System.out.println();
            Arrays.fill(inputs, null);
        }
    }
}
