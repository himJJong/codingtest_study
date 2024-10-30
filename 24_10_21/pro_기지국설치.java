class pro_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 1;
        int right = n;
        for(int i=0; i<stations.length; i++){
            int stationsLeft = stations[i]-w-1; //2

            if(left <= stationsLeft){ // 6 < 9
                int tmp = stationsLeft - left + 1;
                answer += tmp/(w*2+1);    // 2 / 2
                if(tmp % (w*2+1) != 0){
                    answer++;
                }
            }
            left = stations[i] + w + 1;
        }

        if(stations[stations.length-1] + w + 1 <= n){
            int tmp = stations[stations.length-1] + w + 1;
            int cal = right - tmp + 1;
            answer += cal / (w*2+1);
            if(cal % (w*2+1) != 0){
                answer++;
            }
        }

        return answer;
    }
}