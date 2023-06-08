package Competition;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Set;
public class ACSL0203_1 {
    //contest #3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] word = input.split(" ");
        System.out.println(word.length);
        
        int max = word[0].length();
        for(String str : word){
            if(max<str.length()){
                max = str.length();
            }
        }
        for(String str : word){
            if(str.length() == max){
                System.out.print(str + " ");
            }
        }
        System.out.println();

        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == ' '){
                continue;
            }
            if(ht.containsKey(input.charAt(i))){
                ht.put(input.charAt(i), ht.get(input.charAt(i))+1);
            }
            else{
                ht.put(input.charAt(i), 1);
            }
        }
        Set<Character> keys = ht.keySet();
        max=ht.get(input.charAt(0));
        char output = input.charAt(0);
        for(Character key:keys){
            if(max < ht.get(key)){
                max = ht.get(key);
                output = key;
            }
        }
        System.out.println(ht.size());
        System.out.println(output);

        Hashtable<String, Integer> ht2 = new Hashtable<String, Integer>();
        for(String str: word){
            if(str.equals("THE")){
                continue;
            }
            if(ht2.containsKey(str)){
                ht2.put(str, ht2.get(str)+1);
            }
            else{
                ht2.put(str, 1);
            }
        }
        Set<String> keys2 = ht2.keySet();
        max = ht2.get(word[0]);
        String output2 = word[0];
        for(String key:keys2){
            if(max<ht2.get(key)){
                max = ht2.get(key);
                output2 = key;
            }
        }
        System.out.println(output2);
    }
}
