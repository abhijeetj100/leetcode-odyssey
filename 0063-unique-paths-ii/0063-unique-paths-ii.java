class Solution {
    public int[][] dp;

    public int uniquePathsWithObstacles(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if(mat[0][0] == 1 || mat[m-1][n-1] == 1) return 0;
        dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(mat, m-1, n-1);
    }

    public int solve(int[][] mat, int x, int y){
        if(x<0 || y<0) return 0;
        if(mat[x][y] == 1) return 0;
        if(x == 0 && y == 0) return 1;

        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = solve(mat, x-1, y) + solve(mat, x, y-1);
        return dp[x][y];
    }
}