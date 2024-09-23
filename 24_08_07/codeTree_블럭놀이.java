import java.util.*;
import java.io.*;

public class codeTree_블럭놀이 {
    static int N;
    static int M;
    static int Q;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        Q = Integer.parseInt(tmp[2]);

        map = new int[N][M];
        while(Q-- > 0){
            visited = new boolean[N][M];
            String[] order = br.readLine().split(" ");
            int move = Integer.parseInt(order[0]);

            if(move == 1){
                int x = Integer.parseInt(order[1])-1;
                int y = Integer.parseInt(order[2])-1;
                int val = Integer.parseInt(order[3]);

                map[x][y] = Math.max(map[x][y], val);
            }
            else if(move == 2){
                int num = 0;
                int cnt = 0;
                while(num == 0 || cnt > 0){
                    cnt = 0;
                    num++;
                    up();

                    for(int i=0; i<N; i++){
                        for(int j=0; j<M; j++){
                            for(int k=0; k<4; k++){
                                int moveX = i + dx[k];
                                int moveY = j + dy[k];

                                if(moveX >=0 && moveX < N && moveY >=0 && moveY < M && map[moveX][moveY] != 0 && map[moveX][moveY] == map[i][j] && !visited[moveX][moveY]){
                                    cnt++;
                                    visited[moveX][moveY] = true;
                                    visited[i][j] = true;
                                }
                            }
                        }
                    }
                    remove();
                    up();
                }
            }
            else if(move==3){
                int num = 0;
                int cnt = 0;
                while(num == 0 || cnt > 0){
                    down();
                    cnt = 0;
                    num++;

                    for(int i=0; i<N; i++){
                        for(int j=0; j<M; j++){
                            for(int k=0; k<4; k++){
                                int moveX = i + dx[k];
                                int moveY = j + dy[k];

                                if(moveX >=0 && moveX < N && moveY >=0 && moveY < M && map[moveX][moveY] != 0 && map[moveX][moveY] == map[i][j] && !visited[moveX][moveY]){
                                    cnt++;
                                    visited[moveX][moveY] = true;
                                    visited[i][j] = true;
                                }
                            }
                        }
                    }
                    remove();
                    down();
                }
            }
            else if(move == 4){
                map[Integer.parseInt(order[1])-1][Integer.parseInt(order[2])-1] = 0;
            }



        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    private static void remove(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]){
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void up(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[j][i] != 0){
                    q.add(map[j][i]);
                }
            }
            int index = 0;
            while(!q.isEmpty()){
                map[index][i] = q.poll();
                index++;
            }
            while(index < N){
                map[index][i] = 0;
                index++;
            }
        }
    }

    private static void down(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<M; i++){
            for(int j=N-1; j>=0; j--){
                if(map[j][i] != 0){
                    q.add(map[j][i]);
                }
            }
            int index = N-1;

            while(!q.isEmpty()){
                map[index][i] = q.poll();
                index--;
            }
            while(index > -1){
                map[index][i] = 0;
                index--;
            }
        }
    }
}

// 1 삽입. 만약 숫자가 있다면, 더 큰번호가 대입
// 2. 보드판 위로 가울이기
// 3. 보드판 아래로 기울이기
// 기울일 때 주의 : 1) 인접한 칸에 상하좌우가 같은게 있다면, 모두 제거 대상. 한번에 지워야함.
// 4. 원하는 블럭 지웁니다.

