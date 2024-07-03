import java.io.*;
import java.util.*;

public class codeTree_경유지최단경로 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[][] map = new int[N][M];
        int[][] dp = new int[N+1][M+1];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i-1][j-1] == 0){
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + 1;
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}