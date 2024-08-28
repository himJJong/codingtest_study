import java.util.Scanner;
import java.util.ArrayList;

public class codeTree_곰돌이모험 {

    public static final int MAXN = 25;

    // 방향을 나타내는 배열입니다.
    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, -1, 0, 1};

    public static int n, m;
    public static int[][] board = new int[MAXN][MAXN];

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 각 모험가의 초기 위치를 저장합니다.
    public static Pair[] a = new Pair[4];

    public static int ans;
    public static ArrayList<Integer> v = new ArrayList<>();

    public static boolean[][] vis = new boolean[MAXN][MAXN];

    // 주어진 좌표가 범위를 벗어나는지 확인하는 함수입니다.
    public static boolean isOutrange(int x, int y) {
        return !(1 <= x && x <= n && 1 <= y && y <= n);
    }

    // 모든 방향의 조합으로 최대 값을 찾는 함수입니다.
    public static void searchMax(int x) {
        // m + 1명의 사람이 모두 3번씩 이동을 완료하면, 답을 계산합니다.
        if (x == (3 * (m + 1) + 1)) {
            // 주어진 이동을 완수했을 때 열매 수확량의 총 합을 저장합니다.
            int val = 0;

            // 초기 위치의 값을 계산합니다.
            for (int i = 1; i <= m + 1; i++) {
                if (vis[a[i].x][a[i].y]) continue;

                vis[a[i].x][a[i].y] = true;

                val += board[a[i].x][a[i].y];
            }

            // 방향에 따라 값을 추가합니다.
            for (int i = 1; i <= m + 1; i++) {
                int cx = a[i].x;
                int cy = a[i].y;

                for (int j = 0; j < 3; j++) {
                    int id = (i - 1) * 3 + j;
                    cx += dx[v.get(id)];
                    cy += dy[v.get(id)];

                    // 해당 이동을 완수할 수 없으면 i번째 모험가는 이동을 종료합니다.
                    if (isOutrange(cx, cy)) break;
                    if (board[cx][cy] == -1) break;

                    if (!vis[cx][cy]) {
                        vis[cx][cy] = true;
                        val += board[cx][cy];
                    }
                }
            }

            ans = Math.max(ans, val);

            // 방문 기록을 초기화합니다.
            for (int i = 0; i < MAXN; i++) {
                for (int j = 0; j < MAXN; j++) {
                    vis[i][j] = false;
                }
            }
            return;
        }

        // 가능한 모든 방향에 대해 재귀 호출합니다.
        for (int dir = 0; dir < 4; dir++) {
            v.add(dir);
            searchMax(x + 1);
            v.remove(v.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 입력
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                board[i][j] = sc.nextInt();

        for (int i = 1; i <= m + 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i] = new Pair(x, y);
        }

        searchMax(1);

        System.out.println(ans);
    }
}