import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Integer , Boolean> result = new HashMap<>();
    static boolean[] visited = new boolean[10];

    public int solution(String numbers) {
        StringBuilder myString = new StringBuilder("");
        for(int i = 1 ; i <= numbers.length() ; i++){
            permutation(0 , i , numbers , myString);
        }

        System.out.println(result.size());
        return result.size();
    }

    public void permutation(int depth ,int r , String numbers ,StringBuilder output){
        if(depth == r){
            System.out.println("output = " + output);
            isOdd(output);
            return;
        }
        for(int i = 0 ; i < numbers.length() ; i++){
            if(visited[i] == false){
                visited[i] = true;
                output.append(numbers.charAt(i));
                permutation(depth+1 , r , numbers ,output);
                output.deleteCharAt(depth);
                visited[i] = false;
            }
        }
    }

    public void isOdd(StringBuilder _target){
        int target= Integer.parseInt(String.valueOf(_target));
        if(target <2)
            return;
        for(int i = 2 ; i <= Math.sqrt(target) ; i++){
            if(target%i == 0){
                return;
            }
        }
        result.put(target , true);
        System.out.println("odd = " + target);
    }
}