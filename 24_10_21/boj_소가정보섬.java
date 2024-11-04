import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_소가정보섬 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[] cow = new int[N+1];
        String[] cowScore = br.readLine().split(" ");

        for(int i=0; i<N;i++){
            cow[i] = Integer.parseInt(cowScore[i]);
        }
        int[] sum = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            sum[i] = cow[(i)] * cow[(i+1)%N] * cow[(i+2)%N] * cow[(i+3)%N];
            answer += sum[i];
        }

        String[] output = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            int change = (Integer.parseInt(output[i]) - 1);

            answer -= sum[(change)] + sum[(change-1+N)%N] + sum[(change-2+N)%N] + sum[(change-3+N)%N];
            sum[(change + N) % N] = (sum[(change + N) % N] / cow[(change + N) % N]) * (-1 * cow[(change + N) % N]);
            sum[(change + N - 1) % N] = (sum[(change + N - 1) % N] / cow[(change + N - 1) % N]) * (-1 * cow[(change + N - 1) % N]);
            sum[(change + N - 2) % N] = (sum[(change + N - 2) % N] / cow[(change + N - 2) % N]) * (-1 * cow[(change + N - 2) % N]);
            sum[(change + N - 3) % N] = (sum[(change + N - 3) % N] / cow[(change + N - 3) % N]) * (-1 * cow[(change + N - 3) % N]);
            answer += sum[(change)] + sum[(change-1+N)%N] + sum[(change-2+N)%N] + sum[(change-3+N)%N];

            System.out.println(answer);
        }
    }
}
// -2 3 5 -6 10 -8 7 6
// -2 3 -5 -6 10 8 7 6
// -180 + 900 + 2400 + (-3260) + 3360 + 672 + (-252) + -360
//

// 3120 - 3260

