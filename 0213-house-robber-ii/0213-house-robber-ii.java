class Solution {
    public int[] dp = new int[101];

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = 0;
        Arrays.fill(dp, -1);
        ans = solve(nums,0, nums.length-2);

        Arrays.fill(dp, -1);
        ans = Math.max(ans, solve(nums, 1, nums.length-1));
        return ans;
    }

    public int solve(int[] nums,int start, int n){
        if(n<start) return 0;

        if(dp[n] != -1) return dp[n];

        dp[n] = Math.max(solve(nums, start, n-2)+nums[n], solve(nums, start, n-1));
        return dp[n];
    }
}





// Mine

// class Solution {
//     public int[] dp = new int[101];

//     public int rob(int[] nums) {
//         if(nums.length == 1) return nums[0];
//         int ans = 0;
//         Arrays.fill(dp, -1);
//         ans = solve(nums, nums.length-1);
//         nums[0]= 0;
//         Arrays.fill(dp, -1);
//         ans = Math.max(ans, solve(nums, nums.length));
//         return ans;
//     }

//     public int solve(int[] nums, int n){
//         if(n<1) return 0;
//         if(n == 1) return nums[0];

//         if(dp[n] != -1) return dp[n];

//         dp[n] = Math.max(solve(nums, n-2)+nums[n-1], solve(nums, n-1));
//         return dp[n];
//     }
// }