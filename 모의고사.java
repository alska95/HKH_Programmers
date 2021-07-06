import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int [] first = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int [] second = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int [] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int [] score = new int[3];
        for(int i = 0 ; i < answers.length ; i++){
            if(answers[i] == first[i%first.length]){
                score[0]++;
            }
            if(answers[i] == second[i%second.length]){
                score[1]++;
            }
            if(answers[i] == third[i%third.length]){
                score[2]++;
            }
        }
        int max = 0;
        for(int i = 0 ; i< score.length ; i++){
            if(score[i] > max){
                max = score[i];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < score.length ; i++){
            if(score[i] == max)
                ans.add(i);
        }
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            answer[i] = ans.get(i)+1;
        }

        return answer;
    }
}