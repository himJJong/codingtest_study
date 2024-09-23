import java.io.*;
import java.util.*;

public class codeTree_동전개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int goal = sc.nextInt();

        int[] data = new int[N];

        for(int i=N-1; i>=0; i--){
            data[i] = sc.nextInt();
        }

        int count = 0;
        int index = 0;
        while(goal != 0){
            if(goal / data[index] > 0){
                count += goal / data[index];
                goal %= data[index];
            }

            index++;
        }

        System.out.println(count);
    }
}