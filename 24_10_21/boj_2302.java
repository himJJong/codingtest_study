import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2302 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        if(N==1)    {
            System.out.println(1);
            System.exit(0);
        }
        int[] dp = new int[N+1];

        for(int i=0; i<M; i++){
            set.add(Integer.parseInt(br.readLine()));
        }

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        int cnt = 0;
        int answer = 1;
        for(int i=1; i<=N; i++){
            if(set.contains(i)){
                if(cnt == 0)    continue;
                answer *= dp[cnt];
                cnt = 0;
            }
            else{
                cnt++;
            }
        }
        if(cnt != 0){
            answer *= dp[cnt];
        }

        System.out.println(answer);
    }
}
