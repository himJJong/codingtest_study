import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1507 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dis = new int[N+1][N+1];
        int[][] org = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                dis[i][j] = Integer.parseInt(tmp[j-1]);
                org[i][j] = dis[i][j];
            }
        }

        for(int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if (dis[i][j] == dis[i][k] + dis[k][j]) {
                        org[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (org[i][j] != Integer.MAX_VALUE) {
                    result += org[i][j];
                }
            }
        }

        System.out.println(result);
    }
}
