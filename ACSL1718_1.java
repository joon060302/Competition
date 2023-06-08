package Competition;

import java.util.*;

import javax.management.openmbean.SimpleType;


public class ACSL1718_1 {

    /*
     * 87,5,8,9,7,4,6,3,9,0,2
     * 78,2,4,8,3,8,5,0,6,9,8
     * 85,7,9,7,6,5,9,4,5,0,1
     * 84,8,4,2,7,9,0,1,9,8,3
     * 95,9,0,9,0,1,0,1,0,2,5
     * 
     * 65,0,8,0,7,0,6,0,5,1,4
     * 74,2,0,1,8,2,0,1,7,0,4
     * 84,2,4,6,8,0,3,9,1,5,7
     * 92,0,1,2,3,4,5,6,7,8,9
     * 80,9,7,5,3,1,8,6,4,2,0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> player = new LinkedList<Integer>();
        String[] input = (sc.nextLine()).split(",");
        int total = Integer.parseInt(input[0]);

        player.add(Integer.parseInt(input[1]));
        player.add(Integer.parseInt(input[2]));
        player.add(Integer.parseInt(input[3]));
        //System.out.println(player);

        int counter = 4;
        boolean playerwon = true;

        while(total<=99){
            playerwon = false;
            total = addTotal(player.poll(), total);
            //System.out.println(player);
            player.add(Integer.parseInt(input[counter]));
            //System.out.println(player);
            //System.out.println(total);

            if(total>99){
                break;
            }

            counter++;
            playerwon = true;
            total = addTotal(Integer.parseInt(input[counter]), total);
            //System.out.println(total);
            counter++;
        }

        String winner;
        if(playerwon){
            winner = "player";
        }
        else{
            winner = "dealer";
        }
        System.out.println(total + ", "+ winner);
    }

    public static int addTotal(int a, int total){
        if(a == 9){
            total = total+0;
        }
        else if(a == 4){
            total = total-10;
        }
        else if(a == 0){
            if((total+11)>99){
                total++;
            }
            else{
                total = total+11;
            }
        }
        else{
            total = total + a;
        }
        return total;
    }
}
