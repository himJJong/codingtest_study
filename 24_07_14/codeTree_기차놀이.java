import java.util.*;

public class codeTree_기차놀이 {
    static List<Deque<Integer>> list; // 리스트를 제네릭 배열 대신 사용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        list = new ArrayList<>(M);

        for(int i=0; i<M; i++){
            list.add(new ArrayDeque<>()); // 각 요소를 ArrayDeque로 초기화
        }

        int cnt = 1;
        for(int i=0; i<M; i++){
            for(int j=0; j<N/M; j++){
                list.get(i).addLast(cnt); // 리스트 요소에 접근
                cnt++;
            }
        }

        for(int i=0; i<Q; i++){
            int num = sc.nextInt();

            if(num == 1){
                int rail = sc.nextInt();
                if(list.get(rail).isEmpty())    continue;
                list.get(rail).addLast(list.get(rail).pollFirst());
            }
            else if(num == 2){
                int rail = sc.nextInt();
                if(list.get(rail).isEmpty())    continue;
                list.get(rail).addFirst(list.get(rail).pollLast());
            }
            else{
                int frontRail = sc.nextInt();
                int LastRail = sc.nextInt();

                while(!list.get(frontRail).isEmpty()){
                    list.get(LastRail).addFirst(list.get(frontRail).pollLast());
                }
            }
        }

        for(int i=0; i<M; i++){
            if(list.get(i).isEmpty()){
                System.out.println(-1);
            }
            else{
                while(!list.get(i).isEmpty()){
                    System.out.print(list.get(i).pollFirst() + " ");
                }
                System.out.println("");
            }
        }
    }
}