import java.util.*;
import java.io.*;

public class codeTree_수들최솟값최댓값 {
    static int min = Integer.MAX_VALUE;
    static int[] answer;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int N;
    static int[][] data;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        data = new int[N][N];
        answer = new int[N];

        for(int i=0; i<N; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        backTracking(0);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            max= Math.max(max, list.get(i));
        }

        System.out.println(max);
    }

    private static void backTracking(int depth){
        if(depth == N){
            list.add(check());
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[i] = data[depth][i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }

    private static int check(){
        int result = Integer.MAX_VALUE;

        for(int i=0; i<answer.length; i++){
            result = Math.min(result, answer[i]);
        }

        return result;
    }
}