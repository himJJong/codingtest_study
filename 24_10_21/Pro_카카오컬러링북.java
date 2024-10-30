import java.util.*;

class Pro_카카오컬러링북 {
    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int M;
    static int check = 1;
    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        int[] answer = new int[2];
        int index = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    check = 1;
                    int size = bfs(i,j,picture, picture[i][j]);
                    map.put(index, size);
                    index++;
                }
            }
        }

        for(int i=1; i<=map.size(); i++){
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, map.get(i));
        }
        answer[0] = map.size();
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private static int bfs(int x,int y, int[][] picture, int color){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int val = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX >=0 && moveX < M && moveY >=0 && moveY < N && !visited[moveX][moveY] &&
                        picture[moveX][moveY] == color){
                    visited[moveX][moveY] = true;
                    check++;
                    q.add(new Node(moveX, moveY));
                }
            }
        }
        return check;
    }
}









