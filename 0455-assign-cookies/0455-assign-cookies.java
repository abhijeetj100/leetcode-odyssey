class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gp = 0, sp = 0, count = 0;

        while(gp<g.length && sp < s.length){
            // while(sp<s.length && s[sp] < g[gp]){
            //     sp++;
            // }

            // if(sp == s.length) break;
            // count++;
            // gp++;
            // sp++;

            // Smart(er) or rather shorter loop
            if(s[sp]>=g[gp]){
                gp++;
            }

            sp++;
        }
        

        // return count;
        return gp;
    }
}