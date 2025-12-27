class Solution {
    public int[] dp = new int[1001];
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(dp, -1);

        dp[cost.length] = climb(cost, cost.length);

        return dp[cost.length];
    }

    public int climb(int[] cost, int n){

        if(n<=1) return 0;

        if(dp[n] != -1) return dp[n];

        dp[n] = Math.min(climb(cost, n-1)+cost[n-1], climb(cost, n-2)+cost[n-2]);

        return dp[n];
    }
}