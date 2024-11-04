import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj_중복제거 {
    public static void main(String[] args)throws IOException {
        HashSet<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int val = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<tmp.length; i++){
            val = Integer.parseInt(tmp[i]);
            if(!set.contains(val)){
                set.add(val);
                sb.append(val).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
