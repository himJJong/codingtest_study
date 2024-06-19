import java.util.Scanner;
import java.util.Stack;

public class codeTree_건물최소 {
    public static final int MAXN = 50005;
    public static int n;
    public static int[] height = new int[MAXN];
    public static Stack<Integer> stk = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            height[i] = y;
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            int now = height[i];

            // 현재 높이보다 큰 높이가 스택에 있으면, 그 값을 제거하고 카운트합니다.
            while(!stk.isEmpty() && stk.peek() > now){
                if(stk.peek() != 0) cnt++;
                stk.pop();
            }

            // 현재 높이와 같은 높이가 스택에 있으면, 그 값을 넘깁니다.
            if(!stk.isEmpty() && stk.peek() == now) continue;

            stk.push(now);
        }

        // 스택에 남아있는 값들을 카운트합니다.
        while(!stk.isEmpty()){
            if(stk.peek() != 0) cnt++;
            stk.pop();
        }

        // 결과를 출력합니다.
        System.out.println(cnt);
    }
}