import java.util.Scanner;
import java.util.ArrayList;

public class codeTree_달리기훈련 {
    public static final int INF = 1012345678;
    public static final int MAX_N = 305;

    public static int n, m, k;

    // 각 정점에서 다른 정점으로 이동하기까지의 최단 거리를 저장합니다.
    public static int[][] dis = new int[MAX_N][MAX_N];

    // 문자에서 주어진 경로 배열입니다.
    public static ArrayList<Integer> route = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dis[i][j] = INF;
            }
        }

        route.add(1);

        // 경로를 입력받습니다.
        for (int i = 1; i <= k; i++) {
            int x = sc.nextInt();
            route.add(x);
        }

        // 간선 정보를 입력받습니다.
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // 두 도시 간의 거리를 최소 값으로 갱신합니다.
            dis[x][y] = Math.min(dis[x][y], z);
            dis[y][x] = Math.min(dis[y][x], z);
        }

        // 플로이드-와샬 알고리즘을 이용해 모든 도시 간의 최단 거리를 계산합니다.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        // 경로 상의 도시 간의 거리를 모두 더해줍니다.
        long longAns = 0;
        for (int i = 1; i <= k; i++) {
            longAns += dis[route.get(i - 1)][route.get(i)];
        }

        System.out.println(longAns);
    }
}