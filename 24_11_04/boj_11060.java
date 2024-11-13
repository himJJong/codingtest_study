import java.io.*;
import java.util.*;

public class boj_11060 {
    static class Node {
        int x;
        int size;
        int cnt;

        Node(int x, int size, int cnt) {
            this.x = x;
            this.size = size;
            this.cnt = cnt;
        }
    }

    static int[] data;
    static boolean[] visited;
    static int N;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        bfs(0);
        System.out.println(answer);
    }

    private static void bfs(int pos) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(pos, data[0], 0));
        visited[0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == N - 1) {
                answer = cur.cnt;
                break;
            }

            for (int i = 1; i <= cur.size; i++) {
                int moveX = cur.x + i;

                if (moveX >= N || visited[moveX]) {
                    continue;
                }
                visited[moveX] = true;
                q.add(new Node(moveX, data[moveX], cur.cnt + 1));
            }
        }
    }// visited 방문처리가 됐으면 -
}
