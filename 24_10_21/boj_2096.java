import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 이전 행과 현재 행의 DP 값을 저장하기 위한 배열
        int[][] minDp = new int[2][3];
        int[][] maxDp = new int[2][3];

        // 첫 번째 행 초기화
        String[] tmp = br.readLine().split(" ");
        for (int j = 0; j < 3; j++) {
            int value = Integer.parseInt(tmp[j]);
            minDp[0][j] = value;
            maxDp[0][j] = value;
        }

        for (int i = 1; i < N; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            // 현재 행을 계산하여 minDp[1]과 maxDp[1]에 저장
            maxDp[1][0] = Math.max(maxDp[0][0], maxDp[0][1]) + a;
            minDp[1][0] = Math.min(minDp[0][0], minDp[0][1]) + a;

            maxDp[1][1] = Math.max(maxDp[0][0], Math.max(maxDp[0][1], maxDp[0][2])) + b;
            minDp[1][1] = Math.min(minDp[0][0], Math.min(minDp[0][1], minDp[0][2])) + b;

            maxDp[1][2] = Math.max(maxDp[0][1], maxDp[0][2]) + c;
            minDp[1][2] = Math.min(minDp[0][1], minDp[0][2]) + c;

            // 현재 행 값을 이전 행으로 이동
            for (int j = 0; j < 3; j++) {
                maxDp[0][j] = maxDp[1][j];
                minDp[0][j] = minDp[1][j];
            }
        }

        // 마지막 행에서 최대, 최소 값 계산
        int max = Math.max(maxDp[0][0], Math.max(maxDp[0][1], maxDp[0][2]));
        int min = Math.min(minDp[0][0], Math.min(minDp[0][1], minDp[0][2]));

        System.out.println(max + " " + min);
    }
}
