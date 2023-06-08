package Competition;
import java.util.*;
public class ACSL0405 {
    // Contest #2
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();
        String in = sc.nextLine();
        String[] temp = in.split(",");
        for(int i=0; i<temp.length; i++){
            input.add(Integer.parseInt(temp[i]));
        }
        int counter = 0;

        for(int i=0; i<input.size(); i++){

            if(input.get(i) == 0){
                for(int j=0; j<=i; j++){
                    input.remove(0);
                }
                i = 0;  
            }
        }
        counter++;

        while(!input.isEmpty()){

            int max = input.get(0);
            int index = 0;
            for(int i=0; i<input.size(); i++){
                if(max<=input.get(i)){
                    max = input.get(i);
                    index = i;
                }
            }

            if(max%2 == 0 && max !=0){
                input.set(index, input.get(index)-2);
                counter++;
            }
            else if (max%2 == 1 && max !=0){
                input.set(index, input.get(index)-1);
                counter++;
            }

            for(int i=0; i<input.size(); i++){

                if(input.get(i) == 0){
                    for(int j=0; j<=i; j++){
                        input.remove(0);
                    }
                    i = 0;
                    counter++;
                }
            }
        }


        System.out.println(counter);
    }

    
}
