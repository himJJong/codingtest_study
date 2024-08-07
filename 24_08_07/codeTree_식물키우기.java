import java.util.Scanner;

public class codeTree_식물키우기 {
    public static final int MAXN = 100005;
    public static int n, q, t;
    public static int[] a = new int[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();
        q = sc.nextInt();
        t = sc.nextInt();

        // q번의 질의를 처리하며 누적 배열을 생성합니다.
        for(int i = 0; i < q; i++) {
            int l, r;
            l = sc.nextInt();
            r = sc.nextInt();

            // 구간 시작점에서 1을 더하고, 끝 점 바로 다음에서 1을 뺍니다.
            a[l]++;
            a[r+1]--;
        }

        // t 값을 가진 위치가 있는지 여부를 is_used에 저장합니다.
        boolean is_used = false;

        // 누적 배열을 완성하며 t 값을 가진 위치를 찾아 출력합니다.
        for(int i = 1; i <= n; i++) {
            a[i] += a[i - 1];
            if(a[i] == t) {
                is_used = true;
                System.out.print(i + " ");
            }
        }

        // t 값을 가진 위치가 없을 경우 -1을 출력합니다.
        if(!is_used) System.out.print(-1);
    }
}