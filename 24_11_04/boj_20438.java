import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj_20438 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        int Q = Integer.parseInt(tmp[2]);
        int M = Integer.parseInt(tmp[3]);

        tmp = br.readLine().split(" ");
        boolean[] visited = new boolean[N+3];
        boolean[] student = new boolean[N+3];
        for(int i=0; i<K; i++){
            student[Integer.parseInt(tmp[i])] = true;
        }

        tmp = br.readLine().split(" ");
        for(int i=0; i<Q; i++){
            int num = Integer.parseInt(tmp[i]);
            if(student[num])    continue;
            for(int j = num; j < N+3 ; j+=num){
                if(!student[j]){
                    visited[j] = true;
                }
            }
        }

        int[] prefix = new int[N+3];
        for(int i=3; i<N+3; i++){
            if(visited[i]){
                prefix[i] = prefix[i-1];
            }
            else {
                prefix[i] = prefix[i - 1] + 1;
            }
        }

        for(int i=0; i<M; i++){
            tmp = br.readLine().split(" ");
            System.out.println(prefix[Integer.parseInt(tmp[1])] - prefix[Integer.parseInt(tmp[0])-1]);
        }
    }
}
// 3 ~ N+2번까지 입장번호
// 10 1 3 1
// 7
// 3 5 7
// 3 12

// 3 4 5 6 7 8 9 10 11 12
// 3 6 9 12
// 5 10
// 7

// 3 5 6 7 9 10 12
// 4 8 11
