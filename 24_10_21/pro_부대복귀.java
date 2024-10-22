import java.util.*;

class pro_부대복귀 {
    static class Node implements Comparable<Node>{
        int idx;
        int dist;

        Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        dist = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];

            list[from].add(new Node(to, 1));
            list[to].add(new Node(from, 1));
        }

        dijkstra(destination);

        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
                continue;
            }
            answer[i] = dist[sources[i]];
        }
        return answer;
    }

    private static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(!visited[cur.idx]){
                visited[cur.idx] = true;
                for(Node tmp : list[cur.idx]){
                    if(dist[tmp.idx] > cur.dist + tmp.dist){
                        dist[tmp.idx] = cur.dist + tmp.dist;
                        pq.add(new Node(tmp.idx, dist[tmp.idx]));
                    }
                }
            }
        }
    }
}
