import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class boj_13424{
    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static List<Node>[] list;
    static boolean[] visited;
    static int[] result;
    static int[] dis;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] tmp = br.readLine().split(" ");
            int N = Integer.parseInt(tmp[0]);
            int M = Integer.parseInt(tmp[1]);

            visited = new boolean[N+1];
            list = new ArrayList[N+1];

            for(int j=1; j<=N; j++){
                list[j] = new ArrayList<>();
            }

            for(int j=0; j<M; j++){
                String[] data = br.readLine().split(" ");

                int from = Integer.parseInt(data[0]);
                int to = Integer.parseInt(data[1]);
                int cost = Integer.parseInt(data[2]);

                list[from].add(new Node(to,cost));
                list[to].add(new Node(from, cost));
            }

            int friendCnt = Integer.parseInt(br.readLine());
            String[] start = br.readLine().split(" ");
            int[] friends = new int[friendCnt];
            for (int j = 0; j < friendCnt; j++) {
                friends[j] = Integer.parseInt(start[j]);
            }

            result = new int[N + 1];
            for (int friend : friends) {
                dijkstra(friend, N);
                for (int k = 1; k <= N; k++) {
                    result[k] += dis[k];
                }
            }

            int minNode = 1;
            int minDistance = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                if (result[j] < minDistance) {
                    minDistance = result[j];
                    minNode = j;
                }
            }

            System.out.println(minNode);
        }
    }

    private static void dijkstra(int start, int N) {
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.idx]) continue;
            visited[cur.idx] = true;

            for (Node next : list[cur.idx]) {
                if (dis[next.idx] > dis[cur.idx] + next.cost) {
                    dis[next.idx] = dis[cur.idx] + next.cost;
                    pq.add(new Node(next.idx, dis[next.idx]));
                }
            }
        }
    }
}
