class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int last = -1;
        int ptr = 0, n = s.length(), width = 0;

        for(int i = 0; i<n; i++){
            hm.put(s.charAt(i), i);
        }

        width = hm.get(s.charAt(0));

        while(ptr<n){
            width = Math.max(width, hm.get(s.charAt(ptr)));
            if(ptr == width){
                res.add(ptr-last);
                last = ptr;
            }
            ptr++;
        }

        return res;
    }
}