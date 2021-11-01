/**
 걍 bfs
 */
import java.util.*;

class Solution {
    class Status{
        int fet;
        int count;
        int visited[];
        public Status(int fet, int count , int[] visited){
            this.fet = fet;
            this.count = count;
            this.visited =visited;
        }
    }
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        Queue<Status> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Status(k, 0 , new int[dungeons.length]));
        while(!bfsQueue.isEmpty()){
            Status cur = bfsQueue.poll();
            max = Math.max(cur.count, max);
            for(int i = 0 ; i < dungeons.length ; i++){
                if(cur.fet >= dungeons[i][0] & cur.visited[i] == 0){
                    int nextF = cur.fet -dungeons[i][1];
                    int nextCount = cur.count+1;
                    int [] v = new int[dungeons.length];
                    for(int j = 0 ; j < dungeons.length ; j++){
                        v[j] = cur.visited[j];
                    }
                    v[i] =1;
                    bfsQueue.add(new Status(nextF,nextCount,v));
                }
            }
        }
        return max;
    }
}