import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a,b) -> {
            if(a[1] - b[1] == 0){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        
        int end = -1;
        
        for(int[] x : targets){
            if(x[0] >= end){
                answer++;
                end = x[1];
            }
        }
        return answer;
    }
}