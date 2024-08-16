import java.util.*;
import java.io.*;


public class codeTree_친구키3 {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] degree;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        list = new ArrayList[N+1];
        degree = new int[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] data = br.readLine().split(" ");
            int big = Integer.parseInt(data[0]);
            int small = Integer.parseInt(data[1]);

            list[big].add(small);
            degree[small]++;
        }

        topological();

        if(q.size() != N){
            System.out.println(-1);
        }
        else{
            while(!q.isEmpty()){
                System.out.print(q.poll() + " ");
            }
        }
    }

    private static void topological(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int index = pq.poll();
            q.add(index);

            for(Integer num : list[index]){
                degree[num]--;
                if(degree[num] == 0){
                    pq.add(num);
                }
            }
        }
    }
}