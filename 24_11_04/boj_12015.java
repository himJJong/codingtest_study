import java.io.*;
import java.util.StringTokenizer;

public class boj_12015 {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1];
        int idx = 0;
        int len = 0;

        for(int i=0; i<n; i++){
            if(arr[i] > dp[len]){
                len++;
                dp[len] = arr[i];
            }
            else {
                idx = binarySearch(0, len, arr[i]);
                dp[idx] = arr[i];
            }
        }

        System.out.println(len);
    }

    private static int binarySearch(int left, int right, int key){
        while(left < right){
            int mid = (left + right) / 2;

            if(dp[mid] < key){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }
}