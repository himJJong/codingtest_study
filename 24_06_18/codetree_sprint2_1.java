import java.util.Scanner;

public class codetree_sprint2_1 {

        public static int num;
        public static int sum;
        public static int part;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // num을 입력받습니다.
            num = sc.nextInt();

            // 1부터 num까지 반복합니다.
            for (int i = 1; i < num; ++i) {
                // 변수 초기화입니다.
                sum = i;
                part = i;

                // part가 0이 아닐 동안 반복합니다.
                while (part != 0) {
                    // sum에 part의 일의 자리를 더하고 part를 10으로 나눕니다.
                    sum += part % 10;
                    part /= 10;
                }

                // 만약 num이 sum과 같다면
                if (num == sum) {
                    // i를 출력하고 프로그램을 종료합니다.
                    System.out.println(i);
                    return;
                }
            }

            // 생성자가 없다면 0을 출력합니다.
            System.out.println("0");
        }
    }

