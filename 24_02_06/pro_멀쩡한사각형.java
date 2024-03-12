public class pro_멀쩡한사각형 {
    class Solution {
        public long solution(int w, int h) {
            long answer = 1;

            long area = (long) w * h;
            long gcd = gcd(w, h);

            return area - (w + h - gcd);
        }

        // 최대 공약수를 구하는 메소드
        private long gcd(long a, long b) {
            while (b != 0) {
                long temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }

    }

}
