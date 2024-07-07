import java.util.*;
import java.io.*;

public class codeTree_물고기그물 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int method = Integer.parseInt(tmp[1]);

        int[] sumfix = new int[N];

        String[] score = br.readLine().split(" ");
        sumfix[0] = Integer.parseInt(score[0]);
        for(int i=1; i<N; i++){
            sumfix[i] += sumfix[i-1] + Integer.parseInt(score[i]);
        }

        for(int i=0; i<method; i++){
            String[] cur = br.readLine().split(" ");

            int from = Integer.parseInt(cur[0])-1;
            int to = Integer.parseInt(cur[1])-1;

            if(from == 0){
                System.out.println(sumfix[to]);
                continue;
            }

            System.out.println(sumfix[to] - sumfix[from-1]);
        }
    }
}