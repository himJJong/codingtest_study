import java.util.*;

class pro_미로탈출 {
    static class Node{
        int x;
        int y;
        int cnt;

        Node(int x, int y ,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N;
    static int M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static String[][] map;
    static boolean sFlag = false;
    static boolean eFlag = false;
    static Node start;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        int x;
        int y;

        visited = new boolean[N][M];
        map = new String[N][M];

        for(int i=0; i<maps.length; i++){
            String[] tmp = maps[i].split("");
            for(int j=0; j<tmp.length; j++){
                if(tmp[j].equals("L")){
                    start = new Node(i,j,0);
                }
                map[i][j] = tmp[j];
            }
        }
        int toS = bfs1();

        visited = new boolean[N][M];
        int toE = bfs2();

        answer = toS + toE;
        if(answer == 0) return -1;
        if(sFlag && eFlag){
            return answer;
        }
        return -1;
    }

    private static int bfs1(){
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];

                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M || visited[moveX][moveY] || map[moveX][moveY].equals("X")){
                    continue;
                }

                if(map[moveX][moveY].equals("S")){
                    q.clear();
                    answer = cur.cnt+1;
                    sFlag = true;
                    break;
                }

                visited[moveX][moveY] = true;
                q.add(new Node(moveX,moveY,cur.cnt+1));
            }
        }
        return answer;
    }

    private static int bfs2(){
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];

                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M || visited[moveX][moveY] || map[moveX][moveY].equals("X")){
                    continue;
                }

                if(map[moveX][moveY].equals("E")){
                    q.clear();
                    answer = cur.cnt+1;
                    eFlag = true;
                    break;
                }

                visited[moveX][moveY] = true;
                q.add(new Node(moveX,moveY,cur.cnt+1));

            }
        }
        return answer;
    }
}


/*
import java.util.*;

class Solution {
    static class Node{
        int x;
        int y;
        int cnt;
        
        Node(int x, int y ,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N;
    static int M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static boolean flag = false;
    static String[][] map;
    static Node start;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        int x;
        int y;
        
        visited = new boolean[N][M];
        map = new String[N][M];
        
        for(int i=0; i<maps.length; i++){
            String[] tmp = maps[i].split("");
            for(int j=0; j<tmp.length; j++){
                if(tmp[j].equals("S")){
                    start = new Node(i,j,0);
                }
                map[i][j] = tmp[j];
            }
        }
        answer = bfs();
        
        if(answer == 0) return -1;
        return answer;
    }
    
    private static int bfs(){
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int i=0; i<4; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];
                
                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M || visited[moveX][moveY] || map[moveX][moveY].equals("X")){
                    continue;
                }
                
                if(map[moveX][moveY].equals("L") && !flag){
                    flag = true;
                    visited = new boolean[N][M];
                    visited[moveX][moveY] = true;
                    q.clear();
                    q.add(new Node(moveX, moveY, cur.cnt+1));
                }
                
                if(map[moveX][moveY].equals("E")){
                    if(flag){
                        q.clear();
                        answer = cur.cnt+1;
                        break;
                    }
                    else{
                        visited[moveX][moveY] = true;
                        q.add(new Node(moveX, moveY, cur.cnt+1));
                    }
                }
                
                if(map[moveX][moveY].equals("O")){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX, moveY, cur.cnt+1));
                }
                
            }
        }
        return answer;
    }
}
*/