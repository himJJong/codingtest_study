import java.util.*;
import java.io.*;

public class codeTree_가장큰수 {
    static int N;
    static int k;
    static int[] data;
    static String[] answer;
    static int max = Integer.MIN_VALUE;
    static int size = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        size = tmp[0].length();
        N = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);
        data = new int[k];
        answer = new String[k];

        String[] tmp1 = br.readLine().split(" ");
        for(int i=0; i<k; i++){
            data[i] = Integer.parseInt(tmp1[i]);
        }

        backTracking(0, "");
        System.out.println(max);
    }

    private static void backTracking(int cnt, String word){
        if(size == cnt){
            int val = Integer.parseInt(word);
            if(val <= N){
                max = Math.max(max, Integer.parseInt(word));
            }
            return;
        }

        for(int i=0; i<k; i++){
            if(word.length() != 0 && Integer.parseInt(word) <= N){
                max = Math.max(max, Integer.parseInt(word));
            }
            backTracking(cnt+1, word + data[i]);
        }
    }
}