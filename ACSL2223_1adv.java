package Competition;

public class ACSL2223_1adv {
    public static void main(String[] args) {
        String s = "00000111111110010";
        String replacement = Integer.toBinaryString(0);
        s=(s.replaceFirst(replacement, ""));
        //System.out.println(s);
        
        System.out.println(findLastBinary("Roses are red."));
    }

    public static int findLastBinary(String s) {
        StringBuilder str = new StringBuilder();
        s = stringToBinary(s);
        int occurence = 2;
        int counter = 0;
        String out="";
        System.out.println(s);
        while (true){
            occurence = countOccurence(s, Integer.toBinaryString(counter));
            System.out.println(occurence);
            String reg = ""+Integer.toBinaryString(counter);
            if (occurence<1){
                
                out = reg;
                break;
            }
            else{
                
                System.out.println(reg);
                //System.out.println(s);
                s=s.replaceFirst(reg, "");

                if(occurence>1){
                str.append(s);
                str.reverse();
                s=str.toString();

                str.setLength(0);
                str.append(reg);
                str.reverse();
                reg = str.toString();
                str.setLength(0);
                s=s.replaceFirst(reg, "");
                str.append(s);
                str.reverse();
                s=str.toString();
                str.setLength(0);
                //replaceFirst2(s, reg, "");
                //s=s.replaceFirst("(?s)(.*)" + Integer.toBinaryString(counter), "$1"+"");
                }
                counter++;
                System.out.println(s);
            }
        }
        System.out.println(out);
        return binarytoDeci(out)-1;
    }

    public static int countOccurence (String s, String subs){
        int counter=0;
        int index=0;
        while (true){
            index = s.indexOf(subs, index);
            if(index!=-1){
                counter++;
                index = index+subs.length();
            }
            else{
                break;
            }
        }
        return counter;
    }
    
    public static String stringToBinary (String s){
        String output = "";
        String temp = "";
        for(int i=0; i<s.length(); i++){
            temp = Integer.toBinaryString((int)(s.charAt(i)));
            if(temp.length()<8){
                while(temp.length()<8){
                    temp = "0"+temp;
                }
            }
            output = output+temp;
        }
        return output;
    }

    public static int binarytoDeci (String s){
        int output = 0;
        int counter = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                output = output + (int)Math.pow(2, counter);
            }
            counter++;
        }
        return output;
    }
} 

