import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        ArrayList<String> tmp = new ArrayList<>();
        for (String s : phone_book) {
            tmp.add(s);
        }
        Collections.sort(tmp , (o1,o2)->o1.length() - o2.length());
        Map<String ,Integer> result = new HashMap<>();
        for(int i = 0 ; i < tmp.size() ; i++){
            for(int j = 0 ; j < tmp.get(i).length() ; j++){
                if(result.containsKey(tmp.get(i).substring(0,j+1)))
                    return false;
            }
            result.put(tmp.get(i) , 1);
        }
        return true;
    }
}
