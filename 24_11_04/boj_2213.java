import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2213 {
    static class Node implements Comparable<Node>{
        int index;
        int weight;

        Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return o.weight - this.weight;
        }
    }
    // 1. 전체 노드의 가중치를 내림차순으로 정려하고,
    // pq에 넣고, 첫 제일큰거를 기준으로
    // 집합을찾자 ->  1번으로 풀었을 때 문제예상
    // 7-> 1(확인) -> 6(확인)

    //
    static List<Integer>[] list;
    static PriorityQueue<Integer> nodePq;
    static PriorityQueue<Integer> answerNodePq = new PriorityQueue<>();
    static int answer = Integer.MIN_VALUE;
    static int[] data;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        String[] point = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(point[i-1]);
        }
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        while(true){
            String line = br.readLine();
            if(line == null || line.isEmpty()) break;
            String[] tmp = line.split(" ");

            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);

            list[from].add(to);
            list[to].add(from);
        }

        for(int i=1; i<=N; i++){
            nodePq = new PriorityQueue<>();
            int cnt = check(i);

            if(cnt > answer){
                answerNodePq.clear();
                while(!nodePq.isEmpty()){
                    answerNodePq.add(nodePq.poll());
                }
                answer = cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        while(!answerNodePq.isEmpty()){
            sb.append(answerNodePq.poll()).append(" ");
        }
        System.out.print(sb.toString());
    }

    private static int check(int val) {
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(val, data[val]));
        int total = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!set.contains(cur.index)){
                set.add(cur.index);
                nodePq.add(cur.index);
                total += cur.weight;

                set.addAll(list[cur.index]);

                for(int i=1; i<=N; i++){
                    if(!set.contains(i)) pq.add(new Node(i, data[i]));
                }
            }
        }// 7 1 6 -> visited boolean[], -> 전체 노드 첫시작 지점으로 잡고,
        // 최댓값 -> HashSet O(1)

        //

        return total;
    }
}
