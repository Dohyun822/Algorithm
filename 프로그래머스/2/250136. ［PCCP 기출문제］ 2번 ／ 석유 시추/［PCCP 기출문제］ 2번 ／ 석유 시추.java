import java.util.*;

class Solution {
    private static int row;
    private static int col;
    private static int[] dr = {-1, 1, 0, 0};  // 상하좌우 탐색용
    private static int[] dc = {0, 0, -1, 1};  // 상하좌우 탐색용
    private static int oilID = 0;  // 각 석유 덩어리에 부여할 고유 ID
    
    public int solution(int[][] land) {
        int answer = 0;
        
        row = land.length;
        col = land[0].length;
        
        boolean[][] visited = new boolean[row][col];
        int[][] score = new int[row][col];  // 각 위치에 석유 덩어리 크기 기록
        int[][] idMap = new int[row][col];  // 각 위치에 고유 ID 기록
        
        // 각 석유 덩어리의 크기와 고유 ID를 BFS로 계산
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    oilID++;  // 새로운 석유 덩어리 발견 시 고유 ID 증가
                    bfs(i, j, land, visited, score, idMap, oilID);
                }
            }
        }
        
        // 각 열에서 최대 석유량 계산
        for (int i = 0; i < col; i++) {
            int temp = 0;
            Set<Integer> addedIDs = new HashSet<>();  // 중복된 석유 덩어리 ID를 방지하기 위한 집합

            for (int j = 0; j < row; j++) {
                int currentID = idMap[j][i];
                if (currentID > 0 && !addedIDs.contains(currentID)) {
                    temp += score[j][i];  // 새로운 석유 덩어리일 때만 더해줌
                    addedIDs.add(currentID);  // 덩어리의 ID를 기록
                }
            }
            
            // 최대 석유량 갱신
            answer = Math.max(answer, temp);
        }
        
        return answer;
    }
    
    // BFS로 상하좌우로 연결된 석유 덩어리의 크기 및 ID 기록
    public void bfs(int r, int c, int[][] land, boolean[][] visited, int[][] score, int[][] idMap, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        
        List<int[]> path = new ArrayList<>();
        path.add(new int[] {r, c});
        
        int cnt = 1;  // 석유 덩어리 크기
        
        // BFS로 연결된 석유 덩어리 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    path.add(new int[] {nr, nc});
                    q.offer(new int[] {nr, nc});
                    cnt++;
                }
            }
        }
        
        // 탐색된 석유 덩어리의 크기와 고유 ID를 score와 idMap에 기록
        for (int[] pos : path) {
            score[pos[0]][pos[1]] = cnt;  // 덩어리 크기
            idMap[pos[0]][pos[1]] = id;   // 덩어리 고유 ID
        }
    }
}
