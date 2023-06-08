package Competition;
import java.util.*;
public class recordKeeping {
    public static void main(String[] args) {

        Hashtable<Set<String>, Integer> ht = new Hashtable<Set<String>, Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=0; i<n; i++){
            Set<String> cows = new HashSet<String>();
            cows.clear();
            for(int j=0; j<3; j++){
                String temp = sc.next();
                cows.add(temp);
            }

            if(ht.containsKey(cows)){
                ht.put(cows, ht.get(cows)+1);
            }
            else{
                ht.put(cows, 1);
            }
            

        }
        

        Set<Set<String>> keys = ht.keySet();
        int max = 0;
        Set<String> ans = new HashSet<String>();
        for(Set<String> key : keys){
            if(max<ht.get(key)){
                max = ht.get(key);
                ans = key;
            }
        }

        System.out.println(max);
        System.out.println(ans);
    }
}
