import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20955 {
    static int[] parent;
    static int N;
    static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int answer = 0;

        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        int cycle = 0;
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            String[] cur = br.readLine().split(" ");
            int a = Integer.parseInt(cur[0]);
            int b = Integer.parseInt(cur[1]);

            if(findParent(a) != findParent(b)){
                unionFind(a,b);
            }
            else{
                cycle++;
            }
        }

        for(int i=2; i<=N ; i++){
            if(findParent(1) != findParent(i)){
                unionFind(1,i);
                answer++;
            }
        }
        System.out.println(answer + cycle);
    }

    private static int findParent(int val) {
        if(val == parent[val])  return val;
        return parent[val] = findParent(parent[val]);
    }

    private static void unionFind(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(parentA > parentB){
            parent[parentA] = parentB;
        }
        else{
            parent[parentB] = parentA;
        }
    }
}


