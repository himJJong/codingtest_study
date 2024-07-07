import java.util.*;
public class pro_햄버거 {
    public static void main(String[] args) {
        int[] ingredient = {2,1,1,2,3,1,2,3,1};
        System.out.println(Solution.solution(ingredient));
    }

    static class Solution {
        public static int solution(int[] ingredient) {
            int answer = 0;
            int[] check = {1,2,3,1};
            int index = 0;

            Stack<Integer> s = new Stack<>();
            for(int i=0; i<ingredient.length; i++){
                s.add(ingredient[i]);
                if(s.peek() == check[index]){
                    index++;
                }
                else if(s.peek() != check[index] && s.peek() == 1){
                    index = 1;
                }
                else{
                    index = 0;
                }

                if(index == 4){
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();

                    if(!s.isEmpty() && s.peek() == 1){
                        index = 1;
                    }
                    else if(!s.isEmpty() && s.peek() != 1){
                        index = 0;
                    }
                    answer++;
                }
            }
            return answer;
        }
    }
}
