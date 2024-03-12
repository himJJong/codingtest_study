import java.util.*;

public class pro_부대복귀 {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1,3,5};
        int des = 5;
        System.out.println(Solution.solution(n,roads,sources,des));
    }

    static class Solution {
        static class Node implements Comparable<Node>{
            int from;
            int v;

            Node(int from, int v){
                this.from = from;
                this.v = v;
            }

            @Override
            public int compareTo(Node o){
                return this.v - o.v;
            }
        }
        static boolean[] visited;
        static int[] dist;
        static List<Node>[] list;
        public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer;

            list = new ArrayList[n+1]; // 0123
            for(int i=1; i<=n; i++){ // 0123.   1234
                list[i] = new ArrayList<>();
            }

            dist = new int[n+1];
            visited = new boolean[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            for(int i=0; i<roads.length ; i++){
                int from = roads[i][0];
                int to =roads[i][1];

                list[from].add(new Node(to, 1));
                list[to].add(new Node(from, 1));
            }
            answer = new int[sources.length];
            int index = 0;
            dijkstra(destination);
            for(int i=0; i<sources.length; i++){
                if(dist[sources[index]] == Integer.MAX_VALUE){
                    answer[index] = -1;
                }
                else{
                    answer[index] = dist[sources[index]];
                }

                System.out.println(answer[index]);
                index++;
            }

            return answer;
        }
        private static void dijkstra(int start){
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            dist[start] = 0;
            pq.add(new Node(start, 0));

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(!visited[cur.from]){
                    visited[cur.from] = true;

                    for(Node tmp : list[cur.from]){
                        if(!visited[tmp.from] && dist[tmp.from] > dist[cur.from] + tmp.v){
                            dist[tmp.from] = dist[cur.from] + tmp.v;
                            pq.add(new Node(tmp.from, dist[tmp.from]));
                        }
                    }
                }
            }

        }
    }
}
