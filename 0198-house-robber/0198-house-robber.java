class Solution {
    public int[] dp = new int[100];
    public int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return solve(nums, nums.length-1);
    }

    public int solve(int[] nums, int n){
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n] != -1) return dp[n];

        dp[n] = Math.max(solve(nums, n-2)+nums[n], solve(nums, n-1));
        return dp[n];
    }
}