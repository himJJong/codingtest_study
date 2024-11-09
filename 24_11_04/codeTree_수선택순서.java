import java.io.*;

import java.util.*;

public class codeTree_수선택순서 {
    static class Node{
        int idx;
        int val;

        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        String[] data = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            q.add(new Node(i, Integer.parseInt(data[i])));
            pq.add(Integer.parseInt(data[i]));
        }

        int answer = 0;

        while(true){
            if(q.peek().val < pq.peek()){
                q.add(q.poll());

            }
            else{
                answer++;
                pq.poll();
                Node cur = q.poll();
                if(cur.idx == M)    break;
            }
        }
        System.out.println(answer);
    }
}