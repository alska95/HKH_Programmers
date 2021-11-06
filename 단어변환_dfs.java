
/*
하나만 바꾸고 통과할 수 있는 조건
*/
class Solution {
    
    int min = Integer.MAX_VALUE;
    int[] visited;
    public int solution(String begin, String target, String[] words) {
        
        visited = new int[words.length];
        dfs(begin, words, target , 0);
        if(min == Integer.MAX_VALUE)
            min = 0;
        return min;
    }
    
    public void dfs(String cur , String[] words , String target , int count){
        if(cur.equals(target)){
            min = Math.min(min, count);
            return;
        }
        
        for(int i = 0 ; i < words.length ; i++){

            for(int j = 0 ; j < words[i].length() ; j++){ //j번째를 바꿈
            int validFlag = 0;                
                for(int k  =0 ; k < words[i].length() ; k++){ //
                        if(j == k)
                            continue;
                        if(cur.charAt(k) != words[i].charAt(k)){
                            validFlag = 1;
                            break;
                    }
                }
            if(validFlag == 0 && visited[i] == 0){
                visited[i] = 1;
                dfs(words[i] , words , target , count+1);
                visited[i] = 0;
            }
            }

        }
    }
}