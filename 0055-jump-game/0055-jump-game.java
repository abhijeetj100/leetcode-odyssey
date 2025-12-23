class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int i = 0;
        while(i<nums.length){
            if(i>maxReach) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
            i++;
            
            // Optimization: if we can already reach the end, stop early
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}