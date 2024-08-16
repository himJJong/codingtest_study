import java.util.*;

public class codeTree_알파벳과사칙연산 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static String tmp;
    static int[] val;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tmp = sc.next();
        N = tmp.length(); // 입력받은 문자열의 길이 설정
        val = new int['z'];

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int cnt){
        // cnt는 연산에 사용될 숫자의 개수를 나타냅니다. 따라서 N/2 + 1이 되면 종료
        if (cnt == 6) {
            calculate();
            return;
        }

        for (int i = 1; i <= 4; i++) {
            val['a' + cnt] = i;
            backTracking(cnt+1);
        }
    }

    private static void calculate() {
        int result = val[tmp.charAt(0)];

        for(int i=1; i<tmp.length(); i+=2){
            char oper = tmp.charAt(i);
            int number = val[tmp.charAt(i+1)];

            if (oper == '+') {
                result += number;
            }
            if (oper == '-') {
                result -= number;
            }
            if (oper == '*') {
                result *= number;
            }
        }

        max = Math.max(max, result);
    }
}
