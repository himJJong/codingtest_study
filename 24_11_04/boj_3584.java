import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class boj_3584 {
    static List<Integer>[] list;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test = 0; test < T ; test++){
            int node = Integer.parseInt(br.readLine());
            list = new ArrayList[node+1];
            for(int i=1; i<=node; i++){
                list[i] = new ArrayList<>();
            }
            int a = 0;
            int b = 0;
            for(int i=1; i<=node; i++){
                String[] tmp = br.readLine().split(" ");
                if(i==node){
                    a = Integer.parseInt(tmp[0]);
                    b = Integer.parseInt(tmp[1]);
                }
                else{
                    list[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
                }
            }
            sb.append(findNode(a,b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int findNode(int a, int b) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        check(a, set);
        check2(b, set2, set);

        return answer;
    }
    private static void check2(int val , HashSet<Integer> set2, HashSet<Integer> set){
        if(set.contains(val)){
            answer = val;
            return;
        }

        set2.add(val);
        for(int next : list[val]){
            check2(next,set2,set);
        }
    }

    private static void check(int val, HashSet<Integer> set){
        set.add(val);

        for(int next : list[val]){
            check(next, set);
        }
    }
}
