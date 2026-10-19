class Solution {
    // int f(int i){
    //     if(i == 0 || i == 1) return 1;

    // }
    public int numTrees(int n) {
        if(n<=1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            int x = 0, y = i-1;
            int ans = 0;
            while(x<i){
                ans+=dp[x++]*dp[y--];
            }
            dp[i] = ans;
        }

        return dp[n];
    }
}