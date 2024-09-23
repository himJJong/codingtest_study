import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class codeTree_코드트리사내메신저 {

    public static final int MAX_N = 45;
    public static final int INF = 1012345678;

    public static int n;

    // i번째 부사장이 자신의 모든 자식들에게 정보를 전달하기 위한 최소 시간을
    // dp로 정의합니다.
    public static int[] dp = new int[MAX_N];

    // 트리를 저장합니다.
    public static ArrayList<Integer>[] way = new ArrayList[MAX_N];
    public static boolean[] visited = new boolean[MAX_N];

    // dfs를 이용해 트리 안에서 정보를 탐색합니다.
    public static void dfs(int currentNode) {
        visited[currentNode] = true;

        ArrayList<Integer> values = new ArrayList<>();

        // 현재 노드와 연결된 모든 노드들에 대해 탐색을 수행합니다.
        for(int adjacentNode : way[currentNode]) {
            if (!visited[adjacentNode]) {
                dfs(adjacentNode);
                values.add(-dp[adjacentNode]);
            }
        }

        // 자식들을 dp값이 큰 순으로 정렬합니다.
        Collections.sort(values);

        // dp값이 가장 큰 자식부터 한명씩 공지를 공유하는 것이 최선입니다.
        // 따라서, i번째로 큰 자식은 dp[i]에 더해 i만큼 더 더한 시간이 지나야 공유를 받을 수 있습니다.
        // 이런 자식들 중 최대가 곧 dp[currentNode]가 됩니다.
        for(int i = 0; i < values.size(); i++) {
            dp[currentNode] = Math.max(dp[currentNode], -values.get(i) + i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();

        for(int i = 0; i < MAX_N; i++) {
            way[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if(i >= 2) {
                way[x].add(i);
            }
        }

        // dfs를 이용해 트리 안에서 정보를 탐색합니다.
        dfs(1);

        System.out.println(dp[1]);
    }
}