package Competition;

import java.util.*;

public class ACSL1718_1Adv {


    /* 75,7,3,8,8,7,T,5,9,A,6
     * 80,9,T,7,8,K,A,3,5,Q,T
     * 94,4,2,2,7,T,3,A,5,J,K
     * 80,6,6,4,T,9,8,6,5,Q,K
     * 90,T,8,5,9,9,Q,K,A,J,8
     * 
     * 65,5,6,7,8,9,T,J,Q,K,A
     * 74,A,2,9,T,9,7,A,9,8,A
     * 55,A,K,Q,J,T,A,K,Q,J,T
     * 59,A,T,K,A,Q,A,T,7,9,4
     * 70,T,Q,9,9,A,Q,J,K,Q,T
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> player = new ArrayList<Integer>();
        String[] input = (sc.nextLine()).split(",");
        int[] card = new int[input.length];
        int total = Integer.parseInt(input[0]);

        for(int i=0; i<input.length; i++){
            if(input[i].equals("T")){
                card[i] = 10;
            }
            else if (input[i].equals("A")){
                card[i] = 14;
            }
            else if (input[i].equals("J")){
                card[i] = 11;
            }
            else if (input[i].equals("Q")){
                card[i] = 12;
            }
            else if (input[i].equals("K")){
                card[i] = 13;
            }
            else{
                card[i] = Integer.parseInt(input[i]);
            }
        }

        player.add(card[1]);
        player.add(card[2]);
        player.add(card[3]);
        //System.out.println(player);

        int counter = 4;
        boolean playerwon = true;

        while(total<=99){
            playerwon = false;
            total = addTotal(Collections.max(player), total);
            player.remove(Collections.max(player));
            //System.out.println(player);
            player.add(card[counter]);
            //System.out.println(player);
            //System.out.println(total);

            if(total>99){
                break;
            }

            counter++;
            playerwon = true;
            total = addTotal(card[counter], total);
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
        if(a == 10){
            total = total-10;
        }
        else if (a == 14){
            if((total+14)>99){
                total++;
            }
            else{
                total = total+14;
            }
        }
        else if (a == 9){
            total = total;
        }
        else{
            total = total + a;
        }
        return total;
    }
}
