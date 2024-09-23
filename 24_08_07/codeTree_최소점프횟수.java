import java.util.*;
import java.io.*;

public class codeTree_최소점프횟수 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[] data = new int[15];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");
        for(int j=0; j<tmp.length;j++){
            data[j+1] = Integer.parseInt(tmp[j]);
        }

        backTracking(1, 0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }

    }

    private static void backTracking(int index, int cnt){
        if(index >= N){
            if(index == N){
                min = Math.min(min, cnt);
            }
            return;
        }

        for(int i=1; i<=data[index]; i++){
            backTracking(index + i,cnt+1);
        }
    }
}
