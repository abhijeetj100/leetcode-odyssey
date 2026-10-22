class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }

        int n = stones.length;
        boolean[][] dp = new boolean[n+1][sum/2+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }

        int s2 = 0;
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=sum/2; j++){
                if(dp[i-1][j] || (j>=stones[i-1] && dp[i-1][j-stones[i-1]]) ){
                    dp[i][j] = true;
                    s2 = Math.max(j, s2);
                }
            }
        }

        return sum - 2*s2;
    }
}