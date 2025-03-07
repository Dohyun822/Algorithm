class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1000000; // 충분히 큰 값
        int[] dp = new int[n]; // dp[a] : A가 a만큼 흔적을 남겼을 때 B의 최소 누적 흔적
        // 모든 상태를 INF로 초기화하고, 초기 상태 (0,0)를 0으로 설정
        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;
        
        // 각 물건에 대해 DP 업데이트
        for (int i = 0; i < info.length; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];
            int[] newDp = new int[n];
            for (int j = 0; j < n; j++) {
                newDp[j] = INF;
            }
            // 기존의 모든 상태에서 선택하기
            for (int a = 0; a < n; a++) {
                if (dp[a] < INF) {
                    // 1. A도둑이 맡는 경우: A의 흔적이 증가
                    if (a + aTrace < n) {
                        newDp[a + aTrace] = Math.min(newDp[a + aTrace], dp[a]);
                    }
                    // 2. B도둑이 맡는 경우: B의 흔적이 증가
                    if (dp[a] + bTrace < m) {
                        newDp[a] = Math.min(newDp[a], dp[a] + bTrace);
                    }
                }
            }
            dp = newDp;
        }
        
        // 가능한 상태 중 A의 흔적의 최소값 찾기
        for (int a = 0; a < n; a++) {
            if (dp[a] < m) {
                return a;
            }
        }
        return -1; // 두 도둑 모두 경찰에 붙잡히지 않는 방법이 없을 경우
    }
}
