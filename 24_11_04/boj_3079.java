import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_3079 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]); // 심사대
        int M = Integer.parseInt(tmp[1]); // 사람
        int max = Integer.MIN_VALUE;
        int[] gate = new int[N];

        for(int i=0; i<gate.length; i++){
            gate[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, gate[i]);
        }

        Arrays.sort(gate);
        long answer = 0;
        long left = 0;
        long right = (long) max * M;

        while(left <= right) {
            long mid = (left + right) / 2;

            long cur = 0;
            for (int i = 0; i < N; i++) {
                if (cur >= M) break;
                cur += mid / gate[i];
            }

            if (cur >= M) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
}
