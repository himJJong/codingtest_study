public class pro_pccp_붕대감기 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int max = health;
            int answer = 0;
            int lastTime = attacks[attacks.length-1][0];
            int index = 0;
            int success = 0;

            for(int i=0; i<=lastTime; i++){

                if(attacks[index][0] == i){
                    success = 0;
                    health -= attacks[index][1];

                    index++;
                }
                else{
                    if(health == max){
                        success++;
                    }
                    else if(health < max && health + bandage[1] >= max){
                        health = max;
                        success++;
                    }
                    else if(health < max && health + bandage[1] < max){
                        health += bandage[1];
                        success++;
                    }

                    if(success == bandage[0]){
                        success = 0;
                        if(health + bandage[2] >= max){
                            health = max;
                        }
                        else if(health + bandage[2] < max){
                            health += bandage[2];
                        }
                    }
                }

                if(health <= 0) return -1;
            }
            return health;
        }
    }
}
