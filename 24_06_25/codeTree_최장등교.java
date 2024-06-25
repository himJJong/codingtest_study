import java.util.*;
import java.io.*;

public class codeTree_최장등교 {
    static class Node implements Comparable<Node>{
        int index;
        int dis;

        Node(int index, int dis){
            this.index = index;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o){
            return this.dis - o.dis;
        }
    }
    static int N;
    static int M;
    static List<Node>[] list;
    static boolean[] visited;
    static int[] distance;
    static int[] result;
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        distance = new int[N+1];
        result = new int[N+1];
        visited = new boolean[N+1];

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] data = br.readLine().split(" ");

            int from = Integer.parseInt(data[0]);
            int to = Integer.parseInt(data[1]);
            int val = Integer.parseInt(data[2]);

            list[to].add(new Node(from, val));
        }

        System.out.println(dijkstra(N));
    }
    private static int dijkstra(int index){
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[index] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(index, 0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(!visited[tmp.index]){
                visited[tmp.index] = true;

                for(Node node : list[tmp.index]){
                    if(!visited[node.index] && distance[node.index] > distance[tmp.index] + node.dis){
                        distance[node.index] = distance[tmp.index] + node.dis;
                        pq.add(new Node(node.index, distance[node.index]));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            if(distance[i] == Integer.MAX_VALUE){
                continue;
            }
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}