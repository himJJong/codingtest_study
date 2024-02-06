import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test01 {
    static final int num = 2000000000;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        // N 값 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        int[][] grid = new int[N][3];

        for(int i=0; i<N; i++){
            grid[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[N][3];
        for(int i=0; i<3; i++){
            if(i!= 1){
                if(grid[0][i] == 1){
                    dp[0][i] = num;
                }
                else dp[0][i] = 1;
            }
            else {
                if (grid[0][1] == 1) {
                    dp[0][1] = num;
                }

            }
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                if(grid[i][j] == 1) {
                    dp[i][j] = num;
                    continue;
                }

                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][1]+1, dp[i-1][2]+2));
                }

                else if(j == 1){
                    dp[i][j] = Math.min(dp[i-1][0]+1, Math.min(dp[i-1][j], dp[i-1][2]+1));
                }

                else if(j == 2){
                    dp[i][j] = Math.min(dp[i-1][0]+2, Math.min(dp[i-1][1]+1, dp[i-1][j]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            min = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        }

        System.out.println(min);
    }
}
/*
N+1행 3열 짜리 int형 배열이 있어. 각 값은 0과 1로 정해져있어. 해당 0행의 1열 값에 사람(2)이 있어. 이 사람은 1행부터 N행까지 0으로만 움직일건데, 열의 이동을 최소화해서 N행에 도착해야해. 아래 예시를 보여줄게. 열에서 열로 1칸이나 2칸을 움직일 수 있어. 1칸 움직이면 +1, 2칸 움직이면 +2야.


N = 5

5
0 1 0
1 0 0
0 1 0
0 0 1
0 1 0

answer : 3

N = 7

7
0 1 1
1 0 0
0 0 1
1 1 0
0 1 0
1 0 1
1 1 0

answer = 5



위의 범위로 N은5이상 1000이하야. 사람이 N행까지 최소 움직임 값을 구해주는 자바 코드를 작성해줘
 */
