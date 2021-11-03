class Solution {
    int [] visited;
    int count = 0;
    
    public void combination(int n , int r , int start , int [] numbers , int target){
        if(r == 0){
            int result = 0;
            int [] tmpNum = new int[numbers.length];
            for(int i = 0 ; i < n; i++){
                if(visited[i] == 1){
                    result -= numbers[i];
                }else{
                    result += numbers[i];
                }
            }
            if(result == target){
                
                // for(int j = 0 ; j < numbers.length ; j++){
                //     System.out.printf(visited[j]+ " ");
                // }
                // System.out.println();
                count++;
            }

            return;
        }
        for(int i = start ; i < n ; i++){
            visited[i] = 1;
            combination(n , r-1 , i+1 , numbers , target);
            visited[i] = 0;
        }
    }
    public int solution(int[] numbers, int target) {
  
        visited = new int[numbers.length];
        for(int i = 0 ; i <= numbers.length ;i++){
            combination(numbers.length, i, 0 , numbers, target);
        }

        return count;
    }
}