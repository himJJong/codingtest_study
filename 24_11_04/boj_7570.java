import java.io.IOException;
import java.util.*;

public class boj_7570 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] dp = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int k = scan.nextInt();
            dp[k] = dp[k-1]+1;
            max = Math.max(dp[k], max);
        }

        System.out.println(n-max);
    }
}