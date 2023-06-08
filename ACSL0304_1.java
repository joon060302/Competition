package Competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ACSL0304_1 {
    //Contest #1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();
        for(int i=0; i<5; i++){


            int in = sc.nextInt();
            while (in%10 !=in){
                input.add(in - ((in/10) * 10));
                in = in/10;
            }
            input.add(in - ((in/10) * 10));
            in = in/10;
            Collections.reverse(input);


            int max = input.get(0);
            int index = 0;
            for(int j=0; j<input.size(); j++){
                if (max < input.get(j)){
                    index = j;
                    max = input.get(j);
                }
            }

            if(max % 2 ==1){
                max = 0;
                input.set(index, max);
            }
            else{
                max = max + 4;
                input.set(index, max%10);
            }

            int output = 0;
            Collections.reverse(input);
            for(int j=0; j<input.size(); j++){

                output = (int)(output + (input.get(j) * Math.pow(10, (double)j)));

            }

            System.out.println(output);
            input.clear();
        }
    }
}
