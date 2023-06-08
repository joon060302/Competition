package Competition;

import java.util.Arrays;
import java.util.Scanner;

//C,C7,85,D6,46,D7,E6,87
//

public class ACSL1718_3adv {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] board = new int[8][8];
        String[] hexinput = sc.nextLine().split(",");
        String[] input = sc.nextLine().split(",");
        String[] directionArr = {"A","R","B","L"};
        for(int i=0; i<8; i++){
            String hex = convertHex(hexinput[i]);
            for(int j=0; j<8; j++){
                board[i][j] = hex.charAt(j)-48;
            }
        }

        int col = Integer.parseInt(input[1])-1;
        int row = Integer.parseInt(input[0])-1;
        String direction = input[2];
        for(int i=0; i<Integer.parseInt(input[3]); i++){  

            if(board[row][col] != 0){
                if(direction.equals("A")){
                    if(board[row][col] == 1){
                        direction = "L";
                    }
                    else if(board[row][col] == 2){
                        direction = "A";
                    }
                    else if(board[row][col] == 3){
                        direction = "R";
                    }
                    else if(board[row][col] == 4){
                        direction = "B";
                    }  
                }
                else if(direction.equals("B")){
                    if(board[row][col] == 1){
                        direction = "R";
                    }
                    else if(board[row][col] == 2){
                        direction = "B";
                    }
                    else if(board[row][col] == 3){
                        direction = "L";
                    }
                    else if(board[row][col] == 4){
                        direction = "A";
                    } 
                }
                else if(direction.equals("L")){
                    if(board[row][col] == 1){
                        direction = "B";
                    }
                    else if(board[row][col] == 2){
                        direction = "L";
                    }
                    else if(board[row][col] == 3){
                        direction = "A";
                    }
                    else if(board[row][col] == 4){
                        direction = "R";
                    }                  
                }
                else if(direction.equals("R")){
                    if(board[row][col] == 1){
                        direction = "A";
                    }
                    else if(board[row][col] == 2){
                        direction = "R";
                    }
                    else if(board[row][col] == 3){
                        direction = "B";
                    }
                    else if(board[row][col] == 4){
                        direction = "L";
                    } 
                }
            }


            board[row][col]++;
            if(board[row][col]>4){
                board[row][col]=0;
            }
            

            if(direction.equals("A")){
                row--;
            }
            else if(direction.equals("B")){
                row++;
            }
            else if(direction.equals("L")){
                col--;                    
            }
            else if(direction.equals("R")){
                col++;
            }


            if(row>7){
                row=0;
            }
            if(col>7){
                col=0;
            }
            if(row<0){
                row=7;
            }
            if(col<0){
                col=7;
            }

            System.out.println((row+1)+", "+(col+1));
        }

        System.out.println((row+1)+", "+(col+1));
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
