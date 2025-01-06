public class pro_동영상 {
    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String[] video = video_len.split(":");
            String[] cur = pos.split(":");
            String[] opStart = op_start.split(":");
            String[] opEnd = op_end.split(":");
            int videoTime = Integer.parseInt(video[0]) * 60 + Integer.parseInt(video[1]);
            int curTime = Integer.parseInt(cur[0]) * 60 + Integer.parseInt(cur[1]);
            int opStartTime = Integer.parseInt(opStart[0]) * 60 + Integer.parseInt(opStart[1]);
            int opEndTime = Integer.parseInt(opEnd[0]) * 60 + Integer.parseInt(opEnd[1]);

            for(int i=0; i<commands.length; i++){
                if(curTime >= opStartTime && curTime <= opEndTime){
                    curTime = opEndTime;
                }

                if(commands[i].equals("next")){
                    if(curTime + 10 >= videoTime){
                        curTime = videoTime;
                    }
                    else{
                        curTime += 10;
                    }
                }
                else{
                    if(curTime - 10 <= 0){
                        curTime = 0;
                    }
                    else{
                        curTime -= 10;
                    }
                }
            }
            if(curTime >= opStartTime && curTime <= opEndTime){
                curTime = opEndTime;
            }

            int hour = curTime / 60;
            int min = curTime % 60;

            if(hour < 10 && min < 10){
                return "0" + hour + ":" + 0 + min;
            }
            else if(hour < 10 && min >= 10){
                return "0" + hour + ":" + min;
            }
            else if(hour >=10 && min < 10){
                return hour + ":" + 0 + min;
            }
            else if(hour >=10 && min >= 10){
                return hour + ":" + min;
            }
            String answer = curTime/60 + ":" + curTime%60;
            return answer;
        }
    }
}
