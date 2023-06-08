package Competition;
import java.util.*;
public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashSet<String> set = new HashSet<>();
        HashSet<Character> runningSet = new HashSet<>();
        for(int i=0; i<input.length(); i++){
            String temp = "";
            for(int j=i; j<input.length(); j++){
                int temp1 = runningSet.size();
                runningSet.add(input.charAt(j));
                temp = temp + input.charAt(j);
                int temp2 = runningSet.size();
                if(temp1 == temp2 || j == input.length()-1){
                    set.add(temp.substring(0,temp.length()-1));
                    runningSet.clear();
                    temp = "";
                    
                }
            }
        }

        int max = 0;
        String output = "";
        for(String s : set){
            if (max<s.length()){
                max = s.length();
                output = s;
            }
        }
        System.out.println(max);
        System.out.println(output);
    }
}
