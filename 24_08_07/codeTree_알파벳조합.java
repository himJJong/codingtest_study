import java.util.*;
import java.io.*;


public class codeTree_알파벳조합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<>();
        char[] tmp = sc.next().toCharArray();
        Arrays.sort(tmp);  // 미리 정렬하여 사전순으로 조합 생성
        int N = tmp.length;
        boolean[] visited = new boolean[N];
        backTracking(0, new StringBuilder(), tmp, visited, N, set);
        print(set);
    }
    private static void print(TreeSet<String> set){
        for (String str : set) {
            System.out.println(str);
        }
    }

    private static void backTracking(int cnt, StringBuilder mk, char[] tmp, boolean[] visited, int N, TreeSet<String> set){
        if(set.size() == 10000){
            print(set);
            System.exit(0);
        }
        if(N == cnt){
            set.add(mk.toString());
            return;
        }

        for(int i=0; i<N; i++){
            if (i > 0 && tmp[i] == tmp[i - 1] && !visited[i - 1]) continue; // 중복 방지

            if(!visited[i]){
                visited[i] = true;
                backTracking(cnt+1, mk.append(tmp[i]), tmp, visited, N, set);
                mk.deleteCharAt(mk.length() - 1);
                visited[i] = false;
            }
        }
    }
}



//mom 이 나올 수 있는 중복없이 모두 꺼내고 10000까지 or 해당 개수까지, 알파벳 순으로 정렬