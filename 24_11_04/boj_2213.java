import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2213 {
    static List<Integer>[] tree;
    static int[] weights;
    static int[][] dp;
    static boolean[] visited;
    static PriorityQueue<Integer> selectedNodes = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        weights = new int[N + 1];
        String[] weightStr = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(weightStr[i - 1]);
        }

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] edge = line.split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[N + 1][2]; // 각각의 노드가 독립 집합에 포함되지 않는 경우와 포함되는 경우
        visited = new boolean[N + 1];

        dfs(1);
        StringBuilder sb = new StringBuilder();
        int maxWeight = Math.max(dp[1][0], dp[1][1]);
        sb.append(maxWeight).append("\n");

        visited = new boolean[N + 1];
        if (dp[1][1] >= dp[1][0]) {
            trace(1, 1);
        } else {
            trace(1, 0);
        }

        while(!selectedNodes.isEmpty()){
            sb.append(selectedNodes.poll()).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = weights[node];

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }

    private static void trace(int node, int isSelected) {
        visited[node] = true;
        if (isSelected == 1) {
            selectedNodes.add(node);
            for (int child : tree[node]) {
                if (!visited[child]) {
                    trace(child, 0);
                }
            }
        } else {
            for (int child : tree[node]) {
                if (!visited[child]) {
                    if (dp[child][1] >= dp[child][0]) {
                        trace(child, 1);
                    } else {
                        trace(child, 0);
                    }
                }
            }
        }
    }
}
