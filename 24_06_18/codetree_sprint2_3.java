import java.util.*;
import java.io.*;
public class codetree_sprint2_3 {



        static class Node implements Comparable<Node>{
            int from;
            int to;
            int weight;

            Node(int from, int to, int weight){
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Node o){
                return this.weight - o.weight;
            }

        }
        static int N;
        static int M;
        static PriorityQueue<Node> pq = new PriorityQueue<>();
        static int[] parent;
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] tmp = br.readLine().split(" ");
            N = Integer.parseInt(tmp[0]);
            M = Integer.parseInt(tmp[1]);

            parent = new int[N+1];

            for(int i=0; i<M; i++){
                String[] k = br.readLine().split(" ");

                int from = Integer.parseInt(k[0]);
                int to = Integer.parseInt(k[1]);
                int weight = Integer.parseInt(k[2]);

                pq.add(new Node(from, to, weight));
            }

            for(int i=1; i<=N; i++){
                parent[i] = i;
            }

            int totalCost = 0; // MST 비용
            int EdgeCnt = 0; // 연결된 간선수

            while(!pq.isEmpty()){
                Node cur = pq.poll();

                if(find(cur.from) != find(cur.to)){
                    union(cur.from, cur.to);
                    totalCost += cur.weight;
                }
            }

            System.out.println(totalCost);
        }

        private static void union(int from, int to){
            int p1 = parent[find(from)];
            int p2 = parent[find(to)];

            if(p1 <= p2){
                parent[p2] = p1;
            }
            else{
                parent[p1] = p2;
            }
        }

        private static int find(int val){
            if(val == parent[val]){
                return val;
            }
            return parent[val] = find(parent[val]);
        }
    }

