import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_24479 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] order;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int S = Integer.parseInt(tmp[2]);

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int from = Integer.parseInt(data[0]);
            int to = Integer.parseInt(data[1]);

            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(S);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int val) {
        visited[val] = true;
        order[val] = ++cnt;

        for (int next : list[val]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
