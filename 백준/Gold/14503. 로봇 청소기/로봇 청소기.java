import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    // 방향 벡터 (북, 동, 남, 서)
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = clean(r, c, d);
        System.out.println(answer);
    }

    private static int clean(int r, int c, int d) {
        int cnt = 0;

        while (true) {
            if (!visited[r][c]) {
                visited[r][c] = true;
                cnt++;
            }

            boolean chk = true;

            // 주변 4칸 검사
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
                    d = nd;
                    r = nr;
                    c = nc;
                    chk = false;
                    break;
                } else {
                    // 반시계 방향으로 회전
                    d = nd;
                }
            }

            if (chk) {
                int back = (d + 2) % 4;
                int br = r + dr[back];
                int bc = c + dc[back];

                if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] == 0) {
                    r = br;
                    c = bc;
                } else {
                    break;
                }
            }
        }

        return cnt;
    }
}
