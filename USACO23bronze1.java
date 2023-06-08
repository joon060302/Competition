package Competition;


import java.util.Scanner;

public class USACO23bronze1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of cows
        sc.nextLine();
        String list = sc.nextLine();
        int gcount = 0;
        int hcount = 0;
        int guernsey = 0;
        int holstein = 0;
        int firstg = 0;
        int firsth = 0;
        int[] range = new int[n];
        for(int i=0; i<n; i++){
            range[i] = sc.nextInt();
            if (list.charAt(i) == 'G'){
                if(guernsey == 0){
                    firstg = i;
                }
                guernsey++;
            }
            else{
                if(holstein == 0){
                    firsth = i;
                }
                holstein++;
            }
        }
        
        //System.out.println(firstg);
        //System.out.println(firsth);

        for(int i=0; i<n; i++){
            if(list.charAt(i) == 'G'){
                if(leaderg(range, firstg, firsth, i, guernsey, list)){
                    gcount++;
                }
            }
            else{
                if(leaderh(range, firstg, firsth, i, holstein, list)){
                    hcount++;
                }
            }
            //System.out.println(gcount + " "+hcount);
        }

        System.out.println(gcount*hcount);
    }




    public static boolean leaderg(int[] range, int firstg, int firsth, int index, int guernsey, String list) {
        boolean isleader = false;
        boolean containleader = false;
        boolean hasallmem = false;
        int countg = 0;

        if(index<firsth && range[index]-1>=firsth){
            containleader = true;
        }

        if(index == firstg){
            for(int i=index; i<range[index]; i++){
                if(list.charAt(i) == 'G'){
                    countg++;
                }
            }
            if(countg == guernsey){
                hasallmem = true;
            }
        }

        if(containleader || hasallmem){
            isleader = true;
        }
        return isleader;
    }

    public static boolean leaderh(int[] range, int firstg, int firsth, int index, int holstein, String list) {
        boolean isleader = false;
        boolean containleader = false;
        boolean hasallmem = false;
        int counth = 0;

        if(index<firstg && range[index]-1>=firstg){
            containleader = true;
        }

        if(index == firsth){
            for(int i=index; i<range[index]; i++){
                if(list.charAt(i) == 'H'){
                    counth++;
                }
            }
            if(counth == holstein){
                hasallmem = true;
            }
        }

        if(containleader || hasallmem){
            isleader = true;
        }
        return isleader;
    }
}
