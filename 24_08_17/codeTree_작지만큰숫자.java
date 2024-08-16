import java.util.*;
import java.io.*;

public class codeTree_작지만큰숫자 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        TreeSet<Integer> set = new TreeSet<>();

        String[] data = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(data[i]));
        }
        String[] query = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(query[i]);
            Integer max = set.floor((Integer)num);

            if (max == null) {
                // num 이하의 값이 없는 경우
                System.out.println(-1);
            } else {
                // max를 출력하고 set에서 제거
                System.out.println(max);
                set.remove(max);
            }
        }

    }
}