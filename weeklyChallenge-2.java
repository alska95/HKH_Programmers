class Solution {
    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int n = scores.length;
        boolean flag = true;

        for (int i=0;i<n;i++) {
            // 자신이 자기를 평가한 점수
            int self = scores[i][i];
            int sum = 0;
            int max = -1; int min = 101;
            for (int j=0;j<n;j++) {
                sum += scores[j][i]; // 나의 점수를 합산
                max = Math.max(max, scores[j][i]); // 최대값 갱신
                min = Math.min(min, scores[j][i]); // 최소값 갱신
            }
            // 최대값 혹은 최소값이 내가 평가한 나의 점수라면 해당 점수와 같은 점수가 몇 개 있는 지를 저장
            int cnt = 0;
            // 자기자신이 평가한 점수가 최소 or 최대값인 경우
            if (self == min || self == max) {
                flag = false;
                for (int k=0;k<n;k++) {
                    // 만약 같은 점수가 있다면 카운팅 (자기 자신이 나올테니 최소 1)
                    if (scores[k][i] == self) cnt++;
                }
            }
            int avg = 0;
            // 자기자신의 점수가 최대or최소값이지만 동일한 점수로 다른 사람이 평가한 점수가 있는 경우
            if (!flag && cnt >= 2) avg = sum/n; // 평범하게 평균값을 얻어옴
                // 자기자신의 점수가 최대or최소값이고 자신의 점수가 유일한 경우
            else if (!flag && cnt==1) {
                sum-=self; // 자신의 점수는 총점에서 빼고 평균을 계산
                avg = sum/(n-1);
            } // 자기자신의 점수가 최대or최소값이 아닌 경우
            else avg = sum/n;

            switch(avg/10) {
                case 9: sb.append("A");break;
                case 8: sb.append("B");break;
                case 7: sb.append("C");break;
                case 6:
                case 5: sb.append("D");break;
                default: sb.append("F");break;
            }

        }
        return sb.toString();
    }
}