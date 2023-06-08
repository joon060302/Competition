package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL22235adv {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        String string3 = sc.nextLine();
        String combined = (string1+" "+string2+" "+string3);
        String[] intervals = combined.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        //System.out.println(Arrays.toString(intervals));

        for(int i=0;i<intervals.length; i++){
            int start = 0;
            int end = 0;
            String temp = "";
            if(intervals[i].equals("null")){
                break;
            }
            else{
                int j=1;
                while (intervals[i].charAt(j) != ','){
                    temp = temp + "" + intervals[i].charAt(j);
                    j++;
                }
                start = Integer.parseInt(temp);
                temp = "";
                j++;

                while (intervals[i].charAt(j) != ')' && intervals[i].charAt(j) != ']'){
                    temp = temp + "" + intervals[i].charAt(j);
                    j++;
                }
                end = Integer.parseInt(temp);
                
                if(intervals[i].charAt(0) == '('){
                    start++;
                }
                if(intervals[i].charAt(intervals[i].length()-1) == ')'){
                    end--;
                }
                
                numbers.add(start); numbers.add(end);
                //System.out.println(start+" "+end);
            }
        }
        int min=numbers.get(0);
        int max=numbers.get(0);
        for(Integer i : numbers){
            if(i<min){
                min = i;
            }
            if(i>max){
                max = i;
            }
        }
        int[][] index = new int[max-min+1][2];
        for(int i=min; i<=max; i++){
            index[i-min][0] = i;
        }

        for (int i = 0; i < index.length; i++){
 
        // Loop through all elements of current row
        for (int j = 0; j < index[i].length; j++){
            System.out.print(index[i][j] + " ");
        }
        System.out.println();
    }
        for(int i=0; i<numbers.size(); i=i+2){
            int startindex=0;
            System.out.println(numbers.get(i));
            for(int k=0; k<index.length; k++){
                if(index[k][0]==numbers.get(i)){
                    startindex=k;
                    break;
                }
            }
            for(int j=0; j<=numbers.get(i+1)-numbers.get(i); j++){
                index[startindex+j][1]++;
            }
        }


/* 
        for (int i = 0; i < index.length; i++){
 
            // Loop through all elements of current row
            for (int j = 0; j < index[i].length; j++){
                System.out.print(index[i][j] + " ");
            }
            System.out.println();
        }*/

        int return1 = 0;
        int return2 = 0;
        String returnstring = "";
        for(int i=0; i<index.length; i++){
            if(index[i][1] ==1){
                return1 = return1 +index[i][0];
            }
            if(index[i][1] ==2){
                return2 = return2 +index[i][0];
            }
        }
        
        if(string3.equals("null")){
            returnstring = return1+"";
        }
        else{
            returnstring = return1+" "+return2;
        }
        System.out.println(returnstring);
    }
}
