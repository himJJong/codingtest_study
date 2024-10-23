import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int s = sc.nextInt();

        long answer1 = 0;
        long answer2 = 0;

        if(w * 2 < s){
            answer1 = (long) (x + y) * w;
            System.out.println(answer1);
        }
        else{
            int min = Math.min(x,y);
            int tmpX = x;
            int tmpY = y;
            answer2 += (long) s * min;

            tmpX -= min;
            tmpY -= min;
            long select1 = 0;
            if(tmpX > 0){
                select1 += (long) w * tmpX;
            }
            if(tmpY > 0){
                select1 += (long) w * tmpY;
            }

            long max = Math.max(tmpX, tmpY);
            long select2 = 0;
            if(max % 2 == 0){
                select2 += max * s;
            }
            else {
                select2 += w + ((max-1) * s);
            }

            long tmp = Math.min(select1, select2);
            answer2 += tmp;
            System.out.println(answer2);
        }
    }
}
