class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        
        int r = 0;
        int c = 0;
        int num = 1;
        int dir = 0;
        
        for(int i = 1; i <= n * (n+1) / 2; i++){
            map[r][c] = num++;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if(nr >= n || nc >= n || nr < 0 || nc < 0 || map[nr][nc] != 0){
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            
            r = nr;
            c = nc;
        }
        
        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) { // 삼각형 부분만 가져오기
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}