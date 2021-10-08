import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> resultSet = new HashMap<>();
        for(int i = 0 ; i < clothes.length ; i++){
            if(resultSet.containsKey(clothes[i][1])){
                resultSet.put(clothes[i][1], resultSet.get(clothes[i][1])+1);
            }else{
                resultSet.put(clothes[i][1], 1);
            }
        }
        int answer = 1;
        for(String key : resultSet.keySet()){
            answer *= resultSet.get(key)+1;
        }

        return answer-1;
    }
}