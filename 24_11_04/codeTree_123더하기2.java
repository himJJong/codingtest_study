import java.util.Scanner;

public class codeTree_123더하기2 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // dp 배열을 초기화합니다.
        long[][] dp = new long[n + 1][4]; // dp[i][j]: i를 만들 때 마지막 숫자가 j인 경우의 수

        // 초기값 설정
        if (n >= 1) dp[1][1] = 1; // 1을 만드는 경우 (1만 사용)
        if (n >= 2) dp[2][2] = 1; // 2를 만드는 경우 (2만 사용)
        if (n >= 3) dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1; // 3을 만드는 경우 (1+2, 2+1, 3)

        // dp 배열 채우기
        for (int i = 4; i <= n; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        // 결과 계산
        long result = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
        System.out.println(result);
    }
}
