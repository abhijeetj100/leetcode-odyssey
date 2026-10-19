class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] g) {
        int n = g.length;
        int m = g[0].length;

        dp = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], 1);
        }

        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                if(i == n-1 && j == m-1){
                    dp[i][j] = Math.max(1, 1-g[i][j]);
                }
                else if(i == n-1){
                    dp[i][j] = Math.max(1, dp[i][j+1] - g[i][j]);
                }
                else if(j == m-1){
                    dp[i][j] = Math.max(1, dp[i+1][j] - g[i][j]);
                }
                else{
                    dp[i][j] = Math.max(1, Math.min(dp[i][j+1], dp[i+1][j]) - g[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}