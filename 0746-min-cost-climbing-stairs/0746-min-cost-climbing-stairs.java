class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return findcost(n, cost);
        
    }

    public int findcost(int i, int[] cost){
        if(i <= 1) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = Math.min(findcost(i-1, cost) + cost[i-1], findcost(i-2, cost) + cost[i-2]);

        return dp[i];
    }
}