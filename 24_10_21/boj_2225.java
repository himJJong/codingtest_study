import java.util.Arrays;
import java.util.Scanner;

public class boj_2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[1],1);
        for(int i=2; i<=K; i++){
            for(int j=0; j<=N; j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
