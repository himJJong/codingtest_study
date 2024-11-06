import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_20300 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] data = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        Arrays.sort(data);
        long min = Long.MIN_VALUE;
        long min1 = Long.MIN_VALUE;

        if(N % 2 == 0){ // 1 2 3 4
            for(int i=0; i<N/2; i++){
                min = Math.max(min, data[i]+ data[N-1-i]);
            }
            // 1 3
            // 2 3
            System.out.println(min);
        }

        else{
            for(int i=0; i<N/2; i++){ // 1 2 3 4 5
                min = Math.max(min, data[i]+ data[N-2-i]);
            }
            min = Math.max(min, data[N-1]);

            for(int i=1; i<=N/2; i++){ // 1 2 3 4 5
                min1 = Math.max(min1, data[i]+ data[N-i]);
            }
            min1 = Math.max(min1, data[1]);

            System.out.println(Math.min(min1, min));
        }
    }
}
// 1 | 2 3 4 5
// 1 2 3 4 | 5
// 2 3
// 5
// 1 | 2 2 5 6 7 8
// 1 10 9 11

// 1 2 2 5 6 7 | 10
// 8 8 7 8 -> 8
