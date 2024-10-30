import java.util.Scanner;

public class codeTree_진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        // 왼쪽으로 4번 shift(16배)
        String shift = n + "0000";
        // 자리수 맞추기
        n = "0000" + n;

        // carry 연산을 위한 변수
        int carry = 0;
        // 결과를 담을 StringBuilder
        StringBuilder result = new StringBuilder();

        // n 역순으로 반복
        for (int i = n.length() - 1; i >= 0; i--) {
            int a = n.charAt(i) - '0';
            int b = shift.charAt(i) - '0';
            int sum = a + b + carry;

            // 이진수 계산
            if (sum % 2 == 0) {
                result.insert(0, "0");
            } else {
                result.insert(0, "1");
            }

            // carry 연산
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        // carry가 남아있으면 "1" 붙임
        if (carry == 1) {
            result.insert(0, "1");
        }

        System.out.println(result);
    }
}