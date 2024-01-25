import java.util.Stack;

public class pro_택배상자 {
    public static void main(String[] args) {
        int[] order = {3,2,1,4};
        System.out.println(solution(order));
    }

    private static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();   // 보조 컨베이어

        int[] origin = new int[order.length];

        for(int i=0;i<origin.length; i++){
            origin[i] = i+1;
        }

        int orderIndex = 0;
        int originIndex = 0;
        while(originIndex != order.length){
            if(order[orderIndex] == origin[originIndex]){
                orderIndex++;
                originIndex++;
                answer++;
            }
            else if(order[orderIndex] != origin[originIndex] && s.isEmpty()){
                s.add(origin[originIndex++]);
            }

            else if(origin[originIndex] != order[orderIndex] && s.peek() == order[orderIndex]){
                s.pop();
                orderIndex++;
                answer++;
            }

            else if(origin[originIndex] != order[orderIndex] && s.peek() != order[orderIndex]){
                s.add(origin[originIndex++]);
            }
        }

        while(true){
            if(!s.isEmpty() && s.peek() == order[orderIndex]){
                s.pop();
                orderIndex++;
                answer++;
            }
            else{
                break;
            }
        }

        return answer;
    }
}
