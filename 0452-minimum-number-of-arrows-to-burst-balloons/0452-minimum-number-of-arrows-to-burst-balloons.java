class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]){
                if(a[1] > b[1]) return 1;
                else{
                    return -1;
                }
            }else if(a[0] > b[0]){
                return 1;
            }
            else{
                return -1;
            }
        });
        int xstart_max = points[0][0];
        int xend_min = points[0][1];
        int arrows = 1;

        for(int i = 1; i<points.length; i++){
            int[] p = points[i];
            if(p[0] > xend_min){
                arrows++;
                xstart_max = p[0];
                xend_min = p[1];
            }
            else{
                xstart_max = Math.max(xstart_max, p[0]);
                xend_min = Math.min(xend_min, p[1]);
            }
        }

        return arrows;
    }
}