import java.util.*;

class pro_리코쳇로봇 {
    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(Solution.solution(board));
    }

    static class Solution {
        static class Data {
            int x;
            int y;
            int cnt;
            int dir;

            Data(int x, int y, int cnt, int dir) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
                this.dir = dir;
            }
        }

        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, 1, 0, -1};
        static int answer = Integer.MAX_VALUE;
        static int N;
        static int M;
        static Data r;
        static Data g;
        static String[][] map;
        static boolean[][][] visited;

        public static int solution(String[] board) {
            N = board.length;
            M = board[0].length();
            map = new String[N][M];
            visited = new boolean[N][M][4];

            for (int i = 0; i < N; i++) {
                String[] tmp = board[i].split("");
                for (int j = 0; j < M; j++) {
                    if (tmp[j].equals("R")) {
                        r = new Data(i, j, 0, -10);
                    } else if (tmp[j].equals("G")) {
                        g = new Data(i, j, 0, -10);
                    }
                    map[i][j] = tmp[j];
                }
            }

            bfs();
            if (answer == Integer.MAX_VALUE) {
                return -1;
            }
            return answer;
        }

        private static void bfs() {
            Queue<Data> q = new LinkedList<>();
            q.add(new Data(r.x, r.y, 0, -10));

            while (!q.isEmpty()) {
                Data cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int moveX = dx[i] + cur.x;
                    int moveY = dy[i] + cur.y;

                    if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M ) { // 여기
                        continue;
                    }

                    if (visited[moveX][moveY][i]) {
                        continue;
                    }

                    if((cur.dir + 2) % 4 == i && cur.cnt != 0){ // 이부분에 왼쪽 조건만 위 표시한 부분에 포함했는데
                        continue;                               // 이렇게 했을 때 -10으로 방향을 초기화 했기에 항상 0이나옴
                    }                                           // 그래서 따로 조건을 걸고, 초기 시작하는 cur.cnt 조건 추가

                    while (true) {
                        if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) {
                            moveX -= dx[i];
                            moveY -= dy[i];
                            break;
                        }

                        if (map[moveX][moveY].equals("D")) {
                            moveX -= dx[i];
                            moveY -= dy[i];
                            break;
                        }

                        moveX += dx[i];
                        moveY += dy[i];
                    }

                    if (map[moveX][moveY].equals("G")) {
                        answer = cur.cnt+1;
                        return;
                    }

                    if (!visited[moveX][moveY][i]) {
                        visited[moveX][moveY][i] = true;
                        q.add(new Data(moveX, moveY, cur.cnt + 1, i));
                    }
                }
            }
        }
    }

}
