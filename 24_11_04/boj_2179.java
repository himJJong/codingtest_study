import java.io.*;
import java.util.*;
public class boj_2179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        String S = "";
        String T = "";

        for (int i = 0; i < N; i++) {
            String cur = br.readLine();
            for (int j = 0; j < cur.length(); j++) {
                String s = cur.substring(0,j+1);
                if(map.containsKey(s)){
                    if(s.length() > cnt){
                        S = map.get(s);
                        T = cur;
                        cnt = s.length();
                    }
                }
                else {
                    map.put(s,cur);
                }
            }
        }
        System.out.println(S);
        System.out.println(T);
    }
}