class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0, sn = s.length(), tn = t.length();

        while(p1 < sn && p2 < tn){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
            }
            p2++;
        }

        return p1 == sn;
    }
}