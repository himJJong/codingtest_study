import java.util.Scanner;

public class codeTree_배수찾기 {
    public static int n;
    public static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();

        long lo = 1;
        long hi = (long)1e11;

        // 주어진 n 값에 대해서 이진 탐색을 사용하여 조건을 만족하는 최소의 수를 찾습니다.
        while(lo <= hi) {
            long mid = (lo + hi) / 2;

            // mid 값 이하의 수 중에서 3 또는 5의 배수가 아닌 수의 개수를 계산합니다.
            long val = (mid / 3) + (mid / 5) - (mid / 15);

            // 현재 mid 값이 조건을 만족하는지 확인합니다.
            if(val >= n) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        // 찾은 답을 출력합니다.
        System.out.println(ans);
    }
}