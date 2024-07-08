import java.util.*;

public class codeTree_백화점 {
    // 최대 손님 수를 정의합니다.
    public static final int MAX_N = 100005;

    // 손님 수(n), 계산대 수(k), 찾으려는 손님 순서(x)를 정의합니다.
    public static int n, k, x;

    // 각 손님의 정보를 저장할 배열을 정의합니다.
    public static Pair[] user = new Pair[MAX_N];

    // 계산대의 상태를 저장할 우선순위 큐를 정의합니다.
    public static PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparing((Triple t) -> t.first.first)
            .thenComparing(t -> t.first.second));

    // 손님의 도착시간과 계산시간을 저장할 Pair 클래스를 정의합니다.
    public static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // 계산대의 현재 상태를 저장할 Triple 클래스를 정의합니다.
    public static class Triple {
        Pair first;  // (계산이 끝나는 시간, 계산대 번호)
        int second;  // 손님의 도착 시간

        Triple(Pair first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 손님 수, 계산대 수, 찾으려는 손님의 순서를 입력받습니다.
        n = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // 각 손님의 도착 시간과 계산 시간을 입력받습니다.
        for (int i = 1; i <= n; i++) {
            int index = sc.nextInt();
            int processingTime = sc.nextInt();
            user[i] = new Pair(index, processingTime);
        }

        // 초기 k명의 손님을 계산대에 배치합니다.
        for (int i = 1; i <= Math.min(n, k); i++) {
            pq.add(new Triple(new Pair(user[i].second, i), user[i].first));
        }

        int count = 0;
        int currentIndex = k + 1;

        // 우선순위 큐가 빌 때까지 반복합니다.
        while (!pq.isEmpty()) {
            // 가장 먼저 계산이 끝나는 손님을 큐에서 꺼냅니다.
            Triple currentUser = pq.poll();
            count++;

            // x번째로 계산이 끝나는 손님의 도착 시간을 출력합니다.
            if (count == x) {
                System.out.println(currentUser.second);
                return;
            }

            // 다음 손님을 계산대에 추가합니다.
            if (currentIndex <= n) {
                pq.add(new Triple(new Pair(currentUser.first.first + user[currentIndex].second, currentUser.first.second), user[currentIndex].first));
                currentIndex++;
            }
        }
    }
}
