import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int H;
    private static boolean[][] ladder;
    private static int result = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); // 세로선 개수
        M = Integer.parseInt(st.nextToken()); // 가로선 개수
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치의 수

        ladder = new boolean[H + 1][N + 1]; // 가로선 정보 저장

        // 가로선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        // 백트래킹으로 가로선 추가
        for (int i = 0; i <= 3; i++) {
            dfs(0, i);
            if (result != 4) {
                System.out.println(result);
                return;
            }
        }
        System.out.println(-1);
    }

    // 백트래킹으로 가로선 추가하기
    private static void dfs(int count, int max) {
        if (count == max) {
            if (check()) {
                result = Math.min(result, max);
            }
            return;
        }

        // 가로선을 추가할 위치 탐색
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (ladder[i][j] || ladder[i][j + 1] || (j > 1 && ladder[i][j - 1])) continue;
                ladder[i][j] = true;
                dfs(count + 1, max);
                ladder[i][j] = false;
            }
        }
    }

    // 사다리 게임 결과 확인
    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int j = 1; j <= H; j++) {
                if (pos < N && ladder[j][pos]) {
                    pos++;
                } else if (pos > 1 && ladder[j][pos - 1]) {
                    pos--;
                }
            }
            if (pos != i) return false;
        }
        return true;
    }
}
