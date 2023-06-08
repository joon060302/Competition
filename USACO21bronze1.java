package Competition;

import java.util.Scanner;
import java.util.HashMap;

public class USACO21bronze1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        sc.nextLine();
        String[][] input = new String[rep][8];
        String[] zodiacs = {"Ox", "Tiger",
            "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat","Ox", "Tiger",
            "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat", "OX","Tiger",
            "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat", "OX"};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bessie", 0);

        //put input to array
        for(int i=0; i<rep; i++){
            String line = sc.nextLine();
            input[i] = line.split(" ");
        }

        for(int i=0; i<rep; i++){
            String start = "";
            if(i>0){
                int temp = map.get(input[i][7]);
                while(!(temp>11 && temp<=23)){
                    temp=temp+12;
                }
                start = zodiacs[temp];
            }
            else{
                start = "Ox";
            }
            String zodiac = input[i][4];
            int yearDiff = 0;

            //System.out.println(zodiac);
            //System.out.println(start);


            if(input[i][3].equals("previous")){
                for(int j=zodiacs.length-1; j>=0; j--){
                    if(zodiacs[j].equals(start)){
                        for(int k=j; k>=0; k--){
                            if(zodiacs[k].equals(zodiac)){
                                break;
                            }
                            else{
                                yearDiff--;
                            }
                            //System.out.println(yearDiff);
                        }
                        break;
                    }
                }
            }
            else{
                for(int j=0; j<zodiacs.length; j++){
                    if(zodiacs[j].equals(start)){
                        for(int k=j; k<zodiacs.length; k++){
                            if(zodiacs[k].equals(zodiac)){
                                break;
                            }
                            else{
                                yearDiff++;
                            }
                        }
                        break;
                    }
                }
            }


            if(i==0){
                map.put(input[i][0], yearDiff);
            }
            else{
                map.put(input[i][0], yearDiff + map.get(input[i][7]));
            }


/* 
            for (String name: map.keySet()) {
                String key = name.toString();
                String value = map.get(name).toString();
                System.out.println(key + " " + value);
            } */

        }

       /*  for (String name: map.keySet()) {
            String key = name.toString();
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }*/

        System.out.println(Math.abs(map.get("Elsie")));
    }
}
