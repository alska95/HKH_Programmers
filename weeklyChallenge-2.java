class Solution {
    static String answer;
    public static void getGrade(double avg){
        StringBuilder sb = new StringBuilder();
        System.out.println("before = " + avg);
        int key = (int) avg/10;
        switch(key){
            case 10:
            case 9:
                answer += "A";
                break;
            case 8:
                answer += "B";
                break;
            case 7:
                answer += "C";
                break;
            case 6:
            case 5:
                answer += "D";
                break;
            default:
                answer += "F";
                break;

        }
    }
    public String solution(int[][] scores) {
        answer = "";
        for(int i = 0 ; i < scores.length ; i++){
            int min[] = new int[]{Integer.MAX_VALUE, 0};
            int minTmp[] = new int[2];
            int max[] = new int[]{Integer.MIN_VALUE, 0};
            int maxTmp[]= new int[2];
            for(int j = 0 ; j < scores.length ; j++){
                if(scores[i][j] == min[0]){
                    min[1] = 1;
                }
                if(scores[i][j] == max[0]){
                    max[1] = 1;
                }
                if(scores[i][j] < min[0]){
                    min[0] = scores[i][j];
                    min[1] = 0;
                    minTmp = new int[]{i, j};
                }
                if(scores[i][j] >max[0]){
                    max[0] = scores[i][j];
                    min[1] = 0;
                    maxTmp = new int[]{i, j};
                }
            }
            if(min[1] == 0 && minTmp[0] == minTmp[1]){
                scores[minTmp[0]][minTmp[1]] = -1;
            }
            if(max[1] == 0 && maxTmp[0] == maxTmp[1]){
                scores[maxTmp[0]][maxTmp[1]] = -1;
            }
        }
        for(int i = 0 ; i < scores.length; i++){
            int counter = scores.length;

            int sum = 0;
            for(int j = 0 ; j < scores.length;j++){
                if(i == j){
                    if(scores[j][i] == -1){
                        counter--;
                        continue;
                    }
                    sum+=scores[j][i];
                }
                else{
                    sum+= scores[j][i];
                }
            }
            System.out.println("counter = " + counter);
            System.out.println("sum = " + sum);
            getGrade((double) sum/counter);
        }
        return answer;
    }
}