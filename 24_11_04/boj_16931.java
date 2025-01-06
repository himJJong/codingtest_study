import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_16931 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int answer = 0;
        int[][] data = new int[Integer.parseInt(tmp[0])][];
        for(int i=0; i<Integer.parseInt(tmp[0]); i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        answer += (Integer.parseInt(tmp[0]) * Integer.parseInt(tmp[1]))*2;

        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int once = 0;
        for(int i=0; i<N; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<M; j++){
                max = Math.max(max, data[i][j]);
            }
            once += max;
        }
        answer += (once * 2);

        int twice = 0;
        for(int i=0; i<N; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<M; j++){
                max = Math.max(max, data[j][i]);
            }
            twice += max;
        }
        answer += (twice * 2);
        System.out.println(answer);
    }
}
