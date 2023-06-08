package Competition;
import java.io.PipedOutputStream;
import java.util.*;
public class ACSL0405Adv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();

        String in = sc.nextLine();
        String[] temp = in.split(",");

        int max = Integer.parseInt(temp[0]);
        for(String i:temp){
            if (max < Integer.parseInt(i)){
                max = Integer.parseInt(i);
            }
        }

        int[] occ = new int[max+1];

        for(int i=0; i<temp.length; i++){
            input.add(Integer.parseInt(temp[i]));
            occ[Integer.parseInt(temp[i])]++;
        }

        //placed all the elements into an arraylist, # of occurence to occ
        int counter = 0;

        while(!input.isEmpty()){

            int size = input.size();
            for(int i=0; i<input.size(); i++){
                if(input.get(i) == 0){
                    for(int j=0; j<=i; j++){
                        occ[input.get(0)]--;
                        input.remove(0);
                    }
                    i = 0;
                }
            }

            if(size != input.size()){
                counter++;
            }
            
            int maxOcc = 0;
            int maxOccNum = 0;
            
            for(int i = 0; i<occ.length; i++){
                if (maxOcc <= occ[i]){
                    maxOcc = occ[i];
                    maxOccNum = i;
                }
            }

            if(maxOccNum != 0){
                for(int i=input.size()-1; i>=0; i--){
                    if(maxOccNum == input.get(i)){
                        
                        counter++;
                        occ[maxOccNum]--;

                        if(maxOccNum%2==1){
                            input.set(i, maxOccNum-1);
                            occ[maxOccNum-1]++;
                            break;
                        }

                        else if(maxOccNum%2 == 0) {
                            input.set(i, maxOccNum-2);
                            occ[maxOccNum-2]++;
                            break;
                        }
                    }
                }
            }
            
        }

        System.out.println(counter);
    }
}
