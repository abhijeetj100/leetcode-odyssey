class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        long score = 0;
        PriorityQueue<Integer> hp = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<nums.length; i++){
            hp.add(nums[i]);
            if(s.charAt(i) == '1'){
                score += hp.poll();
            }
        }

        return score;
        
    }
}