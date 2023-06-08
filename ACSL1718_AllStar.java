package Competition;

import java.lang.reflect.Array;
import java.util.*;

/*
 * 
0C C7 85 D6 46 D7 E6 87
2 2 00 01
2 3 010 000
4 1 0 0 1 1
1 2 11
3 2 10 11 01
4 4 0000 1100 1000 1101
2 2 11 11
2 4 0110 0111
1 4 0000
3 2 11 10 11



FD 53 4E 61 A8 72 BC 09
2 2 10 01
4 2 11 10 01 00
1 3 001
1 1 1
3 3 110 001 111
2 1 1 1
2 4 1111 0111
1 2 00
1 3 010
1 4 1010
 */



public class ACSL1718_AllStar {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        Character[][] array = new Character[8][8];
        Character[][] target;
        Character[][] subarray;

        for(int i=0; i<8; i++){
            String temp = sc.next();
            temp = convertHex(temp);
            for(int j=0; j<8; j++){
                array[i][j] = temp.charAt(j);
            }
        }

        int row=0;
        int col=0;
        int counter=0;

        for(int i=0; i<10; i++){
            row=sc.nextInt();
            col=sc.nextInt();
            String in = "";
            target = new Character[row][col]; 
            subarray = new Character[row][col]; 
            for(int j=0; j<row; j++){
                in = sc.next();
                for (int k=0; k<col; k++){
                    target[j][k] = in.charAt(k);
                }
            }
            //System.out.println(Arrays.deepToString(target));

            for(int j=0; j<=8-row; j++){
                for(int k=0; k<=8-col; k++){
                    for(int l=j; l<j+row; l++){
                        for(int m=k; m<k+col; m++){
                            subarray[l-j][m-k] = array[l][m];
                            
                        }
                    }
                    //System.out.println(Arrays.deepToString(subarray));
                    //System.out.println(j + "," + k);
                    if(Arrays.deepEquals(target, subarray)){
                        counter++;
                    }
                }
            }

            System.out.println("output: " + counter);
            counter = 0;
        }
    }

    public static String convertHex (String hex){
        String out="";
        char[] digit = hex.toCharArray();
        for(int i=0; i<digit.length; i++){
            String tempout="";
            int before=0;
            if(digit[i]=='A'){
                before = 10;
            }
            else if(digit[i]=='B'){
                before = 11;
            }
            else if(digit[i]=='C'){
                before = 12;
            }
            else if(digit[i]=='D'){
                before = 13;
            }
            else if(digit[i]=='E'){
                before = 14;
            }
            else if(digit[i]=='F'){
                before = 15;
            }
            else{
                before = Character.getNumericValue(digit[i]);
            }
            while(before>0){
                if(before%2==1){
                    tempout = "1"+tempout;
                }
                else{
                    tempout = "0"+tempout;
                }
                before=before/2;
            }

            if(tempout.length()<4){
                while(tempout.length()<4){
                    tempout = "0"+tempout;
                }
            }
            out=out+tempout;
        }

        if(out.length()<8){
            while(out.length()<8){
                out="0"+out;
            }
        }
        return out;
    }
}
