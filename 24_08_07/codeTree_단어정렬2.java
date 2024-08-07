import java.util.*;
import java.io.*;

public class codeTree_단어정렬2 {
    static class Node implements Comparable<Node>{
        String data;
        int len;

        Node(String data, int len){
            this.data = data;
            this.len = len;
        }

        @Override
        public int compareTo(Node o){
            if(this.len == o.len){
                return this.data.compareTo(o.data); // 사전순 비교
            }
            return this.len - o.len;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Node> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String cur = br.readLine();
            list.add(new Node(cur, cur.length()));
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).data);
        }
    }
}