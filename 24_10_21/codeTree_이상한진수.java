import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeTree_이상한진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        List<Integer> binaryList = new ArrayList<>();
        List<Integer> ternaryList = new ArrayList<>();

        // 2진수를 1개씩 변경하여 10진수로 변환하여 리스트에 담기
        for (int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            String front = a.substring(0, i);
            String back = a.substring(i + 1);

            if (current == '0') {
                current = '1';
            } else {
                current = '0';
            }

            int decimal = binaryToDecimal(front + current + back);
            binaryList.add(decimal);
        }

        // 3진수를 1개씩 변경하여 10진수로 변환하여 리스트에 담기
        for (int i = 0; i < b.length(); i++) {
            char current = b.charAt(i);
            String front = b.substring(0, i);
            String back = b.substring(i + 1);

            for (char j = '0'; j <= '2'; j++) {
                if (current != j) {
                    current = j;
                    int decimal = ternaryToDecimal(front + current + back);
                    ternaryList.add(decimal);
                }
            }
        }

        for (int i = 0; i < binaryList.size(); i++) {
            if (ternaryList.contains(binaryList.get(i))) {
                System.out.println(binaryList.get(i));
                break;
            }
        }
    }

    // 2진수를 10진수로 변환
    private static int binaryToDecimal(String binary) {
        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char digit = binary.charAt(i);
            int index = binary.length() - i - 1;
            decimal += (digit - '0') * pow(2, index);
        }

        return decimal;
    }

    // 3진수를 10진수로 변환
    private static int ternaryToDecimal(String ternary) {
        int decimal = 0;

        for (int i = 0; i < ternary.length(); i++) {
            char digit = ternary.charAt(i);
            int index = ternary.length() - i - 1;
            decimal += (digit - '0') * pow(3, index);
        }

        return decimal;
    }

    // 거듭제곱 구하기
    private static int pow(int base, int exponent) {
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }
}