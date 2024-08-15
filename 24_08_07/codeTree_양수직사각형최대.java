import java.util.*;
import java.io.*;

public class codeTree_양수직사각형최대 {
    static int[][] arr;
    static int maxSize = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // 시작점 정하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 끝점 정하기
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        // getSize에 시작점, 끝점을 인자로 주며 호출해
                        // 각 위치에서 만들어질 수 있는 직사각형의 size 구한 후,
                        // maxSize보다 크다면 최대 크기 갱신
                        maxSize = Math.max(maxSize, getSize(i, j, k, l));
                    }
                }
            }
        }

        System.out.println(maxSize);
    }

    private static int getSize(int i, int j, int k, int l) {
        int size = 0; // 현재 만들어지는 직사각형의 크기

        // 시작점과 끝점이 정해졌으니 
        for (int r = i; r <= k; r++) { // r은 시작점 i부터 끝점 k까지
            for (int c = j; c <= l; c++) { // c도 시작점 j부터 끝점 c까지
                // 그중 하나라도 0이나 음수가 있다면
                if (arr[r][c] <= 0) return -1; // -1 return
                size ++; // 아니라면 일단 size 하나씩 증가
            }
        }
        // 여기까지 왔다면 음수가 없었다는 것
        return size; // size 값 return
    }
}