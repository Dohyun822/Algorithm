import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int[] dr = {0, 0, 1, -1};
    final static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            int count = 0;
            boolean[][] visited = new boolean[N][M];

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (iceberg[i][j] > 0 && !visited[i][j]) {
                        count++;
                        if (count > 1) {
                            System.out.println(years);
                            return;
                        }
                        dfs(i, j, visited, iceberg);
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }

            melt(iceberg);
            years++;
        }
    }

    private static void dfs(int x, int y, boolean[][] visited, int[][] iceberg) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];
            if (nx >= 0 && nx < iceberg.length && ny >= 0 && ny < iceberg[0].length && !visited[nx][ny] && iceberg[nx][ny] > 0) {
                dfs(nx, ny, visited, iceberg);
            }
        }
    }

    private static void melt(int[][] iceberg) {
        int[][] melting = new int[iceberg.length][iceberg[0].length];
        for (int i = 1; i < iceberg.length - 1; i++) {
            for (int j = 1; j < iceberg[0].length - 1; j++) {
                if (iceberg[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dr[k];
                        int ny = j + dc[k];
                        if (nx >= 0 && nx < iceberg.length && ny >= 0 && ny < iceberg[0].length && iceberg[nx][ny] == 0) {
                            melting[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < iceberg.length - 1; i++) {
            for (int j = 1; j < iceberg[0].length - 1; j++) {
                iceberg[i][j] = Math.max(iceberg[i][j] - melting[i][j], 0);
            }
        }
    }
}
