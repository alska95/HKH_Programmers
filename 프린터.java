import java.util.ArrayList;


class Solution {
    public int solution(int[] priorities, int location) {
        priorities = new int[]{2, 1, 3, 2};
        location = 2;
        ArrayList<Integer> solver = new ArrayList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            solver.add(priorities[i]);
        }
        int iter = 0;
        while(!solver.isEmpty()){
            int tmp = solver.remove(0);
            if(location == 0){
                System.out.println("tmp = " + tmp);
                if(solver.stream().anyMatch(a-> a> tmp)){
                    solver.add(tmp);
                    location = solver.size()-1;
                }else{
                    iter++;
                    break;
                }
            }else{
                if(solver.stream().anyMatch(a-> a> tmp)){
                    solver.add(tmp);
                }else{
                    iter++;
                }
            }
            location--;
        }
        return iter;
    }
}