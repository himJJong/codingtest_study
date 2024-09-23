import java.util.*;

public class codeTree_숫자겹치지않기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] data = new int[N];

        for(int i=0; i<N; i++){
            data[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int num = Integer.MIN_VALUE;
        boolean[] visited = new boolean[100001];
        while(left <= right){
            if(right == N)  break;
            if(!visited[data[right]]){
                visited[data[right]] = true;
                right++;
            }

            else{
                if(max < right - left){
                    max = right - left;
                }
                visited[data[left]] = false;
                left++;
            }
        }
        if(right - left > max){
            System.out.println(right- left);
        }
        else{
            System.out.println(max);
        }


    }
}