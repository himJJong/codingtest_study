import java.util.*;
import java.io.*;

public class codeTree_점프하며이동 {
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static boolean flag = false;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {2,1,-2,-1,-2,-1,1,2};
    static int[] dy = {1,2,1,2,-1,-2,-2,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int[] point = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if(point[0] == point[2] && point[1] == point[3]){
            System.out.println(0);
            System.exit(0);
        }

        bfs(point);

        if(!flag){
            System.out.println(-1);
        }
    }
    private static void bfs(int[] point){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(point[0]-1, point[1]-1, 0));
        int goalX = point[2]-1;
        int goalY = point[3]-1;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<8; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];

                if(moveX < 0 || moveX >=N || moveY < 0 || moveY >=N || visited[moveX][moveY]){
                    continue;
                }
                if(moveX == goalX && moveY == goalY){
                    flag = true;
                    System.out.println(cur.cnt+1);
                    q.clear();
                    break;
                }

                visited[moveX][moveY] = true;
                q.add(new Node(moveX, moveY, cur.cnt+1));
            }
        }
    }
}