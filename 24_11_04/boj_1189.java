import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1189 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int R;
    static int C;
    static int K;
    static String[][] map;
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        R = Integer.parseInt(tmp[0]);
        C = Integer.parseInt(tmp[1]);
        K = Integer.parseInt(tmp[2]);

        map = new String[R][C];
        for(int i=0; i<R; i++){
            String[] cur = br.readLine().split("");
            for(int j=0; j<cur.length; j++){
                map[i][j] = cur[j];
            }
        }
        visited = new boolean[R][C];
        if(map[R-1][0].equals("T")){
            System.out.println(0);
            System.exit(0);
        }
        visited[R-1][0] = true;
        backTracking(R-1, 0, 1);
        System.out.println(answer);

    }

    private static void backTracking(int x, int y, int cnt) {
        if(cnt == K){
            if(x==0 && y==C-1) answer++;
            return;
        }

        for(int i=0; i<4; i++){
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveX >= R || moveY < 0 || moveY >=C || visited[moveX][moveY] || map[moveX][moveY].equals("T")) {
                continue;
            }
            visited[moveX][moveY] = true;
            backTracking(moveX, moveY, cnt+1);
            visited[moveX][moveY] = false;
        }
    }
}
