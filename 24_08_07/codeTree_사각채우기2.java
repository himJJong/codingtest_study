import java.util.*;

public class codeTree_사각채우기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N <= 2){
            if(N == 1){
                System.out.println(1);

            }
            else if(N==2){
                System.out.println(3);
            }
            System.exit(0);
        }

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;


        for(int i=3; i<=N; i++){
            if(i % 2 == 1){
                dp[i] = (dp[i-1] * 2 - 1) % 10007;
            }
            else{
                dp[i] = (dp[i-1] * 2 + 1) % 10007;
            }
        }

        System.out.println(dp[N]);
    }
}