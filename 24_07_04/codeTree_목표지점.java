import java.util.*;
import java.io.*;

public class codeTree_목표지점 {
    static class Node{
        int x;
        int y;
        int score;

        Node(int x, int y, int score){
            this.x = x;
            this.y = y;
            this.score = score;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        map = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        int startX = 0;
        int startY = 0;
        for(int i=0; i<N; i++){
            String[] tmp1 = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                if(Integer.parseInt(tmp1[j]) == 2){
                    startX = i;
                    startY = j;

                    map[i][j] = 2;
                }
                else{
                    map[i][j] = Integer.parseInt(tmp1[j]);
                }
            }
        }

        bfs(startX,startY);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    System.out.print(-1 +" ");
                }
                else{
                    System.out.print(result[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        visited[x][y] = true;
        result[x][y] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX < 0 || moveX >=N || moveY < 0 || moveY >=M || visited[moveX][moveY]
                        || map[moveX][moveY] == 0){
                    continue;
                }

                visited[moveX][moveY] = true;
                result[moveX][moveY] = cur.score+1;
                q.add(new Node(moveX, moveY, cur.score+1));
            }
        }
    }
}