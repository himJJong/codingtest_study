import java.util.Scanner;

public class codeTree_2배보다 {
    public static final int Div = 1000000007;
    public static final int MAX_M = 2001;
    public static final int MAX_N = 11;

    public static int n, m;
    public static long[][] dp = new long[MAX_N][MAX_M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n과 m을 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();

        // 초기 조건 설정: 첫 번째 열의 모든 값을 1로 설정합니다.
        for (int j = 1; j <= m; j++)
            dp[1][j] = 1;

        // dp 배열을 채웁니다.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= j/2; k++) {
                    dp[i][j] += (dp[i-1][k]) % Div;
                    System.out.println("i값:"+i +" j값:" +j + " k값:"+k + " dp[i][j]: "+dp[i][j] + " dp[i-1][k]: "+dp[i-1][k]);
                }
            }
        }

        // 최종 결과를 계산합니다.
        long result = 0;
        for (int j = m; j >= 1; j--) {
            result = (result + dp[n][j]) % Div;
        }

        // 결과를 출력합니다.
        System.out.println(result);
    }
}