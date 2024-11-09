import java.util.*;
import java.io.*;

public class boj_2631 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        int[] data = new int[N+1];

        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MIN_VALUE;
        for(int i=2; i<=N; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(data[i] > data[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(N-answer);
    }
}
// 3 7 5 2 6 1 4
