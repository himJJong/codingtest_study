import java.util.*;

class pro_무인도여행 {
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int M;
    static boolean[][] visited;
    static String[][] board;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        board = new String[N][M];


        for(int i=0; i<N; i++){
            String[] tmp = maps[i].split("");
            for(int j=0; j<tmp.length; j++){
                board[i][j] = tmp[j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!board[i][j].equals("X") && !visited[i][j]){
                    int sum = bfs(i,j);
                    pq.add(sum);
                }
            }
        }

        if(pq.size() == 0){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            answer[index] = pq.poll();
            index++;
        }
        return answer;
    }
    private static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        int cnt = Integer.parseInt(board[x][y]);
        visited[x][y] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M || board[moveX][moveY].equals("X") || visited[moveX][moveY]){
                    continue;
                }

                visited[moveX][moveY] = true;
                cnt += Integer.parseInt(board[moveX][moveY]);
                q.add(new Node(moveX, moveY));
            }
        }
        return cnt;
    }

}