class Solution {
    public int maxArea(int[] height) {
        int pl = 0, pr = height.length-1;
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int water = 0;

        while(pl<pr){
            lmax = Math.max(lmax, height[pl]);
            rmax = Math.max(rmax, height[pr]);

            int h = Math.min(lmax, rmax);
            int w = pr-pl;
            int area = h*w;
            water = Math.max(water, area);

            if(lmax<=rmax) pl++;
            else pr--;
        }

        return water;
    }
}