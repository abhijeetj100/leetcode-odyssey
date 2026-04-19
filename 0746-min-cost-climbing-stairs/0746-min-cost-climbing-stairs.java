class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return minCost(cost, n);
    }

    public int minCost(int[] cost, int index){
        if(index == 0 || index == 1) return 0;

        if(dp[index] != -1) return dp[index];

        int opt1 = minCost(cost, index-1) + cost[index-1];
        int opt2 = minCost(cost, index-2) + cost[index-2];

        dp[index] = Math.min(opt1, opt2);

        return dp[index];
    }
}