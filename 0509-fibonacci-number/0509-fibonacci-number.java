class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        int one = 0;
        int two = 1;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, 0);
        // dp[1] = 1;

        for(int i = 2; i<=n; i++){
            int temp = two;
            two = two+one;
            one = temp;
            // dp[i] = dp[i-1]+dp[i-2];
        }

        return two;

    }
}