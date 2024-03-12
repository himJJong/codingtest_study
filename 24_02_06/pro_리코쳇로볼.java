import java.util.*;

public class pro_리코쳇로볼 {
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
    static int row = 0;
    static int col = 0;
    static String[][] maps;
    static boolean[][] visited;
    static Node robot;
    static Node goal;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;

    public static void main(String[] args) {
        String[] board = {".D.R", "....", ".G..", "...D"};
        solution(board);
    }
    public static int solution(String[] board) {
        row = board.length;
        col = board[0].length();

        maps = new String[row][col];
        visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            String[] tmp = board[i].split("");
            for(int j=0; j<col; j++){
                maps[i][j] = tmp[j];
                if(tmp[j].equals("R")){
                    robot = new Node(i,j,0);
                }
                if(tmp[j].equals("G")){
                    goal = new Node(i,j,0);
                }
            }
        }

        bfs();

        if(answer == 0){
            return -1;
        }
        return answer;
    }

    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(robot);
        visited[robot.x][robot.y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int moveX = cur.x;
                int moveY = cur.y;

                if(maps[moveX][moveY].equals("G")){
                    q.clear();
                    answer = cur.cnt;
                    break;
                }

                while(inArea(moveX+dx[i], moveY+dy[i])){

                    if(maps[moveX+dx[i]][moveY+dy[i]].equals(".") || maps[moveX+dx[i]][moveY+dy[i]].equals("G") || maps[moveX+dx[i]][moveY+dy[i]].equals("R")){
                        moveX += dx[i];
                        moveY += dy[i];
                    }

                    else if(maps[moveX+dx[i]][moveY+dy[i]].equals("D")){
                        break;
                    }
                }

                if(!visited[moveX][moveY]){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX, moveY, cur.cnt+1));
                }
            }
        }

    }
    private static boolean inArea(int moveX, int moveY){
        if(moveX >=0 && moveX < row && moveY >=0 && moveY < col){
            return true;
        }
        return false;
    }
}
// 11 12 14 16 18 24