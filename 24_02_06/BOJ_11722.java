import java.io.*;
public class BOJ_11722{
    static int[] arr;
    static int[] lis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];

        String line[] = br.readLine().split(" ");
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(line[i]);
            lis[i] = Integer.MIN_VALUE; // 최소값으로 우선 설정
        }

        lis[0] = arr[0]; // 최초의 index 0의 값은 arr[0]이 된다.

        int idx = 0;
        for(int i=1; i < arr.length; i++){
            // 만약 원 배열이 탐색 중 더 작은 숫자라면 그대로 이어서 붙인다.
            if(lis[idx] > arr[i]){
                lis[++idx] = arr[i];
                // 그렇지 않고 크다면 이진 탐색(Binary Search)를 통해 교체를 수행한다.
            } else {
                int target_index = binarySearch(lis, arr[i]);
                lis[target_index] = arr[i];
            }
        }

        bw.write(String.valueOf(idx+1));
        br.close();
        bw.flush();
    }

    // 반복문을 이용한 이진 탐색 방식
    public static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length-1;

        // 현재 탐색한 위치가 찾고자 하는 값보다 크냐 작냐에 따라 중간 index 계산을 위한 start / end 값을 변경함
        // <= 와 같이 부등호로 쓰지 않으면 잘못된 위치가 됨. 이 경우는 현재 비교 위치가 start == end여도 성립된다.
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == x){
                return mid;
            } else if(arr[mid] < x){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // 일치값을 찾지 못했을 때, -1이 아니라 그 적절한 위치를 반환해야 함
        return start;
    }
}