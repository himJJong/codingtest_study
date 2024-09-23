import java.util.Scanner;

public class codeTree_숫자찍기4 {
    public static final int MAX_N = 101;

    public static int n;

    // 방향 이동을 위한 dx, dy 배열입니다.
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int[][] a = new int[MAX_N][MAX_N];
    public static int[][] ck = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 크기 n을 입력받습니다.
        n = sc.nextInt();

        int c = 0, d = 0;
        int x = 0, y = 0;
        int exit = 0;

        // 4방향을 모두 탐색할 때까지 반복합니다.
        while (exit < 4) {
            // 현재 위치가 방문되지 않았다면,
            if (ck[y][x] == 0) {
                // 현재 위치를 방문했다고 표시하고
                ck[y][x] = 1;

                // 현재 위치의 값을 증가시킵니다.
                a[y][x] = ++c;
            }

            // 다음 위치를 계산합니다.
            int nx = (x + dx[d]);
            int ny = (y + dy[d]);

            // 다음 위치가 유효하지 않거나 이미 방문한 경우 방향을 바꿉니다.
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || ck[ny][nx] == 1) {
                d = (d + 1) % 4;
                exit++;
            } else {
                // 그렇지 않다면 다음 위치로 이동합니다.
                x = nx;
                y = ny;
                exit = 0;
            }
        }

        // 배열 a를 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}