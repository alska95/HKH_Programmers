import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int j = 0;
        for(int i = people.length-1 ; i >= j ; i--){
            if(people[i] + people[j] <= limit){
                j++;
            }
            count++;
        }
        return count;
    }
}