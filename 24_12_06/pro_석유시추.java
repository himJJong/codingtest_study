import java.util.*;

class pro_석유시추 {
    static int area = 1;
    static int seperateArea = 1;
    static boolean[] totalArea; //최종 체크할 대
    static boolean[][] map;     //구역의 값 증가를 위한 map
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] newMap;      //구역의 분리를 위한 Map
    static HashMap<Integer, Integer> hm = new HashMap<>();  // 구역의 최댓값
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        newMap = new int[land.length][land[0].length];
        map = new boolean[land.length][land[0].length];
        hm.put(0,0);
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(!map[i][j] && land[i][j] == 1){
                    seperateArea = 0;
                    dfs(land, i,j,1);
                    hm.put(area, seperateArea);
                    area++;
                }
            }
        }

        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                land[i][j] = hm.get(newMap[i][j]);
            }
        }

        totalArea = new boolean[area];
        for(int i=0; i<land[0].length; i++){
            Arrays.fill(totalArea, false);
            int cnt = 0;
            for(int j=0; j<land.length; j++){
                int index = newMap[j][i];
                if(!totalArea[index] ){
                    totalArea[index] = true;
                    cnt += hm.get(index);
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
    private static void dfs(int[][] land, int x, int y, int cnt){
        map[x][y] = true;
        newMap[x][y] = area;
        seperateArea++;

        for(int i=0; i<4; i++){
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveX >= land.length || moveY < 0 || moveY >= land[0].length || map[moveX][moveY] || land[moveX][moveY] == 0){
                continue;
            }
            dfs(land, moveX, moveY, cnt+1);
        }
    }
}








