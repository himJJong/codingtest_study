import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pro_거리두기 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] spinx = {1,1,-1,-1};
    static int[] spiny = {1,-1,1,-1};
    static String[][] cur;
     public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[5];

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        for(int t=0; t<5; t++){
            cur = new String[5][5];

            for(int i=0; i<5; i++){
                String[] tmp = places[t][i].split("");
                for(int j=0; j<5; j++){
                    cur[i][j] = tmp[j];
                }
            }

            boolean flag = false;
            Loop:
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(cur[i][j].equals("P")){
                        if(!check(i,j) || !check2(i,j)){
                            break Loop;
                        }
                    }
                    if(i==4 && j == 4){
                        flag = true;
                    }
                }
            }

            if(flag){
                list.add(1);
            }
            else{
                list.add(0);
            }
        }

        for(int i=0; i<5; i++){
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }

    }

    private static boolean check2(int x, int y) {
         for(int i=0; i<4; i++){
             int moveX = spinx[i] + x;
             int moveY = spiny[i] + y;

             if(moveX < 0 || moveX>=5 || moveY < 0 || moveY >=5)    continue;
             if(cur[moveX][moveY].equals("P") && (cur[moveX - spinx[i]][moveY].equals("O") || cur[moveX][moveY-spiny[i]].equals("O"))) {
                return false;
             }
         }

         return true;
    }

    private static boolean check(int x, int y) {
        for(int i=0; i<4; i++){
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveY < 0 || moveX >=5 || moveY >= 5)   continue;
            if(cur[moveX][moveY].equals("P")){
                return false;
            }
            else if(cur[moveX][moveY].equals("O")){
                moveX += dx[i];
                moveY += dy[i];

                if(moveX < 0 || moveY < 0 || moveX >=5 || moveY >= 5)   continue;
                if(cur[moveX][moveY].equals("P")){
                    return false;
                }
            }
        }

        return true;
    }
}
