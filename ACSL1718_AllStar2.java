package Competition;

import java.util.*;

public class ACSL1718_AllStar2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> input = new HashMap<>();
        String in = sc.next();
        int freq = sc.nextInt();

        for(int i=0; i<in.length(); i++){
            if(input.containsKey(in.charAt(i)+"")){
                input.put(in.charAt(i)+"", input.get(in.charAt(i)+"")+1);
            }
            else{
                input.put(in.charAt(i)+"", 1);
            }
        }

        List<String> outlist = new ArrayList<String>();
        for (String key : input.keySet()){
            if(input.get(key) == freq){
                outlist.add(key);
            }
        }

        input = sortHashMapByValues(input);

        while(input.size()>1) {
            Set<String> keys = input.keySet();
            List<String> listKeys = new ArrayList<String>( keys );
            String newstring = addstring(listKeys.get(0),listKeys.get(1));
            input.put(newstring, input.get(listKeys.get(0))+input.get(listKeys.get(1)));
            input = sortHashMapByValues(input);
            input.remove(listKeys.get(0));
            input.remove(listKeys.get(1));
            if(input.get(newstring) == freq){
                outlist.add(newstring);
            }
            //System.out.println(input);
            //System.out.println(outlist);
        }
        Collections.sort(outlist);
        //System.out.println(outlist);
        if(outlist.isEmpty()){
            System.out.println("NONE");
        }
        else{    
            outlist.forEach((n) -> System.out.print(n));
        }
    }
        
    public static String addstring (String s1, String s2){
        String out = "";
        if(s1.compareTo(s2)>0){
            out = s2+s1;
        }
        else if(s1.compareTo(s2)<0){
            out = s1+s2;
        }
        else{
            out = s1+s2;
        }
        return out;
    }

    public static LinkedHashMap<String, Integer> sortHashMapByValues (HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            int val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                int comp1 = passedMap.get(key);
                int comp2 = val;

                if (comp1==(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        //System.out.println(sortedMap);
        return sortedMap;
    }
    
}
