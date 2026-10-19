class Solution {
    public int calculateMinimumHP(int[][] g) {
        int n = g.length;
        int m = g[0].length;

        // Size (n + 1) x (m + 1) to eliminate boundary checks
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Base cases: entering the target cell needs at least 1 HP upon arrival
        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minNext = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minNext - g[i][j]);
            }
        }

        return dp[0][0];
    }
}