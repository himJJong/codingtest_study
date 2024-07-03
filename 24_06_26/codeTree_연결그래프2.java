import java.util.*;
import java.io.*;

public class codeTree_연결그래프2 {
    static class Node{
        int index;

        Node(int index){
            this.index = index;
        }
    }
    static int N;
    static int M;
    static int max;
    static boolean[] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static List<Node> [] list;
    public static void main(String[] args)throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] tmp1 = br.readLine().split(" ");
            int from = Integer.parseInt(tmp1[0]);
            int to = Integer.parseInt(tmp1[1]);

            list[from].add(new Node(to));
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=N ; i++){
            max = 0;
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i);

            if(max == Integer.MIN_VALUE){
                max = 0;
            }
            //System.out.println(max);
            map.put(i, max);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int check = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            if(map.get(i) ==check){
                pq.add(i);
            }
            else if(map.get(i) > check){
                check = map.get(i);
                pq.clear();
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }

    private static void dfs(int index){
        for(Node tmp : list[index]){
            if(!visited[tmp.index]){
                max++;
                visited[tmp.index] = true;
                dfs(tmp.index);
            }
        }
    }
}