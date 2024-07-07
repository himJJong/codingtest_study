import java.util.*;
import java.io.*;

public class codeTree_바깥 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        map = new int[N][M];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int cnt = 0;
        while(true){
            visited = new boolean[N][M];
            int secter = 0;
            if(blankMap()){
                System.out.println(0);
                break;
            }

            for(int i=1; i<N-1; i++){
                for(int j=1; j<M-1; j++){
                    if(map[i][j] != 0 && !visited[i][j]){
                        checkMap(i,j);
                        secter++;
                    }
                }
            }

            if(secter >= 2){
                System.out.println(cnt);
                break;
            }
            else{
                cnt++;
                breakMap();
            }
            /*
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }*/
        }

    }
    private static boolean blankMap(){
        boolean flag = false;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    return flag;
                }
            }
        }
        return !flag;
    }

    private static void checkMap(int x, int y){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x,y));

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<4; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];

                if(!visited[moveX][moveY] && map[moveX][moveY] > 0){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX, moveY));
                }
            }
        }
    }

    private static void breakMap(){
        int[][] memory = new int[N][M];

        for(int i=1; i<N-1; i++){
            for(int j=1; j<M-1; j++){
                if(map[i][j] != 0){

                    for(int k=0; k<4; k++){
                        int moveX = dx[k] + i;
                        int moveY = dy[k] + j;

                        if(map[moveX][moveY] == 0)  memory[i][j]++;
                    }
                }
            }
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<M-1; j++){
                if(map[i][j] <= memory[i][j]){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] -= memory[i][j];
                }
            }
        }
    }
}