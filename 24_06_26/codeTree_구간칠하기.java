import java.io.*;

public class codeTree_구간칠하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[202];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]) + 100;
            int to = Integer.parseInt(tmp[1]) + 100;

            for(int j=from; j<to; j++){
                data[j]++;
            }
        }

        for(int i=0; i<202; i++){
            max = Math.max(data[i], max);
        }

        System.out.println(max);
    }
}