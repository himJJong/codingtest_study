import java.util.*;

public class pro_배달 {
    static class Node implements Comparable<Node>{
        int index;
        int w;

        Node(int index, int w) {
            this.index = index;
            this.w = w;
        }
        @Override
        public int compareTo ( Node o){
            return this.w - o.w;
        }
    }
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) {
        int answer = 0;
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        dist = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList();
        }

        for(int i=0; i<road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];

            list[start].add(new Node(end, time));
            list[end].add(new Node(start, time));
        }

        Dijkstra();
        for(int i=1; i<=N; i++){
            if(dist[i] <= K)    answer++;
        }
        System.out.println(answer);
    }

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(!visited[tmp.index]){
                visited[tmp.index] = true;
                for(Node k : list[tmp.index]){
                    if(!visited[k.index] && dist[k.index] > k.w + dist[tmp.index]){
                        dist[k.index] = k.w + dist[tmp.index];
                        pq.add(new Node(k.index, dist[k.index]));
                    }
                }
            }
        }
    }
}
