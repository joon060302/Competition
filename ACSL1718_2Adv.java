package Competition;

import java.util.*;

public class ACSL1718_2Adv {
    public static void main(String[] args) {


        //[2+3*8-3)]+6
        //[(2-5)+6
        //[(5+5-2]*5
        //13-[(6+18)/3*22
        //[4/(12-8/4*25]
        //12+[10/(2-3]*8
        //45/5/(3+2)*3]*5
        //1+[2-(3*4/5]*6
        //32/4)*2
        //99/3/3*2/5-6)


        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<Integer> output = new ArrayList<Integer>();


        int counter = 0;
        int intstart = 0;
        for(int i=0; i<in.length(); i++){
            if(in.charAt(i) != '[' && in.charAt(i) != ']' && in.charAt(i) != '(' && in.charAt(i) != ')' && in.charAt(i) != '+' && in.charAt(i) != '-' && in.charAt(i) != '*' && in.charAt(i) != '/'){
                counter++;
                /*if(i == in.length()-1){
                    input.add(in.substring(i, i+1));
                }*/
                if(i == in.length()-1){
                    input.add(in.substring(i-counter+1));
                }
            }
            else{
                if(counter != 0){
                    input.add(in.substring(i-counter, i));
                }
                input.add(in.substring(i, i+1));
                counter = 0;
            }
        }

/* 
        boolean rightS = false;
        boolean leftS = false;
        boolean rightM = false;
        boolean leftM = false;
        char symbol = ' ';
        for(int i=0; i<input.size(); i++){
            if(input.get(i).equals("[")){
                leftM = true;
            }
            else if(input.get(i).equals("]")){
                rightM = true;
            }
            else if(input.get(i).equals("(")){
                leftS = true;
            }
            else if(input.get(i).equals(")")){
                rightS = true;
            }
        }*/

        int rightS = -1;
        int leftS = -1;
        int rightM = -1;
        int leftM = -1;
        char symbol = ' ';



        for(int i=0; i<input.size(); i++){
            if(input.get(i).equals("[")){
                leftM = i;
            }
            else if(input.get(i).equals("]")){
                rightM = i;
            }
            else if(input.get(i).equals("(")){
                leftS = i;
            }
            else if(input.get(i).equals(")")){
                rightS = i;
            }
        }



        if(leftM != -1 && rightM == -1){
            symbol = ']';
        }
        else if(leftM == -1 && rightM != -1){
            symbol = '[';
        }
        else if(leftS != -1 && rightS == -1){
            symbol = ')';
        }
        else if(leftS == -1 && rightS != -1){
            symbol = '(';
        }

        counter=0;
        if(symbol=='('){
            for(int i=0; i<leftM+1; i++){
                counter = counter+input.get(i).length();
            }
            for(int i=leftM+1; i<rightS-1; i++){
                if(input.get(i+1).equals("+") || input.get(i+1).equals("-") || input.get(i+1).equals("*") || input.get(i+1).equals("/")){
                    output.add(counter+1);
                }
                counter = counter+input.get(i).length();
            }
        }
        else if(symbol==')'){
            for(int i=0; i<leftS+2; i++){
                counter = counter+input.get(i).length();
            }
            for(int i=leftS+2; i<=rightM; i++){
                counter = counter+input.get(i).length();
                if(input.get(i-2).equals("+") || input.get(i-2).equals("-") || input.get(i-2).equals("*") || input.get(i-2).equals("/") || input.get(i).equals("]")){
                    output.add(counter);
                }
            }
        }
        else if(symbol=='['){
            for(int i=0; i<=leftS; i++){
                if(input.get(i+1).equals("+") || input.get(i+1).equals("-") || input.get(i+1).equals("*") || input.get(i+1).equals("/") || input.get(i).equals("(")){
                    output.add(counter+1);
                }
                counter = counter+input.get(i).length();
            }
        }
        else if(symbol==']'){
            for(int i=0; i<rightS+1; i++){
                counter = counter+input.get(i).length();

            }
            for(int i=rightS+1; i<input.size(); i++){

                
                if(input.get(i).equals("+") || input.get(i).equals("-") || input.get(i).equals("*") || input.get(i).equals("/") || i+1==input.size()){
                    if(i+1==input.size()){
                        counter = counter+input.get(i).length();
                    }
                    output.add(counter+1);
                }
                counter = counter+input.get(i).length();
            }
        }

        System.out.println(output);
    }





    public static int calc(ArrayList<String> input) {
        int out=0;
        int rightS = -1;
        int leftS = -1;
        int rightM = -1;
        int leftM = -1;
        System.out.println(input);


        for(int i=0; i<input.size(); i++){
            if(input.get(i).equals("[")){
                leftM = i;
            }
            else if(input.get(i).equals("]")){
                rightM = i;
            }
            else if(input.get(i).equals("(")){
                leftS = i;
            }
            else if(input.get(i).equals(")")){
                rightS = i;
            }
        }

        System.out.println(input);

        if(leftS != -1){
            for(int i=leftS+1; i<rightS; i++){
                if(input.get(i).equals("*")){
                    int temp = Integer.parseInt(input.get(i-1)) * Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightS = rightS-2;
                    rightM = rightM-2;
                }
                if(input.get(i).equals("/")){
                    int temp = Integer.parseInt(input.get(i-1)) / Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightS = rightS-2;
                    rightM = rightM-2;
                }

                System.out.println(input);
            }
            for(int i=leftS+1; i<rightS; i++){
                if(input.get(i).equals("+")){
                    int temp = Integer.parseInt(input.get(i-1)) + Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightS = rightS-2;
                    rightM = rightM-2;
                }
                if(input.get(i).equals("-")){
                    int temp = Integer.parseInt(input.get(i-1)) - Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightS = rightS-2;
                    rightM = rightM-2;
                }

                System.out.println(input);
            }
        }

        input.remove("(");
        input.remove(")");
        rightM--;

        System.out.println(input);
        System.out.println(rightM);

        if(leftM != -1){
            for(int i=leftM+1; i<rightM; i++){
                if(input.get(i).equals("*")){
                    int temp = Integer.parseInt(input.get(i-1)) * Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightM = rightM-2;
                }
                else if(input.get(i).equals("/")){
                    int temp = Integer.parseInt(input.get(i-1)) / Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightM = rightM-2;
                }

                System.out.println(input);
            }
            for(int i=leftM+1; i<rightM; i++){
                if(input.get(i).equals("+")){
                    int temp = Integer.parseInt(input.get(i-1)) + Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightM = rightM-2;
                }
                else if(input.get(i).equals("-")){
                    int temp = Integer.parseInt(input.get(i-1)) - Integer.parseInt(input.get(i+1));
                    input.subList(i-1, i+2).clear();
                    input.add(i-1, ""+temp);
                    i--;
                    rightM = rightM-2;
                }

                System.out.println(input);
            }
        }


        input.remove("[");
        input.remove("]");
        System.out.println(input);

        for(int i=0; i<input.size(); i++){
            if(input.get(i).equals("*")){
                int temp = Integer.parseInt(input.get(i-1)) * Integer.parseInt(input.get(i+1));
                input.subList(i-1, i+2).clear();
                input.add(i-1, ""+temp);
            }
            else if(input.get(i).equals("/")){
                int temp = Integer.parseInt(input.get(i-1)) / Integer.parseInt(input.get(i+1));
                input.subList(i-1, i+2).clear();
                input.add(i-1, ""+temp);
            }
        }
        for(int i=0; i<input.size(); i++){
            if(input.get(i).equals("+")){
                int temp = Integer.parseInt(input.get(i-1)) + Integer.parseInt(input.get(i+1));
                input.subList(i-1, i+2).clear();
                input.add(i-1, ""+temp);
            }
            else if(input.get(i).equals("-")){
                int temp = Integer.parseInt(input.get(i-1)) - Integer.parseInt(input.get(i+1));
                input.subList(i-1, i+2).clear();
                input.add(i-1, ""+temp);
            }
        }


        System.out.println(input);
        out = Integer.parseInt(input.get(0));
        return out;
    }
}
