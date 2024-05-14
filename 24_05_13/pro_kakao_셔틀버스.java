import java.util.*;

class pro_kakao_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            int cur = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
            pq.add(cur);
        }

        int last = 0;
        int time = 540;
        int count = 0;

        for(int i=0; i<n; i++){
            count = 0;
            while(!pq.isEmpty()){
                int cur = pq.peek();
                if(cur <= time && count < m){
                    pq.poll();
                    count++;
                }
                else break;
                last = cur - 1;
            }
            time += t;
        }
        if(m > count){
            last = time - t;
        }



        String hour = String.format("%02d", last/60);
        String minute = String.format("%02d", last%60);

        return hour + ":" + minute;
    }
}