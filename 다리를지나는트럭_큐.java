import java.util.*;


class Solution {
    static class Truck{
        int weight = 0;
        int position = 0;
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> startQ = new LinkedList<>();
        for(int i = 0 ; i < truck_weights.length ; i++){
            Truck truck = new Truck();
            truck.weight = truck_weights[i];
            startQ.add(truck);
        }
        int time = 0;
        int totalWeight = 0;
        ArrayList<Truck> processList = new ArrayList<>();
        Queue<Truck> endQ = new LinkedList<>();
        while(endQ.size() != truck_weights.length){
            if(!startQ.isEmpty()){
                Truck cur = startQ.peek();
                if(weight >= totalWeight + cur.weight){
                    totalWeight += cur.weight;
                    processList.add(startQ.poll());
                }
            }

            for(int i = 0 ; i < processList.size() ; i++){
                Truck target = processList.get(i);
                target.position++;
            }
            if(!processList.isEmpty())
                if(processList.get(0).position >= bridge_length){
                     Truck tmp = processList.remove(0);
                     totalWeight -= tmp.weight;
                                                       
                      endQ.add(tmp);

                }

            time++;
        }
        return time+1;
    }
}