import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            boolean check = false;
            String str = br.readLine();
            String[] words = str.split(" ");

            for (int j = 0; j < words.length; j++) {
                String s = words[j].charAt(0) + "";
                int index = 0;

                if (!set.contains(s.toUpperCase()) && !set.contains(s.toLowerCase())) {
                    set.add(s.toUpperCase());
                    set.add(s.toLowerCase());
                    check = true;

                    for (int k = 0; k < j; k++) {
                        index += words[k].length();
                        if (index != 0) index += 1;
                    }

                    sb.append(str.substring(0, index) + "[" + str.charAt(index) + "]" + str.substring(index + 1) + "\n");
                    break;
                }
            }
            if (check) continue;

            for (int j = 0; j < str.length(); j++) {
                String s = str.charAt(j) + "";

                if (!s.equals(" ") && !set.contains(s.toUpperCase()) && !set.contains(s.toLowerCase())) {
                    set.add(s.toUpperCase());
                    set.add(s.toLowerCase());
                    check = true;

                    sb.append(str.substring(0, j) + "[" + str.charAt(j) + "]" + str.substring(j + 1) + "\n");
                    break;
                }
            }

            if (!check) {
                sb.append(str + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
