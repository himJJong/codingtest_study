import java.util.*;
import java.io.*;

public class codeTree_정수 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        backTracking(0, "");
        System.out.println(set.size());
    }

    private static void backTracking(int cnt, String cur){
        if(cnt == M){
            if(cur.length() > 10){
                return;
            }

            if(Long.parseLong(cur) <= Integer.MAX_VALUE && Long.parseLong(cur) >= Integer.MIN_VALUE
                    && !set.contains(Long.parseLong(cur))){
                set.add(Integer.parseInt(cur));
            }
            return;
        }


        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                backTracking(cnt+1, cur + arr[i]);
                visited[i] = false;
            }
        }

    }
}