import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj_1516 {
    static int[] buildTime;
    static int[] indegree;
    static int[] resultTime;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        buildTime = new int[N + 1];
        indegree = new int[N + 1];
        resultTime = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            buildTime[i] = Integer.parseInt(input[0]);

            for (int j = 1; j < input.length - 1; j++) {
                int val = Integer.parseInt(input[j]);
                list[val].add(i);
                indegree[i]++;
            }
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                resultTime[i] = buildTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : list[current]) {
                indegree[next]--;
                resultTime[next] = Math.max(resultTime[next], resultTime[current] + buildTime[next]);

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(resultTime[i]).append("\n");
        }
        System.out.print(sb);
    }
}
