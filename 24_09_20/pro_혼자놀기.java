import java.util.*;

class pro_혼자놀기 {
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int count = 0;
    static int count2 = 0;
    public int solution(int[] cards) {
        int answer = Integer.MIN_VALUE;;

        for(int i=0; i<cards.length; i++){
            count = 0;
            visited = new boolean[cards.length];
            int firstGroup = dfs(i, cards, 1);
            //System.out.print(i +"첫번쨰 끝" + firstGroup);
            //System.out.println();
            if(firstGroup == cards.length){
                continue;
            }
            int secondGroup = 0;
            for(int j=0; j<cards.length; j++){
                count2 = 0;
                if(!visited[j]){
                    //System.out.print(j+ " 두번째 시작 ");
                    //System.out.println();
                    secondGroup = dfs2(j, cards, 1);
                }

                while(!q.isEmpty()){
                    visited[q.poll()] = false;
                }
                answer = Math.max(answer, firstGroup * secondGroup);
            }
        }
        if(answer == Integer.MIN_VALUE){
            return 0;
        }
        return answer;
    }

    private static int dfs(int index, int[] cards, int cnt){
        if(!visited[index]){
            //System.out.println("현재 인덱스" + index);    
            visited[index] = true;
            count++;
            dfs(cards[index]-1, cards, cnt+1);
        }

        return count;
    }

    private static int dfs2(int index, int[] cards, int cnt){
        if(!visited[index]){
            q.add(index);
            count2++;
            visited[index] = true;
            dfs2(cards[index]-1, cards, cnt+1);
        }
        return count2;
    }
}

// 숫자카드 1~100
// 2이상 100이하 자연수를 정하고, num
// num보다 작거나 같은 숫자 카드들을 준비하고, 준비한 카드의 수만큼 작은 상자를 준비

// 상자에 카드를 한장씩 넣고,상자를 무작위로 섞은 다음 일렬로 나열
// 나열된 순서로 1번부터 순차적으로 증가하는 번호를 상자에 붙임
// 그리고 상자를 열었을 떄 있는 카드의 번호에 대해 해당 상자를 열음.
// 이미 열려있는게 다시 나올떄까지 반복
// 이렇게 연 상자들이 1번 상자 그룹. 따로 모아두고 남는 상자가 없으면 그대로 게임 종료
// -> 이때 획득한 점수는 0점, 1턴에 모두 열었을 때

// 다 못열었다면, 남은 상자 중 다시 같은 방식으로 하고
// 1번 상자 그룹의 사이즈 * 2번 상자의 그룹의 사이즈의 최고 점수를 구하는게 정답.

// dfs?