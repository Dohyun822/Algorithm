import java.util.*;

class Solution {
    private static int answer;
    private static int len_col;
    private static int len_row;
    private static int[][] score;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};  // 상하좌우 탐색을 위한 배열
    private static int[] dc = {0, 0, -1, 1};  // 상하좌우 탐색을 위한 배열
    
    private static Stack<int[]> path;
    
    public int solution(int[][] land) {
        answer = 0;
        len_row = land.length;
        len_col = land[0].length;
        score = new int[len_row][len_col];
        

        // 각 열마다 시추관을 설치했을 때 최대 석유량 계산
        for (int c = 0; c < len_col; c++) {
            visited = new boolean[len_row][len_col];  // 방문 여부 배열 초기화
            int temp = 0;

            // 각 행마다 탐색
            for (int r = 0; r < len_row; r++) {
                if (!visited[r][c] && land[r][c] == 1 && score[r][c] == 0) {
                    path = new Stack<int[]>();
                    int jumsu = bfs(r, c, land);
                    temp += jumsu;  // BFS를 통해 연결된 석유 덩어리 크기 계산
                    for(int[] info : path){
                        score[info[0]][info[1]] = jumsu;
                    }
                }else{
                    temp += score[r][c];
                }
            }

            answer = Math.max(answer, temp);  // 최대값 갱신
        }

        return answer;
    }

    // BFS 탐색을 통한 석유 덩어리 크기 계산
    public int bfs(int r, int c, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        int cnt = 1;  // 첫 번째 방문한 석유칸을 포함하여 1로 시작

        // BFS 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                // 범위 체크 및 방문 여부 확인
                if (nr >= 0 && nr < len_row && nc >= 0 && nc < len_col && !visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    cnt++;  // 석유 덩어리 크기 증가
                }
            }
        }

        return cnt;  // 연결된 석유 덩어리 크기 반환
    }
}
