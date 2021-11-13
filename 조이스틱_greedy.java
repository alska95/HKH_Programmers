import java.util.*;

class Solution {
    public int solution(String name) {
        int result = 0;
        for(int i = 0 ; i < name.length() ; i++){
            int target = (int)name.charAt(i);
            if(target <=78){
                result += target-65;
            }else{
                result += 90-target+1;
            }
        }
        int min = name.length()-1;
        for(int i = 0  ; i < name.length() ; i++){
            int j = i+1;
            for( ; j < name.length() ; j++){
                if(name.charAt(j) != 'A')
                    break;
            }
            min = Math.min(i*2 +name.length()- j, min);
        }
        result += min;
        return result;
    }
}