import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l]; // 방문 여부 체크 배열

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startX, startY, endX, endY, l, visited));
        }
    }

    public static int bfs(int x, int y, int endX, int endY, int l, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int curCount = current[2];

            if (curX == endX && curY == endY) {
                return curCount;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < l && nextY < l && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY, curCount + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }
}