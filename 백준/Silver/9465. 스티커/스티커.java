import java.util.*;
import java.io.*;

public class Main {
    private static int T;
    private static int[][] map;
    private static int n;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[2][n]; // 스티커 점수 저장
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 배열 초기화 (dp[prev][col]로 사용)
            dp = new int[3][n];
            for(int[] row : dp) {
                Arrays.fill(row, -1); // 아직 계산되지 않은 상태는 -1로 초기화
            }

            // 최대 점수 출력
            System.out.println(recur(0, 0));
        }

    }

    private static int recur(int col, int prev) {
        if (col == n) { // 종료 조건: 열이 마지막에 도달했을 때
            return 0;
        }

        if (dp[prev][col] != -1) { // 이미 계산된 값이 있는 경우
            return dp[prev][col];
        }

        // 현재 선택지 계산
        int res = recur(col + 1, 0); // 아무것도 선택하지 않고 넘어가기

        if (prev != 1) { // 이전에 위쪽을 선택하지 않았으면, 이번에 위쪽 선택 가능
            res = Math.max(res, recur(col + 1, 1) + map[0][col]);
        }

        if (prev != 2) { // 이전에 아래쪽을 선택하지 않았으면, 이번에 아래쪽 선택 가능
            res = Math.max(res, recur(col + 1, 2) + map[1][col]);
        }

        // dp에 결과 저장
        dp[prev][col] = res;
        return res;
    }
}