import java.util.*;
public class PostingBox {
    public int solution(int[] order) {
        int target=0; // 1번 상자 부터(인덱스는 0)
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트
        for(int i=0; i<order.length; i++){
            stack.push(i+1); // 우선 보조 컨테이너 벨트에 넣음
            while(!stack.isEmpty()){
                if(stack.peek() == order[target]){
                    stack.pop();
                    target++;
                }else break;
            }
        }
        return target;
    }
}

/**
 * 문제 해석
 * 1번부터 n번 까지의 택배상자를 컨테이너 벨트에 놓는다.
 * 이를 트럭에 싣는다.
 * 순서에 맞지 않는다면 보조 컨테이너 벨트에 놓는다.
 * 보조 컨테이너 벨트는 스택형식이다.
 * 보조 컨테이너에서 빼거나, 바로 실을 수 없는 상황이면 더 이상 상자를 싣지 않는다.
 * 실어야 하는 박스의 순서가 [4,3,1,2,5] 라면
 * [1,2,3,4,5] 중 [1,2,3]은 보조 컨테이너 벨트에 놓는다.
 * 보조 컨테이너 벨트 = [1,2,3] 의 순서로 Stack이 쌓이며 맨 위 상자는 [3]이다.
 * 그 후, [4] 상자를 트럭에 싣는다.
 * 이후 [3]번 상자를 트럭에 실을 순서이므로 보조 컨테이너 벨트에서 pop() 한다.
 * [1]번 상자를 싣는 순서에서 [2]번 상자를 놓을 공간이 없으므로 더이상 트럭에 실을 수 없다.
 * 결국 트럭에 실린 상자의 갯수는 2개이다.
 * [4]번 상자를 트럭에 싣는 경우도 보조 컨테이너 벨트에 놓았다가 바로 pop()하는 경우와 동일하다.
 **/