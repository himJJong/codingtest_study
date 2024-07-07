import java.util.*;

public class pro_kakao_합승택시 {

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41}, {5,1,24}, {4,6,50}, {2,4,66}, {
            2,3,22}, {1,6,25}};
        System.out.println(Solution.solution(n,s,a,b,fares));
    }

    static class Solution {
        static class Node implements Comparable<Node>{
            int idx;
            int val;

            Node(int idx, int val){
                this.idx = idx;
                this.val = val;
            }

            @Override
            public int compareTo(Node o){
                return this.val - o.val;
            }
        }
        static List<Node>[] graph;
        static boolean[] visited;
        static int[] dist;
        static PriorityQueue<Node> pq;
        static int N;
        public static int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = Integer.MAX_VALUE;
            graph = new ArrayList[n+1];
            N = n;
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<Node>();
            }

            for(int i=0; i<fares.length; i++){
                int st = fares[i][0];
                int end = fares[i][1];
                int dis = fares[i][2];

                graph[st].add(new Node(end, dis));
                graph[end].add(new Node(st, dis));
            }

            int[] startA = dijkstra(a,n);
            int[] startB = dijkstra(b,n);
            int[] start = dijkstra(s,n);
            // n = 6, s = 4, a = 6, b = 2, i = 1
            for(int i=1; i<=n; i++){ // S->i까지 경유하고 i->a & i->b 까지 따로간다.
                answer = Math.min(answer, start[i] + startA[i] + startB[i]);
            }


            return answer;
        }

        private static int[] dijkstra(int s, int e){
            dist = new int[N+1];
            visited = new boolean[N+1];
            Arrays.fill(dist, 20000000);
            pq = new PriorityQueue<>();
            dist[s] = 0;
            pq.add(new Node(s, 0));

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int curIndex = cur.idx;
                if(!visited[curIndex]){
                    visited[curIndex] = true;

                    for(Node next : graph[curIndex]){
                        if(dist[next.idx] > dist[cur.idx] + next.val){
                            dist[next.idx] = dist[cur.idx] + next.val;
                            pq.add(new Node(next.idx, dist[next.idx]));
                        }
                    }
                }
            }
            return dist;
        }
    }
}
