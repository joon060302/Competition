package Competition.usaco2023feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mooloo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int total = 0;
        int [] days = new int[n];
        int [] gaps = new int[n-1];
        for(int i=0;i<n; i++){
            tokenizer = new StringTokenizer(in.readLine());
            int temp = Integer.parseInt(tokenizer.nextToken());
            days[i] = temp;
        }
        for(int i=0; i<n-1; i++){
            gaps[i] = days[i+1]-days[i];
        }
        System.out.println(Arrays.toString(gaps));

        for(int i=1; i<n; i++){
            
        }
    }
}
