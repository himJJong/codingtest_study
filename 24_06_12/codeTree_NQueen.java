import java.util.Scanner;

public class codeTree_NQueen {
    public static final int MAXN = 15;

    public static int n;
    public static int ans;

    // 각 행과 열에 퀸이 있는지 표시하는 배열입니다.
    public static int[] row = new int[MAXN + 1];

    // 좌측 대각선에 퀸이 있는지 표시하는 배열입니다.
    public static int[] leftDiagonal = new int[2 * MAXN + 1];

    // 우측 대각선에 퀸이 있는지 표시하는 배열입니다.
    public static int[] rightDiagonal = new int[2 * MAXN + 1];

    // 퀸을 배치하는 재귀 함수입니다.
    public static void placeQueen(int col) {
        // 모든 열에 퀸을 배치했을 경우 답을 추가해 주고 종료합니다.
        if(col == n + 1) {
            ans++;
            return;
        }

        // 현재 열에 퀸을 배치해보며 가능한 위치를 찾습니다.
        for(int rowPos = 1; rowPos <= n; rowPos++) {
            if(row[rowPos] != 0 || leftDiagonal[rowPos + col] != 0 || rightDiagonal[rowPos - col + n] != 0) continue;

            // 퀸을 배치합니다.
            row[rowPos]++;
            leftDiagonal[rowPos + col]++;
            rightDiagonal[rowPos - col + n]++;

            // 다음 열에 퀸을 배치합니다.
            placeQueen(col + 1);

            // 퀸의 배치를 제거합니다.
            row[rowPos]--;
            leftDiagonal[rowPos + col]--;
            rightDiagonal[rowPos - col + n]--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();

        placeQueen(1);

        System.out.println(ans);
    }
}

/*
public class codeTree_NQueen {
    static int N;
    static boolean[][] map;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new boolean[N][N];
        for(int i=0; i<N; i++){
            backTracking(0, i, 0);
        }
        System.out.println(answer);
    }

    private static void backTracking(int x,int y, int cnt){
        if(cnt == N-1){
            answer++;
            return;
        }

        for(int i=cnt; i<N; i++){
            for(int j=0; j<N; j++){
                if(!map[i][j]){
                    row(0,i,j);
                    col(0,i,j);
                    slide(0,i,j);
                    backTracking(i, j, cnt+1);
                    row(1,i,j);
                    col(1,i,j);
                    slide(1,i,j);
                }
            }
        }
    }

    private static void col(int method, int x, int y){
        if(method == 0){
            for(int i=0; i<N; i++){
                map[i][y] = true;
            }
        }
        else{
            for(int i=0; i<N; i++){
                map[i][y] = false;
            }
        }
    }
    private static void slide(int method, int x, int y){
        if(method == 0){
            int plusX = x+1;
            int plusY = y+1;

            while(plusX <N && plusY <N){
                map[plusX][plusY] = true;
                plusX++;
                plusY++;
            }
            int minusX = x-1;
            int minusY = y-1;
            while(minusX >= 0 && minusY >= 0){
                map[minusX][minusY] = true;
                minusX--;
                minusY--;
            }
        }
        else{
            int plusX = x+1;
            int plusY = y+1;

            while(plusX <N && plusY <N){
                map[plusX][plusY] = false;
                plusX++;
                plusY++;
            }
            int minusX = x-1;
            int minusY = y-1;
            while(minusX >= 0 && minusY >= 0){
                map[minusX][minusY] = false;
                minusX--;
                minusY--;
            }
        }
    }
    private static void row(int method, int x, int y){
        if(method == 0){
            for(int i=0; i<N; i++){
                map[x][i] = true;
            }
        }
        else{
            for(int i=0; i<N; i++){
                map[x][i] = false;
            }
        }
    }
}
*/