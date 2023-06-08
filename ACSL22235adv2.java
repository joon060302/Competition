package Competition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class ACSL22235adv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String unused = sc.nextLine();
        String rows = sc.nextLine();
        String[] reference = original.split(" ");
        String[] arr = original.split("\\W+");
        String[] unimportant = unused.split("\\W+");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(unimportant));
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(arr));
        String[][] table = new String[arr.length][3];
        int max = 0;
        for(String s:arr){
            if(max<s.length()){
                max=s.length();
            }
        }
        for(int i=0; i<table.length; i++){
            String temp=arr[i];
            while(temp.length()<max){
                temp = temp+"-";
            }
            table[i][1] = temp;
        }


        for(int i=0; i<table.length; i++){
            String temp = "";
            int index = 0;
            for (int j=0; j<reference.length; j++){
                if(reference[j].equals(table[i])){
                    for(int k=1; k<=3; k++){
                        index = j-k;
                        if (index<0){
                            break;
                        }
                        else if (reference[index].contains(".") || reference[index].contains(",") || reference[index].contains("?") || reference[index].contains("!") || reference[index].contains(";") || reference[index].contains(":")){
                            
                        }
                    }
                }
            }
        }



        for (int i = 0; i < table.length; i++){
 
            // Loop through all elements of current row
            for (int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
