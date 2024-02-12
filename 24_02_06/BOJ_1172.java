import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1172 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;

        Arrays.fill(dp,Integer.MIN_VALUE);

        for(int i=data.length-1; i>=0; i--){
            dp[i] = 1;
            for(int j=data.length-1; j>=i; j--) {
                if(data[i] > data[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
