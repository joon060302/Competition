package Competition;
import java.util.*;
public class ACSL0506_2Adv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] box = new int[9][9];
        for(int i=0; i<9; i++){
            String[] temp = new String[9];
            temp = (sc.nextLine()).split(",");
            for(int j=0; j<9; j++){
                box[i][j] = Integer.parseInt(temp[j]);
            }
        }
        
        int[][] input = new int[5][2];
        for(int i=0; i<5; i++){
            String[] temp = new String[2];
            temp = (sc.nextLine()).split(",");
            for(int j=0; j<2; j++){
                input[i][j] = Integer.parseInt(temp[j]);
            }
        }

        //System.out.println(Arrays.deepToString(box));
        //System.out.println(Arrays.deepToString(input));

        for(int i=0; i<5; i++){
            Set<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
            for(int j=0; j<9; j++){

                //System.out.println(box[input[i][0]-1][j] + ": row");
                //System.out.println(box[j][input[i][1]-1]+ ": col");
                set.remove(box[input[i][0]-1][j]);
                set.remove(box[j][input[i][1]-1]);
            }

            int row = (input[i][0]-1)-(input[i][0]-1)%3;
            int col = (input[i][1]-1)-(input[i][1]-1)%3;

            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    //System.out.println(box[row+j][col+k]);
                    set.remove(box[row+j][col+k]);
                }
            }

            int output = 0;
            for(int j : set){
                output = j;
            }

            System.out.println(output);
            box[input[i][0]-1][input[i][1]-1] = output;
        }

        
    }
}
