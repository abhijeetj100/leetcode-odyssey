class Solution {
    public int mirrorDistance(int n) {
        if(n<10) return 0;
        int rev = n;
        Queue<Integer> q = new LinkedList<>();

        while(rev > 0){
            q.add(rev%10);
            rev/=10;
        }

        rev = 0;
        while(q.size()>0){
            rev = rev*10+q.poll();
        }

        return Math.abs(rev-n);
    }
}