import java.io.*;
import java.util.*;
/*
조합 O(N^M)
N은 주사위의 개수,
M은 도착해야 하는 보드 칸 수.

dp O(N*M)
 */
public class sol3 {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);    // 주어지는 주사위 수
        int M = Integer.parseInt(NM[1]);    // 가야하는 보드칸
        int[] dp = new int[M+1];            // int[] dp 배열선언
        // 주사위 값 초기화
        int[] dice = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp[0] = 1;                          // 0번째 칸은 1로 고정

        for(int i=1; i<=M; i++){            // 1부터 M칸까지 갈 수 있는 방법을 기억
            for(int diceNumber : dice){     // 주어진 주사위의 데이터 값으로만
                if(i - diceNumber >= 0){    // 이동이 가능한 값들에 대해 이전 위치에서 현재로 올 수 있다면 갱신
                    dp[i] += dp[i-diceNumber];
                }
            }
        }

        System.out.println(dp[M]);
    }
}