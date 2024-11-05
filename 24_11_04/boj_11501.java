import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class boj_11501 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){ //100만 * T

            int N = Integer.parseInt(br.readLine());

            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            long answer = 0;
            Stack<Integer> s = new Stack<>();

            for(int j=N-1; j>=0 ; j--){
                if(s.isEmpty()){
                    s.add(data[j]);
                    continue;
                }

                if(data[j] < s.peek()){
                    answer += s.peek() - data[j];
                }
                else if(data[j] > s.peek()){
                    s.pop();
                    s.add(data[j]);
                }
            }

            // 1 1 3 1 5
            // 1 1 3 1 2
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());

    }
}
// 투포인터 접근.. 너무 빡셈
// 구간 별로 최댓값을 구해야 하는데, 뒤쪽에 큰 수가 있다면, 앞의 계산한 결과물이 무용지물. memory도 어려움
// 스택.? 맨뒷값에서 앞으로 체킹하며, 스택에는 최댓값만 있게 한다면.? 이익의 최대이지 않을까