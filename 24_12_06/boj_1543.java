import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj_1543 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String findStr = br.readLine();

        int answer = 0;
        int findStrSize = findStr.length();

        for(int i=0; i<s.length(); i++){
            i=0;
            if(s.length() < findStrSize)    break;
            if(s.startsWith(findStr)){
                answer++;
                s = s.substring(i+findStrSize);
                i+= (findStrSize-1);
            }
            else{
                s = s.substring(1);
            }
        }
        if(s.equals(findStr))   answer++;
        System.out.println(answer);
    }
}
// 125000
