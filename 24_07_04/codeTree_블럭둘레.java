import java.util.*;
import java.io.*;

public class codeTree_블럭둘레 {
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int max = 102;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map = new int[max][max];
    static boolean[][] visited = new boolean[max][max];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            map[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 1;
            visited[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = true;
        }

        bfs(0,0);
        int answer = 0;
        for(int i=0; i<102; i++){
            for(int j=0; j<102; j++){
                if(map[i][j] == 0 && visited[i][j]){
                    for(int k=0; k<4; k++){
                        int moveX = dx[k] + i;
                        int moveY = dy[k] + j;
                        if(moveX < 0 || moveX >= max || moveY < 0 || moveY >=max){
                            continue;
                        }
                        if(map[moveX][moveY] == 1){
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
    private static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX >= 0 && moveX < max && moveY >= 0 && moveY<max && !visited[moveX][moveY] && map[moveX][moveY] == 0){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
    }
}