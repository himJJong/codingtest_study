import java.util.Scanner;
import java.util.Stack;

public class codeTree_표기법변환 {
    public static String str;
    public static Stack<Character> s = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        str = sc.next();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                // 피연산자가 입력으로 들어온 경우입니다.
                // 이들은 입력을 받는 즉시 그대로 출력해줍니다.
                System.out.print(str.charAt(i));
            }
            else if(str.charAt(i) != ')') {
                // ')'를 제외한 연산자가 입력으로 들어온 경우입니다.
                // 스택을 이용해 후위 연산자의 규칙에 맞게 출력해야할 연산자를 잘 관리합니다.
                while(!s.isEmpty()) {
                    char x = s.peek();

                    // 이전 연산자의 우선순위를 표기합니다.
                    int rank_before = 0;

                    if(x == '*' || x == '/') rank_before = 2;
                    if(x == '+' || x == '-') rank_before = 1;

                    // 새로 들어온 연산자의 우선순위를 표기합니다.
                    int rank_after = 0;

                    if(str.charAt(i) == '(') rank_after = 3;
                    if(str.charAt(i) == '*' || str.charAt(i) == '/') rank_after = 2;
                    if(str.charAt(i) == '+' || str.charAt(i) == '-') rank_after = 1;

                    // 기존 연산자의 우선순위가 더 높거나 같으면, 기존 연산자를 출력합니다.
                    if(rank_before >= rank_after) {
                        System.out.print(x);
                        s.pop();
                    }
                    // 그 외의 경우 기존 연산자를 더 이상 출력하지 않습니다.
                    else break;
                }

                s.push(str.charAt(i));
            }
            else {
                // ')'가 입력으로 들어온 경우입니다.
                // '('이 나올 때 까지 이전 연산자들을 전부 출력합니다.
                while(!s.isEmpty()) {
                    char x = s.pop();

                    if(x == '(') {
                        break;
                    }

                    System.out.print(x);
                }
            }
        }

        // 스택에 남아있는 연산자가 있다면,
        // 전부 출력해줍니다.
        while(!s.isEmpty()) {
            char x = s.pop();
            System.out.print(x);
        }
    }
}