import java.util.*;
import java.io.*;

public class codeTree_연속정수합 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[] data = new int[N];

        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int left = 0;
        int right = 0;
        int sum = data[0];
        int answer = 0;
        while(left <= right || left < N){
            if(sum > M){    //구간 합이 M보다 클 경우
                sum -= data[left];
                left++;
            }
            else if(sum==M){ //구간 합이 M과 같을 경우
                sum -= data[left];
                left++;
                right++;
                if(right == N){
                    right = N-1;
                    left++;
                    answer++;
                    continue;
                }
                sum += data[right];
                answer++;
            }
            else{   //구간 합이 M보다 작을 경우
                right++;
                if(right == N){
                    right = N-1;
                    left++;
                    continue;
                }
                sum+=data[right];
            }
        }

        System.out.println(answer);
    }
}