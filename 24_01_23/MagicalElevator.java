public class MagicalElevator {
    public int solution(int storey){
        String tmp = Integer.toString(storey);
        int[] arr = new int[tmp.length()];

        for(int i=0; i<tmp.length(); i++){
            arr[i] = tmp.charAt(i)-'0';
        }

        int ans = 0;

        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] > 5){
                ans += 10-arr[i];
                if(i==0) ans++;
                else arr[i-1]++;
            }
            else if(arr[i]==5 && i>0 && arr[i-1]>=5){
                arr[i-1]++;
                ans+=5;
            }
            else ans+=arr[i];
        }
        return ans;
    }
}

/**
 * 문제 해석
 * 주어진 층수 storey 에서 0층으로 최소한의 마법의 돌을 사용하여 가는 방법.
 * 마법의 돌은 층수 버튼 1개를 누를 때 마다 소모
 * 주어진 층수의 자릿수를 통해 문제 해결
 * 2554층이라면, [2,5,5,4]로 변환 후 뒤에서 부터 계산. [4,5,5,2]
 * 5를 기준으로 5보다 크면 +1을 통해 10을 만들고, -10을 하는 것이 더 효율적
 * 5보다 작으면 -1을 통해 0의 자리 수로 변환.
 **/

/**
 * 놓친 점
 * 5라면 +,- 둘 다 상관이 없다고 판단함. 때문에 - 연산으로만 해결하려고 하였음.
 * 하지만 +를 했을 경우 그 전의 자리 수가 증가하므로 그것까지 비교하여 연산.
 * 2554층의 경우 4개를 소모하여 2550이 되었고, 세 번째 자리 수 5에 대해 +,-를 선택할 때 이 전의 수가 5이상이므로
 * +를 할 경우 6이 되므로, -를 했을 때 2500보다 소모해야 할 마법의 돌 개수가 1개 줄어든다.
 * 결국 5일때 이 전의 자리 수 까지 비교하여 계산.
 **/