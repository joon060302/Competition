package Competition;

import java.util.*;

public class ACSL1718_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] temp = (sc.nextLine()).toCharArray();
        List eq = Arrays.asList(temp);
        for(int i=0; i<eq.size(); i++){
            if(eq.get(i).equals('(')){
                System.out.println(left(eq, i));
            }
            else if (eq.get(i).equals(')')){
                System.out.println(right(eq, i));
            }
        }
    }

    public static double calc(final String str) {
        return new Object() {
            int pos = -1, ch;
            
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
            
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
            
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
            
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
            
            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
                
                double x=0;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                }
                
                return x;
            }
        }.parse();
    }


    public static ArrayList<Integer> left(List eq, int location) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        int counter = location;
        while(counter<eq.size()){
            if(!eq.get(counter).equals('+') && !eq.get(counter).equals('-') && !eq.get(counter).equals('/') && !eq.get(counter).equals('*')){
                eq.add(counter+1, ')');
                out.add((int)calc(String.join("", eq)));
                eq.remove(counter+1);
            }
            counter++;
        }
        return out;
    }

    public static ArrayList<Integer> right(List eq, int location) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        int counter = location;
        while(counter>0){
            if(!eq.get(counter).equals('+') && !eq.get(counter).equals('-') && !eq.get(counter).equals('/') && !eq.get(counter).equals('*')){
                eq.add(counter-1, ')');
                out.add((int)calc(String.join("", eq)));
                eq.remove(counter-1);
            }
            counter--;
        }
        return out;
    }
}
