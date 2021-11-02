import java.util.*;

class Solution {
    PriorityQueue<ArrayList<String>> resultSet;
    int [] visited;
    public String[] solution(String[][] tickets) {
        
        resultSet = new PriorityQueue<>(new Comparator<ArrayList<String>>(){
            @Override
            public int compare(ArrayList<String> a , ArrayList<String> b){
                if(a.size() == b.size()){
                    for(int i = 0 ; i < a.size() ; i++){
                        if(a.get(i).compareTo(b.get(i)) == 0){
                            continue;
                        }else{
                            return a.get(i).compareTo(b.get(i));
                        }
                    }
                }else{
                    return b.size() - a.size();
                }
                return 0;
            }
        });
        visited = new int[tickets.length];
        for(int i = 0  ; i < tickets.length ; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = 1;
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add("ICN");
                tmp.add(tickets[i][1]);
                dfs(tickets[i] , tickets , tmp);
                visited[i] = 0;
            }
               
        }
        
        // while(!resultSet.isEmpty()){
        //     ArrayList<String> tmp = resultSet.poll();
        //     for( String a : tmp){
        //         System.out.println(a);
        //     }
        //     System.out.println(tmp.size());
        // }
        // String answer [] = new String[1];
        ArrayList<String> result = resultSet.poll();
        String[] answer = new String[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    
    public void dfs( String[] cur, String[][] tickets , ArrayList<String> route){
        for(int i = 0 ; i < tickets.length ; i++){
            if(cur[1].equals(tickets[i][0]) && visited[i] == 0){
                visited[i] = 1;
                route.add(tickets[i][1]);
                dfs(tickets[i], tickets , route);
                visited[i] = 0;
                route.remove(route.size()-1);
            }
            
                if(route.size() == tickets.length+1 ){
                    ArrayList<String> tmp = new ArrayList<>();
                    for(int j = 0 ; j < route.size() ; j++){
                        tmp.add(route.get(j));
                    }
                    // route.clear();
                    resultSet.add(tmp);
                    return;
                }
        }
    }
}