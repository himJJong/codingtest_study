import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int D = Integer.parseInt(tmp[0]);
        int N = Integer.parseInt(tmp[1]);

        int[] bowl = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] pizza = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[D];
        dp[0] = bowl[0];
        for (int i = 1; i < D; i++) {
            dp[i] = Math.min(dp[i - 1], bowl[i]);
        }

        int depth = D - 1;
        for (int i = 0; i < N; i++) {
            while (depth >= 0 && pizza[i] > dp[depth]) {
                depth--;
            }
            if (depth < 0) {
                System.out.println(0);
                return;
            }
            depth--;
        }
        System.out.println(depth + 2);
    }
}
