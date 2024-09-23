class pro_이모티콘할인 {
    static int[] dx = {10,20,30,40};
    static int[] sales;
    static int user = Integer.MIN_VALUE;
    static int totalMoney = Integer.MIN_VALUE;
    static int index= 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        sales = new int[emoticons.length];
        btk(users, emoticons, 0);
        // int[] cal = 할인율담기;
        answer[0] = user;
        answer[1] = totalMoney;
        System.out.println(index);

        return answer;
    }

    private static void btk(int[][] users, int[] emoticons, int N ){
        if(N == emoticons.length){
            int serviceUser = 0;
            int money = 0;
            for(int i=0; i<users.length; i++){ //여기는 사람 인덱스고
                int check = 0;
                for(int j=0; j<emoticons.length; j++){ //각 이모티콘에 대한 할인율을 적용해야함 
                    if(sales[j] >= users[i][0]){
                        check += emoticons[j] * (100-sales[j]) / 100;
                    }
                }

                if(check >= users[i][1]){
                    serviceUser++;
                }
                else{
                    money += check;
                }
            }

            if (serviceUser > user || (serviceUser == user && money > totalMoney)) {
                user = serviceUser;
                totalMoney = money;
            }

            return;
        }



        for(int i=0; i<4; i++){
            sales[N] = dx[i];
            btk(users, emoticons, N+1);
        }
        // 이모티콘 6개, 10 20 30 40 [4^6]
    }
}

// 4^7 -> 100명
// 1024 2048 4096 8192 16394
// 0    1    2    3    4
// O(1639400)  
// 중복있어도됨 모든것 체크
// 분기조건(이모티콘개수)에서, 이모티콘 가입자의 최대수보다 크다면? 구매값도 변경
// 같다면? 최댓값으로 적용