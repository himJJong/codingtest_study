import java.util.*;
import java.io.*;

public class codeTree_막대 {
    static int N;
    static int M;
    static int[] indegree;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    //위상정렬, 들어온 순서대로
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        list = new ArrayList[N+1];
        indegree = new int[N+1];

        for(int i=0; i<N; i++){
            list[i+1] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] c = br.readLine().split(" ");

            int from = Integer.parseInt(c[0]);
            int to = Integer.parseInt(c[1]);

            list[from].add(to);
            indegree[to]++;
        }

        play();
        System.out.println(sb);
    }

    private static void play(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int first = q.poll();
            sb.append(first).append(" ");

            for(int index : list[first]){
                indegree[index]--;
                if(indegree[index] == 0)    q.add(index);
            }

        }
    }
    private static boolean check(){
        boolean flag = true;

        for(int i=1; i<=N; i++){
            if(indegree[i] != 0){
                return flag;
            }
        }

        return !flag;

    }
}