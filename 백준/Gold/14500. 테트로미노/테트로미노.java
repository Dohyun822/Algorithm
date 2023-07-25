import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxValue = 0;
    static int[][] board;
    static boolean[][] visited;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;
                exce(i, j);
            }
        }

        System.out.println(maxValue);
    }

    static void dfs(int i, int j, int dsum, int cnt) {
        if (cnt == 4) {
            maxValue = Math.max(maxValue, dsum);
            return;
        }
        for (int n = 0; n < 4; n++) {
            int ni = i + move[n][0];
            int nj = j + move[n][1];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj]) {
                visited[ni][nj] = true;
                dfs(ni, nj, dsum + board[ni][nj], cnt + 1);
                visited[ni][nj] = false;
            }
        }
    }

    static void exce(int i, int j) {
        for (int n = 0; n < 4; n++) {
            int temp = board[i][j];
            for (int k = 0; k < 3; k++) {
                int t = (n + k) % 4;
                int ni = i + move[t][0];
                int nj = j + move[t][1];
                if (!(ni >= 0 && ni < N && nj >= 0 && nj < M)) {
                    temp = 0;
                    break;
                }
                temp += board[ni][nj];
            }
            maxValue = Math.max(maxValue, temp);
        }
    }
}
