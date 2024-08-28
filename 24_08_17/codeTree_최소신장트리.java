import java.util.*;
import java.io.*;

public class codeTree_최소신장트리 {
    static class Data implements Comparable<Data>{
        int from;
        int to;
        int val;

        Data(int from, int to, int val){
            this.from = from;
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Data o){
            return this.val - o.val;
        }
    }
    static int[] parent;
    static int N;
    static int M;
    static int answer = 0;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            String[] node = br.readLine().split(" ");
            pq.add(new Data(Integer.parseInt(node[0]), Integer.parseInt(node[1]), Integer.parseInt(node[2])));
        }

        kruskal();

        System.out.println(answer);
    }
    private static void kruskal(){
        while(!pq.isEmpty()){
            Data cur = pq.poll();
            int x = cur.from;
            int y = cur.to;
            if(findParent(x) != findParent(y)){
                union(x,y);
                answer += cur.val;
            }
        }
    }

    private static int findParent(int value){
        if(value == parent[value]){
            return value;
        }
        return parent[value] = findParent(parent[value]);
    }

    private static void union(int x, int y){
        x = findParent(x);
        y = findParent(y);

        if(x < y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }
}


// 크루스칼, 유니온파인듲
// 2 (2) 3
//   (1)(3)
// 1 (3) 4