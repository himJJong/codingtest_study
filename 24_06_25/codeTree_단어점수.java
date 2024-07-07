import java.util.Scanner;
import java.util.HashMap;

public class codeTree_단어점수 {
    public static final int MAX_N = 50005;
    public static final int MAX_M = 15;
    public static final int MAX_CHAR = 30;

    public static int n, m, k;

    public static String[] words = new String[MAX_N];
    public static int[] values = new int[MAX_N];
    public static int[] result = new int[MAX_N];

    // 각 위치와 알파벳에 따른 값의 빈도수를 저장합니다.
    public static HashMap<Integer, Integer>[][] freq = new HashMap[MAX_M][MAX_CHAR];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        // 단어와 값 입력받기
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            values[i] = sc.nextInt();
        }

        // freq 배열 초기화
        for (int i = 0; i < MAX_M; i++) {
            for (int j = 0; j < MAX_CHAR; j++) {
                freq[i][j] = new HashMap<>();
            }
        }

        // 각 알파벳 위치에 따른 값의 빈도 계산
        for (int j = 0; j < m; j++) {
            for (int i = 1; i <= n; i++) {
                int charIndex = words[i].charAt(j) - 'a';
                freq[j][charIndex].put(values[i], freq[j][charIndex].getOrDefault(values[i], 0) + 1);
            }

            for (int i = 1; i <= n; i++) {
                int charIndex = words[i].charAt(j) - 'a';
                int matchedValue = freq[j][charIndex].getOrDefault(k - values[i], 0);

                // 값이 k의 절반인 경우 빈도를 하나 줄입니다. (자기 자신을 제외하기 위해)
                if (values[i] * 2 == k) {
                    matchedValue--;
                }

                // 빈도 수 만큼 정답에 추가합니다.
                result[i] += matchedValue;
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}