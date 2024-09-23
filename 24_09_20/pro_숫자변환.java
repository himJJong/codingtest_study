import java.util.*;

class pro_숫자변환 {
    static class Node{
        int val;
        int cnt;
        Node(int val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }
    static int[] dx;
    static int[] data;
    static int s;
    static int e;
    static int goal;
    static boolean[] visited;
    public int solution(int x, int y, int n) {
        int answer = 0;

        if(x == y)  return 0;

        visited = new boolean[y+1];
        goal = y;
        data = new int[y+1];
        Arrays.fill(data, Integer.MAX_VALUE);
        dx = new int[3];
        dx[0] = 2;
        dx[1] = 3;
        dx[2] = n;

        bfs(x);

        if(data[goal] == Integer.MAX_VALUE){
            return -1;
        }
        return data[goal];
    }

    private static void bfs(int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,0));
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0; i<3; i++){
                int moveX = cur.val;
                if(i==2){
                    moveX += dx[i];
                }
                else{
                    moveX *= dx[i];
                }
                //System.out.println(moveX);
                if(moveX > goal || visited[moveX])   {
                    continue;
                }

                if(moveX == goal){
                    //System.out.println(data[moveX]);
                    data[moveX] = cur.cnt+1;
                    q.clear();
                    break;
                }

                visited[moveX] = true;
                data[moveX] = cur.cnt+1;
                q.add(new Node(moveX, cur.cnt+1));
            }
        }
    }
}

// 10 * 2 
// 