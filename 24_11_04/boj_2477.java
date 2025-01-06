import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2477 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        map = new int[1005][1005];
        visited = new boolean[1005][1005];

        Node cur = new Node(502,502);
        for(int i=0; i<6; i++){
            String[] tmp = br.readLine().split(" ");
            int dir = Integer.parseInt(tmp[0]);
            int size = Integer.parseInt(tmp[1]);

            if(dir == 1){
                for(int j=1; j<=size; j++){
                    visited[cur.x][cur.y+j] = true;
                    map[cur.x][cur.y+j] = 1;
                }
                cur.setY(cur.y + size);
            }
            else if(dir == 2){
                for(int j=1; j<=size; j++){
                    visited[cur.x][cur.y-j] = true;
                    map[cur.x][cur.y-j] = 1;
                }
                cur.setY(cur.y - size);
            }
            else if(dir == 3){
                for(int j=1; j<=size; j++){
                    visited[cur.x+j][cur.y] = true;
                    map[cur.x+j][cur.y] = 1;
                }
                cur.setX(cur.x+size);
            }
            else if(dir == 4){
                for(int j=1; j<=size; j++){
                    visited[cur.x-j][cur.y] = true;
                    map[cur.x-j][cur.y] = 1;
                }
                cur.setX(cur.x-size);
            }
            answer += size;
        }

        bfsOutSide();
        int area = cal();
        System.out.println(area);
        System.out.println(answer);
        System.out.println((answer+area)*K);
        //System.out.println(answer * K);
    }

    private static int cal() {
        int area = 0;
        for(int i=0; i<1005; i++){
            for(int j=0; j<1005; j++){
                if(!visited[i][j] && map[i][j] == 0)  area++;
            }
        }
        return area;
    }

    private static void bfsOutSide() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX >= 0 && moveX < 1005  && moveY >=0 && moveY < 1005 && !visited[moveX][moveY] && map[moveX][moveY] == 0) {
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
    }

    /*
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(502,502));
        int a = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX < 0 || moveX >= 1005 || moveY < 0 || moveY >= 1005 || visited[moveX][moveY] || map[moveX][moveY] == 1) continue;
                a++;
                visited[moveX][moveY] = true;
                q.add(new Node(moveX,moveY));
            }
        }
        System.out.println("내부넓이" + a);
    }

     */
}
