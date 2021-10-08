import java.util.*;

/*
언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군을 return 하도록 solution 함수를 완성해주세요.

*/
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        int jobNum = table.length;
        int sumSkills [] = new int[table.length];
        for(int i = 0 ; i < table.length ; i++){
            String [] skills = table[i].split(" ");
            for(int j = 1 ; j < skills.length ; j++){
                for(int k = 0 ; k < languages.length ; k++){
                    if(languages[k].equals(skills[j])){
                        sumSkills[i] += preference[k]*(6-j);
                    }
                }
            }
        }
        ArrayList<Integer> maxIter = new ArrayList<>();
        int max =0;
        for(int i = 0 ; i < table.length ; i++){
            System.out.println("sum Skills = " + sumSkills[i]);
            if(sumSkills[i] == max){
                maxIter.add(i);
            }
            if(sumSkills[i] > max){
                maxIter.clear();
                maxIter.add(i);
                max = sumSkills[i];
            }

        }
        System.out.println("maxIter size = " + maxIter.size());
        ArrayList<String> resultList = new ArrayList<>();
        for(int i = 0 ; i< maxIter.size() ; i++){
             String tmp[] = table[maxIter.get(i)].split(" ");
             resultList.add(tmp[0]);
        }
        Collections.sort(resultList, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return a.compareTo(b);
            }
        });
        String answer = resultList.get(0);
        return answer;
    }
}