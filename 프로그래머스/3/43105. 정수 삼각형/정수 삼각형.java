import java.util.*;

class Solution {
    private static int row;
    private static int col;
    private static int[][] dp;
    
    public int solution(int[][] triangle) {
        row = triangle.length;
        col = triangle[row-1].length;
        
        dp = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        
        // dp[0][0] = triangle[0][0];
        
        return recur(0,0, triangle);
        
    }
    
    public int recur(int r, int c, int[][] tri){
        if(r == row - 1){
            return tri[r][c];
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        dp[r][c] = Math.max(recur(r+1, c, tri) + tri[r][c], recur(r+1, c+1, tri) + tri[r][c]);
        
        return dp[r][c];
              
    }
}