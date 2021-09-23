class Solution {
    public long solution(int price, int money, int count) {
        long fee = 0;
        for(int i = 1 ; i <= count ; i++){
            fee+= i*price;
        }
        long answer = fee-money;
        if(answer < 0)
            answer = 0;
        return answer;
    }
}