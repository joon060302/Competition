package Competition.usaco2023feb;
import java.util.*;
public class stat {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        String arr1[] = new String[40];
        String arr2[] = new String[30];
        for(int i=0; i<40; i++){
            arr1[i] = sc.nextLine();
        }
        for(int i=0; i<30; i++){
            arr2[i] = sc.nextLine();
        }
        for(String s : arr2){
            for(String s2 : arr1){
                if (s.equals(s2)){
                    System.out.println(s);
                }
            }
        }
    }
}
