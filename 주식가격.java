import java.util.ArrayList;

class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < prices.length; i++){
            int counter = 0;
            for(int j = i+1 ; j < prices.length ; j++){
                counter++;
                if(prices[i] > prices[j])
                    break;
            }
            result.add(counter);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}