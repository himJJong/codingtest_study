import java.util.Scanner;
import java.util.ArrayList;

public class codeTree_트리구슬놓기 {
    public static final int MAX_N = 100000;

    // 변수 선언:
    public static int n;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] parent = new int[MAX_N + 1];

    // dp[i][j] : i번 노드의 서브트리에서
    //            j = 0이면 정확히 i번 노드에는 구슬을 놓지 않은 상황
    //            j = 1이면 정확히 i번 노드에는 구슬을 내려놓은 상황이라고 했을 때
    //            해당 상황에서 조건을 만족하며 최소한으로 놓았을 때 필요한 구슬의 수
    public static int[][] dp = new int[MAX_N + 1][2];

    // DFS를 통해 연결된 모든 정점을 순회합니다.
    // 동시에 dp값을 계산해줍니다.
    public static void dfs(int x) {
        // 노드 x에 연결된 간선을 살펴보며 전부 방문해줍니다.
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
            if(!visited[y]) {
                visited[y] = true;
                parent[y] = x;
                dfs(y);
            }
        }

        // 이제 퇴각하기 전에
        // 각각의 자식들을 다시 순회하며 
        // dp[x][0], dp[x][1] 값을 갱신해줍니다.
        dp[x][0] = 0; // x 노드에 아무 구슬도 놓지 않는 경우입니다. 
        dp[x][1] = 1; // x 노드에 구슬을 놓는 경우이므로, 시작 값은 x에 놓은 구슬의 수인 1이 됩니다.

        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);

            // y가 x의 자식이 아니라면 패스합니다.
            if(parent[y] != x)
                continue;

            // Case 1. 
            // x번 노드에 구슬을 놓지 않는 dp[x][0] 상황에서는
            // x의 자식들 y에 대해서는 j가 1인 경우만 선택이 가능하므로
            // dp[y][0]값들을 전부 더해주면 됩니다.
            dp[x][0] += dp[y][1];

            // Case 2. 
            // x번 노드에 구슬을 놓는 dp[x][1] 상황에서는
            // x의 자식들 y에 대해서는 j가 0, 1 경우 전부 선택이 가능하므로
            // 최솟값을 전부 더해주면 됩니다.
            dp[x][1] += Math.min(dp[y][0], dp[y][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        // n - 1개의 간선 정보를 입력받습니다.
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 간선 정보를 인접리스트에 넣어줍니다.
            edges[x].add(y);
            edges[y].add(x);
        }

        // 1번 정점을 루트로 하는 트리를 만들어 문제를 해결합니다.
        // 1번 정점을 시작으로 DFS를 진행하며 dp값을 갱신합니다.
        visited[1] = true;
        dfs(1);

        // dp[1][0], dp[1][1] 중 최솟값을 출력합니다.
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
}