
import java.util.Stack;

class Solution {
    public int solution(int n, int[][] computers) {

        boolean [] visited = new boolean[n];
        Stack<Integer> dfsStack = new Stack<>();

        int answer = 0 ;
        for(int z = 0 ; z < n ; z++){
            if(visited[z] == false){
                answer++;
                System.out.println(answer);
                visited[z] = true;
                dfsStack.add(z);
                while(!dfsStack.empty()){
                    int current = dfsStack.pop();
                    for(int i = 0 ; i < n ; i++){
                        if(computers[current][i] == 1 && current != i && visited[i] == false){
                            dfsStack.add(i);
                            visited[i] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}