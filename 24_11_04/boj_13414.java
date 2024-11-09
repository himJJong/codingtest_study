import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]), L = Integer.parseInt(input[1]);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            map.remove(id);
        }

        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> a.idx - b.idx);
        for (String s : map.keySet()) {
            pq.offer(new Student(s, map.get(s)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (!pq.isEmpty()) {
                sb.append(pq.poll().id + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Student {
        String id;
        int idx;

        public Student(String id, int idx) {
            this.id = id;
            this.idx = idx;
        }
    }
}
