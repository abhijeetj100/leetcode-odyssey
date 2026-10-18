class Solution {
    public int find(int[][] dp, int[][] grid, int i, int j){
        if(grid[i][j] == 1) return 0;
        // if(i == 0 || j == 0) return ;
        if(i == 0 && j == 0) return 1;
        if(i == 0){
            return find(dp, grid, 0, j-1);
        }
        if(j == 0){
            return find(dp, grid, i-1, 0);
        }
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = find(dp, grid, i, j-1) + find(dp, grid, i-1, j);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        return find(dp, grid, m-1, n-1);
    }
}