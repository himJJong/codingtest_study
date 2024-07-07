import java.util.Scanner;

public class codeTree_연관직사각형 {
    public static final int MAX_NUM = 20;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    // (x1, y1), (x2, y2)를 두 꼭지점으로 하는
    // 직사각형에 있는 값이 전부 양수인지 판단합니다.
    public static boolean positiveRect(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++)
                if(grid[i][j] <= 0)
                    return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int ans = -1;

        // 직사각형의 양쪽 두 꼭지점 (i, j), (k, l)
        // 를 정하여
        // 해당 직사각형안에 있는 값이 전부 양수일 때만
        // 크기를 갱신합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                for(int k = i; k < n; k++)
                    for(int l = j; l < m; l++)
                        if(positiveRect(i, j, k, l))
                            ans = Math.max(ans,
                                    (k - i + 1) * (l - j + 1));

        System.out.print(ans);
    }
}