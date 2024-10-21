import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_철로 {
    static class Node implements Comparable<Node> {
        int s;
        int e;

        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            if (this.e == o.e) {
                return this.s - o.s; // 시작점이 같을 경우 끝나는 지점을 기준으로 정렬
            }
            return this.e - o.e; // 끝나는 지점을 기준으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        // 입력 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s > e) { // 시작점과 끝점 정리
                int temp = s;
                s = e;
                e = temp;
            }
            list.add(new Node(s, e));
        }

        int d = Integer.parseInt(br.readLine());
        Collections.sort(list); // 끝나는 지점 기준으로 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        // 구간 탐색 및 카운트
        for (int i = 0; i < N; i++) {
            Node cur = list.get(i);

            // 유효 범위 밖인 구간들을 큐에서 제거
            if (cur.e - cur.s > d) continue;
            pq.add(cur.s);

            // 현재 구간에서 유효 범위 밖인 값 제거
            while (!pq.isEmpty() && cur.e - pq.peek() > d) {
                pq.poll();
            }

            // 최대 값 갱신
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}
