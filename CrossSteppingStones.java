public class CrossSteppingStones {
    public static void main(String[] args) {

    }
    public static int solution(int[] stones, int k){
        int min = 0;
        int max = Integer.MAX_VALUE;
        int ans = 0;
        while(min<=max){
            int mid = (min+max)/2;
            if(check(mid,k,stones)){
                min = mid+1;
                ans = mid;
            }else{
                max = mid-1;
            }
        }
        return ans;
    }
    public static boolean check(int mid, int k, int[] stones){
        int cnt = 0 ;
        for(int i=0; i<stones.length; i++){
            if(stones[i] < mid){
                cnt++;
                if(cnt>=k) return false;
            }else cnt = 0;
        }
        return true;
    }
}

/**
 * 문제 해석
 * 징검다리를 건널 때 마다 징검다리에 적힌 번호가 1씩 줄어든다.
 * 만약, 건너려는 징검다리의 번호가 0이라면 그 징검다리는 건너뛰고 그 다음 징검다리를 밟는다.
 * 0인 징검다리의 수가 k보다 크다면, 더 이상 건널 수 없다고 판단한다.
 * 징검다리를 다 건넌 인원을 반환한다.
 **/

/**
 * 놓친 부분
 * 징검다리를 건너야 하는 인원 = 무제한, 징검다리에 적힌 번호 = 200,000,000 이하의 자연수
 * 즉, 일반적인 반복문으로 진행하면 시간 초과가 일어난다.
 * (참고, 이분 탐색)
 * 이분 탐색을 통해 건널 수 있는 인원에 대해 mid값으로 둔다.
 * 건널 수 있는지에 대한 판단은 mid의 값이 stones에 적힌 값보다 크다면 건널 수 있다.
 * 건널 수 없다면, cnt를 통해 건널 수 없는 stones에 대해 개수를 세어준다.
 * cnt가 k보다 크거나 같아지면 건널 수 없는 상태로 종료된다.
 **/