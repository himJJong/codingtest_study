import java.util.*;
public class pro_개인정보{
    public static void main(String[] args) {
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Solution.solution("2022.05.19", terms, privacies));
    }

    static class Solution {
        public static int[] solution(String today, String[] terms, String[] privacies) {
            HashMap<String, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            String[] todayList = today.split("\\.");
            int todayYear = Integer.parseInt(todayList[0]);
            int todayMonth = Integer.parseInt(todayList[1]);
            int todayDay = Integer.parseInt(todayList[2]);

            for(int i=0; i<terms.length; i++){
                String[] tmp = terms[i].split(" ");
                map.put(tmp[0], Integer.parseInt(tmp[1]));
            }

            for(int i=0; i<privacies.length; i++){
                String[] date = privacies[i].split(" ");
                String[] check = date[0].split("\\.");

                int year = Integer.parseInt(check[0]);
                int month = Integer.parseInt(check[1]) + map.get(date[1]);
                int day = Integer.parseInt(check[2]);

                if(month > 12){
                    if(month % 12 == 0){
                        year += (month/12-1);
                        month = 12;
                    }
                    else{
                        year += month/12;
                        month = month%12;
                    }
                }

                if(day == 1){
                    if(month == 1){
                        year--;
                        month = 12;
                        day = 28;
                    }
                    else{
                        month--;
                        day = 28;
                    }
                }
                else{
                    day--;
                }
                System.out.println(year);
                System.out.println(month);
                System.out.println(day);
                if(todayYear > year){
                    list.add(i);
                }
                else if(todayYear == year){
                    if(todayMonth > month){
                        list.add(i);
                    }
                    else if(todayMonth == month){
                        if(todayDay > day){
                            list.add(i);
                            continue;
                        }
                    }
                }
            }

            int[] answer = new int[list.size()];
            for(int i=0; i<answer.length; i++){
                answer[i] = list.get(i)+1;
            }
            return answer;
        }
    }
}
