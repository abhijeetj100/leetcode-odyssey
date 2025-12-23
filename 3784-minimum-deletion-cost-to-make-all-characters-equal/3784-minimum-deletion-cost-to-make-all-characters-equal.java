class Solution {
    public long minCost(String s, int[] cost) {
        long sum = 0;
        long max = 0;
        HashMap<Character, Long> hm = new HashMap<>();
        char[] carr = s.toCharArray();

        for(int i = 0; i<carr.length; i++){
            long val = hm.getOrDefault(carr[i], 0l);
            hm.put(carr[i], val+cost[i]);
            sum += cost[i];
            max = Math.max(max, hm.get(carr[i]));
        }

        return sum-max;
            
    }
}