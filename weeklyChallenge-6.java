/*복서 선수들의 번호를 다음과 같은 순서로 정렬한 후 return 하도록 solution 함수를 완성해주세요.

1. 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
2. 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
3. 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
4. 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.*/
import java.util.*;

//승률
//heavy win, light win
//weight
//number
class Solution {
    static class Status{
        int playerNum = 0;
        int heavyWin = 0;
        int lightWin = 0;
        int lose = 0;
        double rate = 0;
        int weight = 0;
    }
    public int[] solution(int[] weights, String[] head2head) {

        ArrayList<Status> resultList = new ArrayList<>();
        for(int i = 0 ; i < weights.length ; i++){
            Status status = new Status();
            status.playerNum = i+1;
            status.weight = weights[i];
            System.out.println("weight = " + status.weight);
            char[]results = head2head[i].toCharArray();
            for(int j = 0 ; j < results.length ; j++){
                if(results[j] == 'L'){
                    status.lose++;
                }
                if(results[j] == 'W'){
                    if(weights[i] < weights[j])
                        status.heavyWin++;
                    else
                        status.lightWin++;
                }
            }
            System.out.println("total win = " +  (status.heavyWin+status.lightWin));
            double total = (status.heavyWin+status.lightWin) + status.lose;
            int totalWin = (status.heavyWin+status.lightWin);
            if(totalWin == 0)
                status.rate = 0;
            else
                status.rate = totalWin/total*100;
            System.out.println("rate = " + status.rate);
            resultList.add(status);    
        }
        Collections.sort(resultList , new Comparator<Status>(){
            @Override
            public int compare(Status a, Status b){
                if(a.rate == b.rate){
                    if(a.heavyWin == b.heavyWin){
                        if(a.weight == b.weight){
                            return a.playerNum - b.playerNum;
                        }else{
                            return b.weight-a.weight;
                        }
                    }else{
                        return b.heavyWin - a.heavyWin;                        
                    }
                }else{
                     return (b.rate-a.rate) > 0 ? 1 : -1;
                }
            }
        });
        int[] answer = new int[resultList.size()];
        for(int i = 0 ; i < resultList.size() ; i++){
            answer[i] = resultList.get(i).playerNum;
        }
        return answer;
    }
}