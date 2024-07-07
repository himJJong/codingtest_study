import java.util.Scanner;

public class codeTree_편안한핀셋 {
    public static final int MAX_N = 1001;

    public static int N;
    public static boolean[][] A = new boolean[MAX_N][MAX_N];

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // 주어진 (x, y) 위치가 배열의 유효한 인덱스인지 확인하는 함수입니다.
    public static boolean valid_position(int x, int y) {
        return x >= 0 && x < MAX_N && y >= 0 && y < MAX_N;
    }

    // (x, y) 위치가 편안한지 확인하는 함수입니다.
    public static boolean comfortable(int x, int y) {
        if(A[x][y] == false) return false; // 현재 위치가 비어 있으면 편안하지 않습니다.

        int neighbors = 0; // 이웃의 개수를 저장합니다.

        // 모든 방향에 대해 이웃을 탐색해 이웃의 수를 계산합니다.
        for(int d = 0; d < 4; d++) {
            if(valid_position(x + dx[d], y + dy[d])) {
                if(A[x + dx[d]][y + dy[d]]) {
                    neighbors++;
                }
            }
        }

        return neighbors == 3; // 이웃이 정확히 3개면 편안한 위치입니다.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int nComfortable = 0; // 편안한 좌표의 개수를 저장합니다.

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 모든 방향에 대해 이동 가능한 경우, 편안한 좌표의 개수를 감소시킵니다.
            for(int d = 0; d < 4; d++) {
                if(valid_position(x + dx[d], y + dy[d])) {
                    nComfortable -= comfortable(x + dx[d], y + dy[d]) ? 1 : 0;
                }
            }

            // 현재 좌표를 마킹합니다.
            A[x][y] = true;

            // 모든 방향에 대해 이동 가능한 경우, 편안한 좌표의 개수를 증가시킵니다.
            for(int d = 0; d < 4; d++) {
                if(valid_position(x + dx[d], y + dy[d])) {
                    nComfortable += comfortable(x + dx[d], y + dy[d]) ? 1 : 0;
                }
            }

            // 현재 좌표가 편안하면 편안한 좌표의 개수를 증가시킵니다.
            nComfortable += comfortable(x, y) ? 1 : 0;

            // 현재까지의 편안한 좌표의 개수를 출력합니다.
            System.out.println(nComfortable);
        }

        sc.close();
    }
}