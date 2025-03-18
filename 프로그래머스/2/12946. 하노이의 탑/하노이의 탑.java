import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result);
        
        // List를 2차원 배열로 변환
        return result.toArray(new int[result.size()][]);
    }

    private void hanoi(int n, int start, int end, int aux, List<int[]> result) {
        if (n == 1) {
            result.add(new int[]{start, end});
            return;
        }

        // 1. n-1개 원판을 start → aux (보조 기둥 사용)
        hanoi(n - 1, start, aux, end, result);
        
        // 2. 가장 큰 원판을 start → end 이동
        result.add(new int[]{start, end});
        
        // 3. n-1개 원판을 aux → end (보조 기둥 사용)
        hanoi(n - 1, aux, end, start, result);
    }
}
