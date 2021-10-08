import java.util.*;

class Solution {
    static class Songs{
        int index;
        int plays;
        int totalPlays;
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> songMap = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            if(songMap.containsKey(genres[i])){
                songMap.put(genres[i], songMap.get(genres[i])+plays[i]);
            }else{
                songMap.put(genres[i], plays[i]);
            }
        }
        ArrayList<Songs> resultList = new ArrayList<>();
        Map<Integer, ArrayList<Songs>> resultMap = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            Songs tmp = new Songs();
            tmp.totalPlays = songMap.get(genres[i]);
            tmp.plays = plays[i];
            tmp.index = i;

            if(resultMap.containsKey(tmp.totalPlays)){
                ArrayList<Songs> a = resultMap.get(tmp.totalPlays);
                a.add(tmp);
                resultMap.put(tmp.totalPlays , a);
            }else{
                ArrayList<Songs> a = new ArrayList<>();
                a.add(tmp);
                resultMap.put(tmp.totalPlays, a);
            }
        }
        for(Integer key : resultMap.keySet()){
            ArrayList<Songs> tmp = resultMap.get(key);
            Collections.sort(tmp, new Comparator<Songs>(){
                @Override
                public int compare(Songs a, Songs b){
                    return b.plays - a.plays;
                }
            });

            for(int i = 0 ; i < 2 ; i++){
                if(i >= tmp.size())
                    break;
                else{
                    resultList.add(tmp.get(i));
                }
            }

        }
        Collections.sort(resultList , new Comparator<Songs>(){
            @Override
            public int compare(Songs a, Songs b){
                if(a.totalPlays == b.totalPlays){
                    if(a.plays == b.plays){
                        return a.index - b.index;
                    }else{
                        return b.plays - a.plays;
                    }
                }else{
                    return b.totalPlays - a.totalPlays;
                }
            }
        });
        int[] answer = new int[resultList.size()];
        for(int i = 0 ; i < resultList.size() ; i++){
            answer[i] = resultList.get(i).index;
        }
        return answer;
    }
}