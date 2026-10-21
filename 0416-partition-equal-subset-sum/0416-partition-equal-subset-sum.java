class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            if(dp[target] == true) return true;
        }

        return dp[target];
    }
}