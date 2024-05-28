import java.util.*;
public class pro_kakao_경주로건설 {
    static class Solution {
        static class Node{
            int r;
            int c;
            int dir;
            int cost;

            Node(int r, int c, int dir, int cost){
                this.r = r;
                this.c = c;
                this.dir = dir;
                this.cost = cost;
            }
        }
        static boolean[][][] visited;
        static int answer = Integer.MAX_VALUE;
        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,1,0,-1};
        public int solution(int[][] board) {
            visited = new boolean[board.length][board[0].length][4];
            bfs(board);

            return answer;
        }

        static void bfs(int[][] board){
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0,0,-1,0));

            while(!q.isEmpty()){
                Node now = q.poll();

                if(now.r == board.length-1 && now.c == board[0].length-1){
                    answer = Math.min(answer, now.cost);
                }

                for(int i=0; i<4; i++){
                    int moveX = now.r + dx[i];
                    int moveY = now.c + dy[i];

                    if(moveX < 0 || moveX >= board.length || moveY < 0 || moveY >= board[0].length || board[moveX][moveY] == 1){
                        continue;
                    }

                    int compare = now.cost;
                    if(i == now.dir || now.dir == -1){
                        compare += 100;
                    }

                    else{
                        compare += 600;
                    }

                    if(!visited[moveX][moveY][i] || board[moveX][moveY] >= compare){
                        visited[moveX][moveY][i] = true;
                        board[moveX][moveY] = compare;
                        q.add(new Node(moveX, moveY, i, compare));
                    }
                }
            }
        }
    }
}
