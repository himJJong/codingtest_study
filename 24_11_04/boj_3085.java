import java.util.Scanner;

public class boj_3085 {
    static char[][] board;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            board[i] = line.toCharArray();
        }

        int maxCandies = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    change(i, j, i, j + 1);
                    maxCandies = Math.max(maxCandies, countMax());
                    change(i, j, i, j + 1);
                }

                if (i + 1 < n) {
                    change(i, j, i + 1, j);
                    maxCandies = Math.max(maxCandies, countMax());
                    change(i, j, i + 1, j);
                }
            }
        }

        System.out.println(maxCandies);
    }

    static void change(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static int countMax() {
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int rowCount = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    maxCount = Math.max(maxCount, rowCount);
                    rowCount = 1;
                }
            }
            maxCount = Math.max(maxCount, rowCount);
        }

        for (int j = 0; j < n; j++) {
            int colCount = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    colCount++;
                } else {
                    maxCount = Math.max(maxCount, colCount);
                    colCount = 1;
                }
            }
            maxCount = Math.max(maxCount, colCount);
        }

        return maxCount;
    }
}
