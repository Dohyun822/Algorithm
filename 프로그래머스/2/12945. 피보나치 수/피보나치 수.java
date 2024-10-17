import java.util.*;

class Solution {
    private static int[] memo;
    
    public int solution(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);  // 메모 배열을 -1로 초기화
        return fibo(n);
    }
    
    public int fibo(int n) {
        if (n == 0) {
            memo[0] = 0;
            return 0;
        }
        if (n == 1) {
            memo[1] = 1;
            return 1;
        }
        if (memo[n] != -1) {  // 이미 계산된 값이면 바로 반환
            return memo[n] % 1234567;
        }
        
        // 메모이제이션: 값 계산 후 저장
        memo[n] = fibo(n - 1) + fibo(n - 2);
        return memo[n] % 1234567;
    }
}
