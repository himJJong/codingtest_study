import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10451 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int graph = Integer.parseInt(br.readLine());
            int[] node = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean[] visited = new boolean[graph];
            int cnt = 0;
            for(int j=0; j<graph; j++){
                if(!visited[j]){
                    cnt++;
                    dfs(j, visited, node);
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int val, boolean[] visited, int[] node) {
        visited[val] = true;

        if(!visited[node[val]-1]){
            visited[node[val]-1] = true;
            dfs(node[val]-1, visited, node);
        }
    }
}
