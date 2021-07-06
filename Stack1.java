package com.company;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> result = new LinkedList<>();
        int counter = 1;
        for(int i = 0 ; i < progresses.length ; i++){
            while(true){
                if(progresses[i] + speeds[i]*counter >= 100){
                    result.add(counter);
                    break;
                }
                counter++;
            }
        }
        for(int i : result){
            System.out.println(i);
        }
        int ans = 1;
        int tmp = result.poll();
        ArrayList<Integer> Ans = new ArrayList<>();
        while(!result.isEmpty()){
            System.out.println("tmp = " + tmp + " peek = " + result.peek());
            if(tmp == result.peek()){
                System.out.println(result.peek());
                result.poll();
                ans++;
            }else{
                Ans.add(ans);
                tmp = result.poll();
                ans = 1;
            }
        }
        Ans.add(ans);

        int[] answer = new int[Ans.size()];
        for(int i = 0 ; i < Ans.size() ; i++){
            answer[i] = Ans.get(i);
        }

        return answer;
    }
}