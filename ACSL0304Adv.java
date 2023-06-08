package Competition;
import java.util.*;
public class ACSL0304Adv {
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


            int mean = 0;
            for(int n:input){
                mean = mean + n;
            }
            mean =  (mean / input.size());

            int index = 0;
            for(int j=0; j<input.size(); j++){
                if(input.get(j)<=mean){
                    index = j;
                    break;
                }
            }
            for(int j=0; j<input.size(); j++){
                if((input.get(j) <= mean) && (input.get(j) > input.get(index))){

                    index = j;
                }
            }



            if(input.get(index) == 0 || input.get(index) == 1 || input.get(index) == 2){
                input = r012(input, index);
            }
            else if(input.get(index) == 3 || input.get(index) == 4 || input.get(index) == 5){
                input = r345(input, index);
            }
            else if(input.get(index) == 6 || input.get(index) == 7 || input.get(index) == 8){
                input = r678(input, index);
            }
            else if(input.get(index) == 9){
                input.set(index, 0);
            }

            int output = 0;
            for(int j=0; j<input.size(); j++){
                output = output + ((int)Math.pow(10, j) * input.get(input.size()-j-1));
            }
            System.out.println(output);
            input.clear();
        }
    }

    public static ArrayList<Integer> r012 (ArrayList<Integer> input, int index){

        int max = input.get(0);
        for(int i:input){
            if (max<i){
                max = i;
            }
        }
        input.set(index, max);

        return input;
    }

    public static ArrayList<Integer> r345 (ArrayList<Integer> input, int index){

        int max = input.get(0);
        for(int i:input){
            if (max>i){
                max = i;
            }
        }
        input.set(index, max);

        return input;
    }

    public static ArrayList<Integer> r678 (ArrayList<Integer> input, int index){

        int sum = 0;
        for(int i:input){
            sum = sum + i;
        }
        input.set(index, sum%10);

        return input;
    }
}
