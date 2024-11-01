import java.io.*;
import java.util.*;
public class boj_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k+1];
        for (int testCase = 0; testCase < n; testCase++) {
            coin[testCase] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp,100001);
        dp[0] = 0;

        for (int index = 0; index < coin.length; index++) {
            for (int i = coin[index]; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin[index]] + 1);
            }
        }

        if (dp[k] == 100001) {
            dp[k] = -1;
        }
        System.out.println(dp[k]);
    }
}