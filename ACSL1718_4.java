package Competition;

import java.util.Arrays;
import java.util.Scanner;

public class ACSL1718_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt()-1;
        String in = sc.nextLine().replaceAll("\\s", "");
        in = in.toUpperCase();

        Character[] input = new Character[in.length()];
        for(int i=0; i<input.length; i++){
            input[i] = ' ';
        }
        char check=input[index];
        int counter=0;
        for(int i=0; i<input.length; i++){
            if(i==0){
                input[i]=in.charAt(i);
            }
            else{
                for(int j=0; j<input.length; j++){
                    if(input[j]==' '){
                        input[j] = in.charAt(i);
                        break;
                    }
                    else{
                        if((int)(input[j]) >= (int)(in.charAt(i))){
                            int tempindex=0;
                            for(int k=0;k<input.length;k++){
                                if(input[k]==' '){
                                    tempindex=k;
                                    break;
                                }
                            }

                            for(int k=tempindex-1; k>=j; k--){
                                input[k+1]=input[k];
                            }
                            input[j]=in.charAt(i);
                            break;
                        }
                    }
                }
            }
            if(check != input[index]){
                check = input[index];
                counter++;
            }

        }

        System.out.println(counter);
    }
}
