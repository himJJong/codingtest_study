import java.util.*;
import java.io.*;
public class codetree_sprint2_4 {

        static class Node{
            int x;
            int y;

            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        static int N;
        static int[][] map;
        static boolean[][] visited;
        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,1,0,-1};
        static PriorityQueue<Integer> pq = new PriorityQueue<>();
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            map = new int[N][N];
            for(int i=0; i<N; i++){
                String[] tmp = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(tmp[j]);
                }
            }


            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        pq.add(bfs(new Node(i,j)));
                    }
                }
            }

            System.out.println(pq.size());
            while(!pq.isEmpty()){
                System.out.println(pq.poll());
            }
        }
        private static int bfs(Node data){
            Queue<Node> q = new LinkedList<>();
            q.add(data);
            visited[data.x][data.y] = true;
            int cnt = 1;

            while(!q.isEmpty()){
                Node tmp = q.poll();

                for(int i=0; i<4; i++){
                    int moveX = tmp.x + dx[i];
                    int moveY = tmp.y + dy[i];

                    if(moveX < 0 || moveX >= N || moveY < 0 || moveY >=N || visited[moveX][moveY] || map[moveX][moveY] == 0){
                        continue;
                    }

                    visited[moveX][moveY] = true;
                    cnt++;
                    q.add(new Node(moveX, moveY));
                }
            }

            return cnt;
        }
    }

