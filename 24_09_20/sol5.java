import java.io.*;
import java.util.*;
/*
O(N + Q log K)
N : 문자열
Q : 쿼리 개수
K : 매듭의 개수

O(N + Q * K)

 */
public class sol5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int Q = Integer.parseInt(br.readLine());

        List<Integer> starList = new ArrayList<>(); // 매듭의 위치 저장을 위한 List
        int[] prefixSum = new int[N + 1];           // 구슬의 합을 위한 누적합 배열

        for (int i = 0; i < N; i++) {               // 구슬의 누적합 계산, * 위치 체크
            if (str.charAt(i) >= '1' && str.charAt(i) <= '3') {
                prefixSum[i + 1] = prefixSum[i] + (str.charAt(i) - '0');
            }
            else {
                prefixSum[i + 1] = prefixSum[i];
            }

            if (str.charAt(i) == '*') {
                starList.add(i);
            }
        }

        for (int i = 0; i < Q; i++) {               // 각 쿼리에 대해 처리
            String[] SE = br.readLine().split(" ");
            int S = Integer.parseInt(SE[0]);
            int E = Integer.parseInt(SE[1]);

            int leftIndex = -1;
            int rightIndex = -1;

            for (int star : starList) {
                if (star >= S) {
                    leftIndex = star;
                    break;
                }
            }

            for (int j = starList.size() - 1; j >= 0; j--) {
                if (starList.get(j) <= E) {
                    rightIndex = starList.get(j);
                    break;
                }
            }

            // 매듭이 없다면 계산할 수 있는 구슬이 없음
            if (leftIndex == -1 || rightIndex == -1 || leftIndex >= rightIndex) {
                System.out.println(0);
                continue;
            }

            // 매듭 안의 계산한 누적합으로 정답 도출
            System.out.println(prefixSum[rightIndex] - prefixSum[leftIndex + 1]);
        }
    }
}
