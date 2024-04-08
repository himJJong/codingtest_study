import java.util.*;
import java.io.*;

public class sw_왕실의기사대결 {
    static class soldier{
        int r;
        int c;
        int h;
        int w;
        int k;

        soldier(int r, int c, int h, int w, int k){
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
        }
    }
    static int L;
    static int N;
    static int Q;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    static int[][] map;
    static int[][] order;
    static int[] hp;
    static boolean[] visited;
    static int first;
    static List<soldier> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[L][L];
        order = new int[Q][2];
        hp = new int[N];
        visited = new boolean[N];

        for(int i=0; i<L; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");

            list.add(new soldier(Integer.parseInt(tmp[0]) - 1,
                    Integer.parseInt(tmp[1]) - 1, Integer.parseInt(tmp[2]) - 1,
                    Integer.parseInt(tmp[3]) - 1, Integer.parseInt(tmp[4])));

            hp[i] = Integer.parseInt(tmp[4]);
        }

        for(int i=0; i<Q; i++){
            order[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<Q; i++){
            Arrays.fill(visited,false);
            int soliderIndex = order[i][0]-1;
            int dir = order[i][1];
            first = soliderIndex;
            push(soliderIndex, dir);
        }

        for(int i=0; i<N; i++){
            if(list.get(i).r <= -1) continue;
            if(list.get(i).k > 0){
                answer += hp[i] - list.get(i).k;
            }
        }

        System.out.println(answer);
    }

    private static void push(int soliderIndex, int dir){
        if(check(soliderIndex, dir)){   // 만약 움직일 수 있다면
            moveSolider(dir, soliderIndex);
        }
    }

    private static boolean check(int soliderIndex, int dir){
        List<Integer> tmpX = new ArrayList<>();
        List<Integer> tmpY = new ArrayList<>();

        if(list.get(soliderIndex).r == -1){
            return false;
        }
        for(int i=list.get(soliderIndex).r ; i<=list.get(soliderIndex).r + (list.get(soliderIndex).h); i++){
            if(i == -1) continue;
            for(int j=list.get(soliderIndex).c; j<=list.get(soliderIndex).c + (list.get(soliderIndex).w) ; j++){

                if(!inArea(i+dx[dir],j+dy[dir]) || map[i+dx[dir]][j+dy[dir]] == 2){
                    return false;
                }

                tmpX.add(i+dx[dir]);
                tmpY.add(j+dy[dir]);
            }
        }

        for(int i=0; i<list.size(); i++){
            if(i == first || visited[i])   continue;
            for(int j=list.get(i).r; j<= list.get(i).r + list.get(i).h; j++){
                if(j == -1) continue;
                for(int k=list.get(i).c; k<=list.get(i).c + list.get(i).w; k++){
                    for(int l = 0; l<tmpX.size(); l++){
                        if(tmpX.get(l) == j && tmpY.get(l) == k){
                            visited[i] = true;
                            if(!check(i ,dir)){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean inArea(int x, int y){
        return x >= 0 && y >= 0 && x < L && y < L;
    }


    private static void moveSolider(int dir, int soliderIndex) {
        Queue<soldier> q = new LinkedList<>();
        int size = list.size();
        for (int l = 0; l < size; l++) {
            // 거친 것 추가
            if (list.get(l).r == -1) {
                q.add(new soldier(-1, -1, list.get(l).h, list.get(l).w, list.get(l).k));
                continue;
            }

            int r = list.get(l).r + dx[dir];
            int c = list.get(l).c + dy[dir];

            if (l == first) {
                q.add(new soldier(r, c, list.get(l).h, list.get(l).w, list.get(l).k));
                continue;
            }
            if (!visited[l]) {
                q.add(new soldier(list.get(l).r, list.get(l).c, list.get(l).h, list.get(l).w, list.get(l).k));
                continue;
            }
            int cnt = 0;
            for (int i = r; i <= r + list.get(l).h; i++) {
                for (int j = c; j <= c + list.get(l).w; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                    }
                }
            }
            if (list.get(l).k - cnt <= 0) {
                q.add(new soldier(-1, -1, list.get(l).h, list.get(l).w, list.get(l).k - cnt));
            } else {
                q.add(new soldier(r, c, list.get(l).h, list.get(l).w, list.get(l).k - cnt));
            }
        }

        list.clear();

        while(!q.isEmpty()) {
            list.add(q.poll());
        }
    }
}
/*
3 1 100
1 0 1
2 1 1
0 1 1
2 3 2 1 1
1 3
1 1
1 3
1 0
1 2
1 1
1 1
1 1
1 0
1 2
1 3
1 3
1 2
1 1
1 2
1 0
1 1
1 0
1 2
1 0
1 3
1 3
1 1
1 2
1 0
1 0
1 3
1 2
1 0
1 3
1 3
1 0
1 2
1 1
1 3
1 3
1 2
1 0
1 3
1 2
1 1
1 0
1 2
1 3
1 1
1 2
1 2
1 3
1 1
1 0
1 3
1 3
1 0
1 3
1 3
1 0
1 2
1 2
1 3
1 3
1 0
1 0
1 3
1 1
1 3
1 2
1 1
1 2
1 0
1 0
1 2
1 1
1 0
1 3
1 2
1 1
1 0
1 1
1 3
1 0
1 2
1 2
1 2
1 3
1 2
1 3
1 3
1 3
1 1
1 2
1 0
1 1
1 0
1 3
1 1
1 2
1 0
1 0
1 0
1 3
 */
