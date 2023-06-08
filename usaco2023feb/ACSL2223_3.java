package Competition.usaco2023feb;
import java.util.*;
public class ACSL2223_3 {
    public static void main(String[] args) {
        System.out.println(onlyLeftOrRight("BINARYSEARCHTREE"));
        
    }
    public static String onlyLeftOrRight(String input) {
        String output1="";
        String output2="";
        input=input.toUpperCase();
        char[] arr1 = new char[input.length()];
        int[] arr2 = new int[input.length()];
        for(int i=0; i<input.length(); i++){
            if(i==0){
                arr1[0] = input.charAt(i);
                arr2[0] = 0;
            }
            else{
                for(int j=0; j<=i; j++){
                    if(j==i){
                        arr1[j] = input.charAt(i);
                        arr2[j] = arr2[j-1]+1;
                        break;
                    }
                    else if(input.charAt(i)<=arr1[j]){
                        for(int k=i;k>j;k--){
                            arr1[k] = arr1[k-1];
                            arr2[k] = arr2[k-1];
                        }
                        arr1[j] = input.charAt(i);
                        if(j==0){
                            arr2[j] = arr2[j+1]+1;
                        }
                        else{
                            arr2[j] = Math.max(arr2[j-1], arr2[j+1])+1;
                        }
                        break;
                    }
                }
                
            }
        }
        
        for(int i=0; i<arr1.length; i++){
            boolean instr1 = false;
            boolean instr2 = false;
            
            for(int j=i-1; j>=0; j--){
                if(arr2[j] < arr2[i]){
                    break;
                }
                if(arr2[j] == arr2[i]+1){
                    instr1=true;
                    break;
                }
            }
            
            for(int j=i+1; j<arr1.length; j++){
                if(arr2[j] < arr2[i]){
                    break;
                }
                if(arr2[j] == arr2[i]+1){
                    instr2=true;
                    break;
                }
            }
            
            
            if(instr1){
                if(!instr2){
                    output1 = output1 + arr1[i];
                }
            }
            else if(instr2){
                if(!instr1){
                    output2 = output2 + arr1[i];
                }
            }
            //System.out.println(arr1[i] +" "+ instr1+instr2);
        }
        
        if(output1.equals("") || output2.equals("")){
            return "NONE";
        }
        else{
            return output1 + " " + output2;
        }
    }
}
