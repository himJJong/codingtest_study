import java.io.*;
import java.util.*;

public class codeTree_최단runlength {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        StringBuilder sb = new StringBuilder(text);

        for(int i=0; i<text.length(); i++){
            check(sb.toString());
            char tmp = sb.charAt(text.length()-1);
            sb.deleteCharAt(text.length()-1);
            sb.insert(0, tmp);
        }

        System.out.println(min);
    }
    private static void check(String cur){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0; i<cur.length()-1; i++){
            if(cur.charAt(i) == cur.charAt(i+1)){
                count++;
            }
            else{
                sb.append(cur.charAt(i)).append(count);
                count = 1;
            }
        }

        if(count != 0){
            sb.append(cur.charAt(cur.length()-1)).append(count);
        }
        // System.out.println(sb.toString());
        min = Math.min(sb.toString().length(), min);
    }
}