import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] check = new int[N + 1]; // N + 1로 설정하여 범위 벗어남을 방지

        for (int i = 0; i < M; i++) {
            String[] cur = br.readLine().split(" ");
            int from = Integer.parseInt(cur[0]) - 1;
            int to = Integer.parseInt(cur[1]) - 1;
            int value = Integer.parseInt(cur[2]);

            check[from] += value;
            check[to + 1] -= value;

        }
        for (int i = 1; i < N; i++) {
            check[i] += check[i - 1];
        }
        for (int i = 0; i < N; i++) {
            arr[i] += check[i];
            System.out.print(arr[i] + " ");
        }
    }
}
