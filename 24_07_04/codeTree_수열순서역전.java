import java.util.Scanner;

public class codeTree_수열순서역전 {
    public static final int MAX_N = 1001;

    public static int n;
    public static int[] arr = new int[MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 크기를 받습니다.
        n = sc.nextInt();

        // 배열을 입력받습니다.
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // dp 테이블을 -1로 초기화합니다. 하지만 대각선은 0으로 초기화합니다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = (i == j) ? 0 : -1;

        // dp[i][j] : i ~ j 구간을 반전시켜서
        // 같은 수열이 되도록 만드는 최소한의 삽입 횟수

        // 길이가 2인 구간부터 시작해서 점차 더 키워 dp를 채웁니다.
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                if (arr[start] == arr[end])
                    dp[start][end] = dp[start + 1][end - 1];
                else
                    dp[start][end] = Math.min(dp[start + 1][end], dp[start][end - 1]) + 1;
            }
        }

        // 결과를 출력합니다.
        System.out.println(dp[0][n - 1]);
    }
}