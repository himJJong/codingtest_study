import java.util.Scanner;

public class codeTree_조건있는 {
    public static final int MAX_N = 205;

    public static int n, m;
    public static boolean[][] chk = new boolean[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람의 수 n과 친구 쌍의 수 m을 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();

        // 친구 관계를 입력받아 체크합니다.
        for (int i = 0; i < m; ++i) {
            int p, q;
            p = sc.nextInt();
            q = sc.nextInt();
            chk[p][q] = chk[q][p] = true;
        }

        int ans = 0; // 서로 친구가 아닌 사람의 쌍의 개수를 저장할 변수입니다.
        // 세 사람의 조합을 확인하여 서로 친구가 아닌 경우를 찾습니다.
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (chk[i][j]) continue; // i와 j가 친구라면 다음 조합을 확인합니다.
                for (int k = j + 1; k <= n; ++k) {
                    // i와 k, j와 k가 친구라면 다음 조합을 확인합니다.
                    if (chk[i][k] || chk[j][k]) continue;
                    ++ans; // 세 사람이 서로 친구가 아니라면 ans를 1 증가시킵니다.
                }
            }
        }

        // 서로 친구가 아닌 사람의 쌍의 개수를 출력합니다.
        System.out.println(ans);
    }
}