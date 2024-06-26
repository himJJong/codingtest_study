import java.util.Scanner;

public class codeTree_nxm이동 {
    public static final int MAX_N = 501;
    public static final int MOD = 1000000007;

    public static int n, m;
    public static int[][] map = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    // descent 함수는 (x, y)에서 시작하여 (n, m)으로 내려가는 경로의 수를 반환합니다.
    public static int descent(int x, int y) {
        // (x, y)가 (n, m)과 같으면 1을 반환합니다.
        if (x == n && y == m) return 1;

        // dp[x][y]의 값이 -1이 아니면, 계산된 결과를 반환합니다.
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 새로운 위치가 유효하고, 현재 위치의 높이가 새로운 위치의 높이보다 높다면
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m)
                    if (map[x][y] > map[nx][ny]) {

                        // dp[x][y]에 descent(nx, ny)를 더합니다.
                        dp[x][y] += descent(nx, ny);
                        dp[x][y] %= MOD;
                    }
            }
        }
        return dp[x][y]; // dp[x][y]의 값을 반환합니다.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // dp 배열을 -1로 초기화합니다.
        for (int i = 1; i <= MAX_N - 1; i++)
            for (int j = 1; j <= MAX_N - 1; j++)
                dp[i][j] = -1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                map[i][j] = sc.nextInt();

        // (1, 1)에서 시작하여 (n, m)으로 내려가는 경로의 수를 출력합니다.
        System.out.println(descent(1, 1));
    }
}