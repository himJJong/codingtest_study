import java.util.*;
import java.io.*;

public class codeTree_carry피하기 {
    static int max = Integer.MIN_VALUE;
    static int[] data;
    static int[] digit;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        data = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }

        int[] answer;
        for (int i = N; i >= 1; i--) {
            digit = new int[9]; // 9자리수까지 저장
            max = Integer.MIN_VALUE;
            answer = new int[i];
            btk(0, 0, 0);
            if (max != Integer.MIN_VALUE) break;
        }

        System.out.println(max);
    }

    private static void btk(int cnt, int depth, int sum) {
        max = Math.max(cnt, max);

        if (depth == N) {
            return;
        }

        for (int i = depth; i < data.length; i++) { // 모든 원소 순회
            if (isNotCarry(data[i], sum)) { // 캐리 발생 여부 확인
                btk(cnt + 1, i+1 , sum + data[i]);
            }
        }
    }

    private static boolean isNotCarry(int sum, int target) {
        // sum 또는 target의 자릿수를 모두 사용할 때까지 반복
        while (sum > 0 || target > 0) {
            // 현재 자릿수 추출
            int num1 = sum % 10;
            int num2 = target % 10;

            // 현재 자릿수들의 합이 carry가 발생하는지 확인
            if (num1 + num2 >= 10) {
                return false;
            }

            // 다음 자릿수 합 비교
            sum /= 10;
            target /= 10;
        }

        // 반복문이 정상으로 종료되면 carry가 발생하지 않음
        return true;
    }
}
