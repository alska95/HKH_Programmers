/*
단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
*/
import java.util.*;


class Solution {
    public int solution(String word) {
        int answer = 0;
        Stack<String> dfsStack = new Stack<>();
        char charset [] = {'U','O','I','E','A'};
        dfsStack.add("");
        while(!dfsStack.isEmpty()){
            String cur = dfsStack.pop();

            if(cur.equals(word)){
                return answer;
            }
            answer++;   
            for(int i = 0; i < 5; i++){

                String next = cur+charset[i];
                if(cur.equals(word)){
                    return answer;
                }
                if(next.length() < 6){
                        dfsStack.add(next); 
                }
            }
        }
        return answer;
    }
}