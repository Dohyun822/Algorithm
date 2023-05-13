public class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.abs(r - i) + Math.abs(c - j);
            }
        }

        if (dp[x][y] > k || dp[x][y] % 2 != k % 2) {
            return "impossible";
        }

        int nr = x, nc = y, nk = k;
        StringBuilder answer = new StringBuilder();

        while (nk > 0) {
            int[] result = go(nr, nc, nk, dp, n, m);
            nr = result[0];
            nc = result[1];
            nk = result[2];
            answer.append((char)result[3]);
        }

        return answer.toString();
    }

    private int[] go(int nr, int nc, int nk, int[][] dp, int n, int m) {
        if (nr+1 <= n && dp[nr+1][nc] <= nk-1) {
            return new int[] {nr+1, nc, nk-1, 'd'};
        }
        if (nc-1 >= 1 && dp[nr][nc-1] <= nk-1) {
            return new int[] {nr, nc-1, nk-1, 'l'};
        }
        if (nc+1 <= m && dp[nr][nc+1] <= nk-1) {
            return new int[] {nr, nc+1, nk-1, 'r'};
        }
        if (nr-1 >= 1 && dp[nr-1][nc] <= nk-1) {
            return new int[] {nr-1, nc, nk-1, 'u'};
        }
        return null;
    }
}
