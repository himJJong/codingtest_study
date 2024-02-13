import java.util.*;
import java.io.*;
public class AutoEver_1_Review {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N <= 100,000
        int[][] ladder = new int[N][3];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                ladder[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = solution(ladder);
        System.out.println(res);
    }

    public static int solution(int[][] ladder){
        int n = ladder.length;
        int[][] dp = new int[n][3];
        for(int i=0; i<3; i++){
            dp[0][i] = ladder[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                int preMove = Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(k!=j){
                        preMove = Math.min(preMove, dp[i-1][k]);
                    }
                }
                dp[i][j] = ladder[i][j] == 1 ? Integer.MAX_VALUE : preMove + ladder[i][j];
            }
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}

/**
 * 사람이 1명 존재
 * 사다리타기(아래 예시와 같이 입력, 행은 3으로 고정, 열은 최대 100,000까지)
 * 1 0 0
 * 0 0 1
 * 0 0 0
 * 1 1 0
 * 0 0 1
 * 가운데에서 시작.
 * 내려갈 때, 1로 표시되어있으면 가지 못함.
 * 옆으로 한 칸 이동했을 때 +1, 두 칸 이동하면 +2.
 * 직선으로 내려가는 것은 이동 횟수 증가 없음.
 * 최소한의 이동으로 내려갈 때, 이동 횟수를 구하라.
 * 만약 시작 지점이 1라면 0인 지점으로 이동 후 +1
 * dp 알고리즘 사용
 * 맨 아래로 내려갈 때는 어디로 내려가든 상관없다.
 * 문제가 풀리지 않음..
 **/