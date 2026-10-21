class Solution {
    public boolean calc(int i, int cS, int[] nums, Boolean[][] dp){
        if(cS == 0) return true;
        if(cS<0 || i<0) return false;
        if(dp[i][cS] != null) return dp[i][cS];

        boolean res = false;
        if(nums[i]<=cS){
            res = calc(i-1, cS-nums[i], nums, dp);
        }

        res = res || calc(i-1, cS, nums, dp);
        return dp[i][cS] = res;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        // dp = new boolean[target + 1];
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return calc(nums.length-1, target, nums, dp);
    }
}