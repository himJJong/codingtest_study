import java.io.*;
import java.util.*;
public class boj_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int t = 0; t < n; t++) {
            int coin = Integer.parseInt(br.readLine());

            for (int i = coin; i <= k; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }

        System.out.print(dp[k]);
    }
}