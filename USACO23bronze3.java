package Competition;

import java.util.Arrays;
import java.util.Scanner;

public class USACO23bronze3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); //number of strings
        String[] input = new String[q];
        sc.nextLine();
        for(int i=0; i<q; i++){
            input[i] = sc.nextLine();
        }
                //System.out.println(Arrays.toString(input));

        for(int i=0; i<q; i++){
            int output = 0;
		if(input[i].length()>2){
            int index = hasMO(input[i]);
            //System.out.println(index);
            if(index!=-1){
                output = input[i].length()-3;
                if(input[i].charAt(index)=='O'){
                    output++;
                }
                if(input[i].charAt(index+2)=='M'){
                    output++;
                }
            }
            else{
                output=-1;
            }
}
		else{
                output=-1;
            }	
            if(input[i].equals("OOO")){
                output = 1;
            }
            else if(input[i].equals("OOM")){
                output = 2;
            }
            System.out.println(output);
        }
    }

    public static int hasMO(String s) {
        int index=-1;
        //System.out.println(s);

        for(int i=0; i<s.length()-3; i++){
            //System.out.println(s.substring(i, i+2));
            if(s.substring(i, i+3).equals("MOO")){
                index = i;
                break;
            }
        }

        if(index ==-1){
            for(int i=0; i<s.length()-2; i++){
                //System.out.println(s.substring(i, i+2));
                if(s.substring(i, i+2).equals("MO")){
                    index = i;
                    break;
                }
            }
        }

        if(index ==-1){
            for(int i=0; i<s.length()-3; i++){
                if(s.substring(i, i+2).equals("OO")){
                    index = i;
                    break;
                }
            }
        }


        return index;
    }
}