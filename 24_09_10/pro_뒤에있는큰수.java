import java.util.*;

class pro_뒤에있는큰수 {
    public int[] solution(int[] number) {
        int[] answer = new int[number.length];
        Stack<Integer> s = new Stack<>();

        for(int i=number.length-1; i>=0 ;i--){
            if(s.isEmpty()){
                s.push(number[i]);
                answer[i] = -1;
                continue;
            }

            while(!s.isEmpty() && number[i] >= s.peek()){
                s.pop();
            }

            if(s.isEmpty()){
                answer[i] = -1;
            }
            else{
                answer[i] = s.peek();
            }
            s.push(number[i]);
        }


        return answer;
    }
}


// 2   3   2
// 3   5   5
// 3   5   5
// 5   -1


// 9  -1   6
// 1   5
// 5   6
// 3   6    6
// 6   -1
// 2   -1