import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int stone_n = Integer.parseInt(input[1]);

        // 금지된 돌 정보 저장
        Set<Integer> stone = new HashSet<>();
        for (int i = 0; i < stone_n; i++) {
            stone.add(Integer.parseInt(br.readLine().trim()));
        }

        // DP 배열 초기화
        int maxV = (int) Math.sqrt(2 * N) + 2; // 최대 속도
        int[][] dp = new int[N + 1][maxV + 1];

        // dp 배열을 큰 값으로 초기화
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= maxV; j++) {
                dp[i][j] = 10001; // 초기값 설정 (최소 점프 찾기)
            }
        }

        // 시작 위치 초기화
        dp[1][0] = 0;

        // DP로 최소 점프 횟수 계산
        for (int i = 2; i <= N; i++) {
            if (stone.contains(i)) continue; // 금지된 돌은 건너뜀

            for (int v = 1; v <= (int) Math.sqrt(2 * i); v++) {
                dp[i][v] = Math.min(
                        Math.min(dp[i - v][v - 1], dp[i - v][v]),
                        dp[i - v][v + 1]
                ) + 1;
            }
        }

        // 결과 계산
        int ans = 10001;
        for (int v = 0; v <= maxV; v++) {
            ans = Math.min(ans, dp[N][v]);
        }

        // 결과 출력
        System.out.println(ans == 10001 ? -1 : ans);
    }
}
