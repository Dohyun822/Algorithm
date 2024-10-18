import java.util.*;

class Solution {
    private static int row;
    private static int col;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        row = n;
        col = m;

        // DP 테이블과 방문 여부 테이블 초기화
        map = new int[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];

        // 물에 잠긴 지역 표시
        for (int i = 0; i < puddles.length; i++) {
            visited[puddles[i][1]][puddles[i][0]] = true;
        }

        // 시작점 초기화
        map[1][1] = 1;

        // 최종 경로 개수를 계산하여 반환
        return recur(row, col);
    }

    public int recur(int r, int c) {
        // 범위를 벗어나거나 물에 잠긴 지역이면 경로 수는 0
        if (r < 1 || c < 1 || visited[r][c]) {
            return 0;
        }

        // 이미 계산된 값이 있으면 그 값을 반환
        if (map[r][c] > 0) {
            return map[r][c];
        }

        // 위에서 내려오는 경로 + 왼쪽에서 오는 경로를 더함
        map[r][c] = (recur(r - 1, c) + recur(r, c - 1)) % MOD;

        return map[r][c];
    }
}
