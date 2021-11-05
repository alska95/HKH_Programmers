class Solution {
    public int[] solution(int brown, int yellow) {
        int [] answer = new int[2];
        for(int i =1 ; i <= yellow/2+1 ; i++){
            if(yellow % i == 0){
                int width = 1;
                int height = 1;
                if(yellow/i > i){
                    width = yellow/i;
                    height = i;
                }else{
                    width = i;
                    height = yellow/i;
                }
                int result = width*2 + height*2 +4;
                if(result == brown){
                    answer[0] = width+2;
                    answer[1] = height+2;
                }
            }
        }
        return answer;
    }
}