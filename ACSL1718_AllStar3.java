package Competition;
import java.util.*;
public class ACSL1718_AllStar3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String in = sc.next();
        String series = sc.next();
        char letter = in.charAt(0);
        int startdigit = Integer.parseInt(""+in.substring(1));
        for(int i=0; i<series.length(); i++){
            if(Integer.parseInt(""+series.charAt(i))==1){
                startdigit++;
            }
            else if(Integer.parseInt(""+series.charAt(i))==2){
                if((int)letter%2==1){
                    startdigit++;
                }
                int temp = (int)letter;
                temp++;
                letter = (char)temp;
            }
            else if(Integer.parseInt(""+series.charAt(i))==3){
                if((int)letter%2==0){
                    startdigit--;
                }
                if(startdigit<1){
                    startdigit++;
                }
                else{
                    int temp = (int)letter;
                    temp++;
                    letter = (char)temp;
                }
            }
            else if(Integer.parseInt(""+series.charAt(i))==4){
                startdigit--;
                if(startdigit<1){
                    startdigit++;
                }
            }
            else if(Integer.parseInt(""+series.charAt(i))==5){
                if((int)letter%2==0){
                    startdigit--;
                }
                if(startdigit<1){
                    startdigit++;
                }
                else{
                    int temp = (int)letter;
                    temp--;
                    if(temp<(int)'A'){
                        temp++;
                    }
                    letter = (char)temp;
                }
            }
            else if(Integer.parseInt(""+series.charAt(i))==6){
                int temp = (int)letter;
                temp--;
                if(temp<(int)'A'){
                    temp++;
                }
                else{
                    if((int)letter%2==1){
                        startdigit++;
                    }
                }
                letter = (char)temp;
            }
            //System.out.println(""+letter+startdigit);
        }
        System.out.println(""+letter+startdigit);
    }


}
