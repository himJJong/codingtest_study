import java.util.*;

public class codeTree_코드트리마트 {
    public static final int MAX_N = 100005;
    public static final int INF = 1012345678;

    public static int n, k;

    // 손님들의 정보를 저장합니다.
    public static Pair[] user = new Pair[MAX_N];

    // 줄을 기다리는 손님들 중, 담은 물건의 총합이 높은 사람을,
    // 만약 같다면 먼저 온 사람을 가장 먼저 뽑을 수 있도록
    // 우선순위 큐 자료구조에 손님들의 정보를 저장합니다.
    public static PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing((Pair p) -> p.weight)
            .thenComparing(p -> p.arrivalTime).reversed());

    public static class Pair {
        int arrivalTime, weight, id;
        Pair(int a, int w, int i) {
            this.arrivalTime = a;
            this.weight = w;
            this.id = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수를 입력받습니다.
        n = sc.nextInt();
        k = sc.nextInt();

        // 손님들의 정보를 입력받습니다.
        for (int i = 1; i <= n; i++) {
            int arrival = sc.nextInt();
            int weight = sc.nextInt();
            user[i] = new Pair(arrival, weight, i);
        }

        // 작업 시작 시간 기준으로 정렬해 놓습니다.
        Arrays.sort(user, 1, n + 1, Comparator.comparing((Pair p) -> p.arrivalTime));

        user[n + 1] = new Pair(INF, INF, INF);

        // 앞으로 들어갈 손님 중 가장 앞 번호입니다.
        int lastProcessedIndex = 1;

        // 가장 최근 계산이 끝나는 시간을 저장합니다.
        int currentTime = 0;

        // 유저를 조건에 맞게 우선순위 큐에 넣어줍니다.
        for (int i = 1; i <= n + 1; i++) {
            if (i > 1 && user[i].arrivalTime == user[i - 1].arrivalTime) continue;
            if (user[i].arrivalTime <= currentTime) continue;

            // 다음 계산이 진행되기 전까지 온 손님들을 모두 우선순위 큐에 넣어줍니다.
            for (int j = lastProcessedIndex; j < i; j++) {
                pq.add(new Pair(-user[j].arrivalTime, user[j].weight, user[j].id));
            }

            lastProcessedIndex = i;

            while (!pq.isEmpty() && user[i].arrivalTime > currentTime) {
                // 다음으로 계산할 손님을 고릅니다.
                Pair currentUser = pq.poll();

                // 가장 최근 계산이 끝나는 시간을 갱신합니다.
                currentTime = Math.max(currentTime, -currentUser.arrivalTime) + k;

                // 계산한 손님의 번호를 출력합니다.
                System.out.print(currentUser.id + " ");
            }
        }

        // 남은 손님들을 우선순위 순서대로 처리합니다.
        while (!pq.isEmpty()) {
            Pair remainingUser = pq.poll();
            System.out.print(remainingUser.id + " ");
        }
    }
}