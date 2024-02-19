public class SpeckDot {
    public static void main(String[] args) {

    }
    public static long solution(int k, int d){
        long ans = 0;
        for(long i=0; i<=d; i=i+k){
            ans += (long) Math.sqrt((long)Math.pow(d,2) - Math.pow(i,2))/k+1;
        }
        return ans;
    }
}
/**
 * 문제 해석
 * (0,0) 원점에서부터
 * (d,d)까지 k만큼 증가하는 곳에 점을 찍는다.
 * x 나 y 중 하나를 기준으로 좌표 값을 증가시키면서 최대거리 d가 되는 나머지 좌표값을 구하고, 이를 k로 나누면 최대거리 d를 넘지 않는 좌표를 구할 수 있다.
 * +1은 (0,0) 원점.
 **/