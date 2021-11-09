import java.util.*;

class Solution {
      public static String solution(String number, int k) {
       int now = 0;
       String answer = "";
       StringBuilder sb = new StringBuilder();
       int len = number.length() -k;
       int tmp_now = 0;
       for(int i=0; i<len; i++) {
           int max = 0;
           for(int j=now; j<=i+k; j++) {
               int tmp_num = number.charAt(j)-'0';
               if(max < tmp_num) {
                   tmp_now = j;
                   max = tmp_num;
               }
           }
           sb.append(max);
           now = tmp_now+1;
       }
       answer = sb.toString();
       return answer;
   }
}