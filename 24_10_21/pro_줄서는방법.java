import java.util.*;

class pro_줄서는방법 {
    // 1 2 3 4
    //   -> 6
    // 2 -> 6
    // 3
    // n = 5, k = 30
    // 5  k 1 ~ 24-> 1
    //    k 25 ~ -> 2
    // 1<- 2 3 4 5
    // 2 2 (222) -> 6
    // k 30 / 24 =  1
    // k 30 % 24 = 6
    // k 6 /6
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        k--;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long total = 1;
        for (int i = 2; i < n; i++) {
            total *= i;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int index = (int) (k / total);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            if(k==0) continue;
            k %= total;
            total /= (n - 1 - i);
        }
        return answer;
    }
}
// -> 1.해당 구간을 미리 찾을 수 있는 곳까지 찾고, 나머지 백트래킹 많이 복잡;;
// -> 2.k값에 대해 인덱스로 뽑아서 체킹
// 1234 3214        24 6 2 1
// 1243 3241
// 1324 3412
// 1342 3421
// 1423 4123
// 1432 4132
// 2134 4213
// 2143 4231
// 2314 4312
// 2341 4321
// 2413
// 2431
// 3124
// 3142
