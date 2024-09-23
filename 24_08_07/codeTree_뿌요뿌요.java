import java.io.*;
import java.util.*;

public class codeTree_뿌요뿌요 {
    static int[][] data;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt = 0;
    static int N;
    static int result = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    result = 1;
                    int size = dfs(i,j);
                    if(size >= 4){
                        cnt++;
                    }
                    max = Math.max(max, size);
                }
            }
        }

        System.out.print(cnt +" " + max);
    }
    private static int dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N || (data[moveX][moveY] != data[x][y]) || visited[moveX][moveY]){
                continue;
            }
            result++;
            dfs(moveX, moveY);
        }
        return result;
    }
}