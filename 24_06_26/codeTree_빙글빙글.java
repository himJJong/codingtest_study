import java.io.*;
import java.util.*;

public class codeTree_빙글빙글 {
    static class Point{
        int cnt;
        int sum;

        Point(int cnt, int sum){
            this.cnt = cnt;
            this.sum = sum;
        }
    }
    static int N;
    static int M;
    static int Q;
    static int r1;
    static int r2;
    static int c1;
    static int c2;
    static int[][] map;
    static int[]dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        Q = Integer.parseInt(tmp[2]);

        map = new int[N][M];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }




        while(Q-- >0){
            tmp = br.readLine().split(" ");
            r1 = Integer.parseInt(tmp[0]) - 1;
            c1 = Integer.parseInt(tmp[1]) - 1;
            r2 = Integer.parseInt(tmp[2]) - 1;
            c2 = Integer.parseInt(tmp[3]) - 1;
            spin();
            average();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void spin(){
        int val = map[r1][c1];

        for(int i=c1; i<c2; i++){
            map[r1][i] = map[r1][i+1];
        }

        for(int i=r1; i<r2; i++){
            map[i][c2] = map[i+1][c2];
        }

        for(int i=c2; i>=c1+1; i--){
            map[r2][i] = map[r2][i-1];
        }

        for(int i=r2; i>=r1+1; i--){
            map[i][c1] = map[i-1][c1];
        }
        map[r1+1][c1] = val;

    }

    private static void average() {
        int[][] plus = new int[N][M];

        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++){
                int cnt = 1;
                int sum = map[i][j];

                for(int k=0; k<4; k++){
                    int moveX = dx[k] + i;
                    int moveY = dy[k] + j;

                    if(moveX >= 0 && moveX <N && moveY >=0 && moveY < M){
                        cnt++;
                        sum += map[moveX][moveY];
                    }
                }

                plus[i][j] += sum/cnt;
                if(sum % cnt != 0){
                    plus[i][j]++;
                }
            }
        }


        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                map[i][j] = plus[i][j];
            }
        }
    }
}