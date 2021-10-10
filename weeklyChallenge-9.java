/*
노드를 하나 끊어서 양쪽을 bfs돌리면 몇개씩 있는 지 알 수 있다.
1. 노드의 개수를 구하고,
2. 그만큼 배열 크기를잡고,
3. 노드 하나를 잡고 한쪽에 bfs를 돌려서 vertex숫자 구하고 나머지거에 빼준다.
4. 정답.
*/

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int size = wires.length;
        int minResult = Integer.MAX_VALUE;
        for(int except = 0 ; except < size ; except++){
            ArrayList<ArrayList<Integer>>board = new ArrayList<>();
            for(int i = 0 ; i < n+1 ; i++){
                board.add(new ArrayList<>());
            }
            for(int i = 0 ; i < size ; i++){
                if(i == except){
                    continue;
                }else{
                    int x = wires[i][0];
                    int y = wires[i][1];
                    board.get(x).add(y);
                    board.get(y).add(x);
                }
            }
            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.add(1);
            int visited[] = new int[n+1];
            while(!bfsQueue.isEmpty()){
                int cur = bfsQueue.poll();
                visited[cur] = 1;
                for(int i = 0 ; i < board.get(cur).size() ; i++){
                    int next = board.get(cur).get(i);
                    if(visited[next] == 0){
                        bfsQueue.add(next);
                    }
                }
            }
            int a = 0;
            int b = 0;
            for(int i = 1 ; i < n+1 ; i++){
                if(visited[i] == 1)
                    a++;
                else
                    b++;
            }
            int result = Math.abs(a-b);
            minResult = Math.min(result, minResult);
        }
        return minResult;
    }
}