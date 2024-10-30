import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2024 {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x == o.x) {
                return o.y - this.y;  // y 값을 내림차순으로 정렬
            }
            return this.x - o.x;  // x 값을 오름차순으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int e = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 입력 받기
        while (true) {
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            if (x == 0 && y == 0) break;
            pq.add(new Node(x, y));
        }

        int s = 0;  // 시작점
        int answer = 0;
        int movingIndex = 0;

        // 큐가 비지 않는 동안 처리
        // 처리해야할 길이 s ~ e
        // 체크해주는 인덱스 movingIndex
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 현재 구간이 이미 처리된 범위보다 뒤에 있으면 (빈 구간 발생)
            if (current.x > s) {
                // 현재 시작점보다 큰 값이 있으면 불가능한 구간이 발생하므로 종료
                if (current.x > movingIndex) {
                    break;
                }
                // 다음 처리할 지점 갱신
                s = movingIndex;
                answer++;
            }

            // 처리 가능한 구간을 확장
            movingIndex = Math.max(movingIndex, current.y);

            // 이미 끝 범위를 넘겼으면 종료
            if (movingIndex >= e) {
                answer++;
                break;
            }
        }

        // 결과 출력
        if (movingIndex < e) {
            System.out.println(0);  // 끝까지 처리 못한 경우
        } else {
            System.out.println(answer);  // 성공적으로 처리한 경우
        }
    }
}
