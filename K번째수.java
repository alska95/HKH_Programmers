import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) { //
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < commands.length ; i++){
            int [] targetArray = Arrays.copyOfRange(array , commands[i][0]-1 , commands[i][1]);
            Arrays.sort(targetArray);
            ans.add(targetArray[commands[i][2]-1]);
        }
        int[] answer = new int[ans.size()];
        for (int i = 0 ; i < ans.size() ; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}