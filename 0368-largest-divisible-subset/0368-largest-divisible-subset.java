class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int maxLen = 0;
        int maxIndex = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[i]%nums[j] == 0){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        parent[i] = j;
                    }
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while(maxIndex != -1){
            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        return result;
    }
}