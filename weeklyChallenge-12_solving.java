/**
항상 최소 피로도 던전을 돈다?
80 / 70이랑
79 / 1이 있을때
피로도가 80이라면
    던전을 돌았을때 못돌게 되는 던전 중 돌 수 있었던 던전의 수?

*/

class Solution {
    public int solution(int k, int[][] dungeons) {
        int result = 0;
        int curP = k;
        while(true){
            int nonCount = 0;
            for(int i = 0 ; i < dungeons.length ; i++){
                if(dungeons[i][0] <= curP)
                    nonCount++;
            }
            if(nonCount == 0)
                break;
            result++;
            int nonCount2 = 0;
            int curP2 = curP;
            int []getMin = new int[100];
            for(int i = 0 ; i < 100 ; i++){
                getMin[i] = Integer.MAX_VALUE;
            }
            for(int i = 0 ; i < dungeons.length ; i++){
                nonCount2 = 0;
                curP2 = curP;
                if(dungeons[i][0] <= curP){
                    curP2-= dungeons[i][1];
                    for(int j = 0 ; j < dungeons.length ; j++){
                        if(dungeons[j][0] <= curP2){
                            nonCount2++;
                        }
                    }                
                }
                getMin[i] = nonCount - nonCount2;
            }
            int target = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < dungeons.length ; i++){
                if(min <= getMin[i]){
                    min = getMin[i];
                    target = i;
                }
            }
            curP-=dungeons[target][1];
        }
        return result;
    }
}