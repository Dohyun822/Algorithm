import java.util.*;

class Solution {
    private static int answer;
    private static int n;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        n = numbers.length;
        
        recur(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void recur(int[] numbers, int target, int cur, int idx){
        if(idx > n){
            return;
        }
        if(idx == n){
            if(cur == target){
                answer++; 
            }
            return;
        }
        
        recur(numbers, target, cur + numbers[idx], idx+1);
        recur(numbers, target, cur - numbers[idx], idx+1);
    }
}