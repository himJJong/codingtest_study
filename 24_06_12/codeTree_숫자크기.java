import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class codeTree_숫자크기 {
    public static final int MAX_N = 100000;

    // 변수 선언
    public static int n, m;

    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];

    // 진입차수를 관리합니다.
    public static int[] indegree = new int[MAX_N + 1];

    // 위상정렬을 위한 우선순위 큐를 관리합니다.
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        // 인접리스트로 관리합니다.
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            edges[x].add(y);
            indegree[y]++; // 진입차수를 갱신합니다.  
        }

        // 처음 indegree 값이 0인 곳이 시작점이 됩니다.
        // 이 노드들을 priority queue에 넣어줍니다.
        for(int i = 1; i <= n; i++)
            if(indegree[i] == 0)
                pq.add(i);

        // 위상정렬을 진행합니다.
        // priority queue에 원소가 남아있다면 계속 진행합니다.
        while(!pq.isEmpty()) {
            // 가장 앞에 있는 원소를 뽑아줍니다.
            int x = pq.poll();

            // x값을 출력합니다.
            // 뽑히는 순서가 곧 위상정렬 순서가 됩니다.
            System.out.print(x + " ");

            // x에서 갈 수 있는 모든 곳을 탐색합니다.
            for(int i = 0; i < edges[x].size(); i++) {
                int y = edges[x].get(i);

                // 해당 노드의 indegree를 1만큼 감소시켜줍니다.
                indegree[y]--;

                // 비로소 indegree가 0이 되었다면
                // priority queue에 새로 넣어줍니다.
                if(indegree[y] == 0)
                    pq.add(y);
            }
        }
    }
}