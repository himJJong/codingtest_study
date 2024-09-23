import java.util.*;
import java.io.*;

public class codeTree_정수사각최댓값최소 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][N+1];
        int[][] data = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

        // dp 초기화
        dp[1][1] = data[1][1];  // 출발 지점 초기화

        // DP 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 1) continue;  // 시작점은 이미 초기화했으므로 패스

                if (i == 1) {  // 첫 번째 행은 왼쪽에서만 이동 가능
                    dp[i][j] = Math.max(dp[i][j-1], data[i][j]);
                } else if (j == 1) {  // 첫 번째 열은 위쪽에서만 이동 가능
                    dp[i][j] = Math.max(dp[i-1][j], data[i][j]);
                } else {
                    dp[i][j] = Math.min(Math.max(dp[i-1][j], data[i][j]), Math.max(dp[i][j-1], data[i][j]));
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}
