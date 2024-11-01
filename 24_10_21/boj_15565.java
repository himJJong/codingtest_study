import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int s = 0;
        int e = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        while (e < N) {
            if (data[e] == 1) {
                cnt++;
            }
            e++;

            while (cnt == K) {
                min = Math.min(min, e - s);
                if (data[s] == 1) {
                    cnt--;
                }
                s++;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
