import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        ArrayList<String> strNumbers = new ArrayList();
        for(Integer num : numbers){
            strNumbers.add(String.valueOf(num));
        }

        Collections.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if(strNumbers.get(0).startsWith("0")) return "0";

        for(String s : strNumbers){
            answer += s;
        }
        return answer;
    }
}