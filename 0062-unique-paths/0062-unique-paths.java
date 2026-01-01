class Solution {
    public int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(m-1, n-1);
    }

    public int solve(int x, int y){
        if(x == 0 || y == 0) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = solve(x-1, y) + solve(x, y-1);
        return dp[x][y];
    }
}