import java.util.*;
public class XixoPartner {
    public static void main(String[] args) {

    }
    public long solution(int[] weights){
        long ans = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights){
            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;
            if(map.containsKey(a)) ans += map.get(a);
            if(map.containsKey(b)) ans += map.get(b);
            if(map.containsKey(c)) ans += map.get(c);
            if(map.containsKey(d)) ans += map.get(d);

            map.put((i*1.0), map.getOrDefault((i*1.0),0)+1);
        }
        return ans;
    }
}

/**
 * 문제 해석
 * weights의 길이가 100,000 까지 이기 때문에 시간 복잡도를 고려
 * Map을 이용해서 중복 여부를 체크하면서 문제를 푸는 방식을 확인
 * (100,100)으로 같을 때 (= a i*1.0)
 * (200,300)으로 2M와 3M에 놓일 때 (= b (i*2.0)/3.0)
 * (200,400)으로 2M와 4M에 놓일 때 (= c (i*1.0)/2.0)
 * (300,400)으로 3M와 4M에 놓일 때 (= d (1*3.0)/4.0)
 * 해당 키 값이 존재한다면 그 키 값을 추가.
 **/