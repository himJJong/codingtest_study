import java.util.*;

class pro_석유시추 {
    static class Node{
        int x;
        int y;
        int cnt;
        int group;

        Node(int x, int y, int cnt, int group){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.group = group;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[][] groupLand;
    static boolean[][] visited;
    static int answer = 0;
    static int index = 1;


    public int solution(int[][] land) {
        map = new int[land.length][land[0].length];
        groupLand = new int[land.length][land[0].length];
        visited = new boolean[land.length][land[0].length];
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1 && groupLand[i][j] == 0){
                    int area = bfs(i,j,land);
                    mapping(i,j,land, area);
                    index++;
                }
            }
        }
        boolean[] check = new boolean[index+1];

        for(int i=0; i<land[0].length; i++){
            int result = 0;
            for(int j=0; j<land.length; j++){
                if(map[j][i] != 0 && !check[groupLand[j][i]]){
                    check[groupLand[j][i]] = true;
                    result += map[j][i];
                }
            }
            Arrays.fill(check, false);
            answer = Math.max(answer, result);
        }
        /*
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                System.out.print(groupLand[i][j] + " ");
            }
            System.out.println();
        }
        */
        return answer;
    }
    private static void mapping(int x, int y, int[][] land, int area){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1, index));
        visited[x][y] = false;
        groupLand[x][y] = index;
        map[x][y] = area;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX < 0 || moveX >= land.length || moveY < 0 || moveY >= land[0].length || land[moveX][moveY] == 0 || !visited[moveX][moveY]){
                    continue;
                }

                visited[moveX][moveY] = false;
                q.add(new Node(moveX,moveY, 1, index));
                groupLand[moveX][moveY] = index;
                map[moveX][moveY] = area;
            }
        }
    }

    private static int bfs(int x, int y, int[][] land){
        int max = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y,1, index));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + cur.x;
                int moveY = dy[i] + cur.y;

                if(moveX < 0 || moveX >= land.length || moveY < 0 || moveY >= land[0].length || land[moveX][moveY] == 0 || visited[moveX][moveY]){
                    continue;
                }

                visited[moveX][moveY] = true;
                q.add(new Node(moveX, moveY, max+1, index));
                max = Math.max(max+1, cur.cnt+1);
            }
        }
        return max;
    }
}