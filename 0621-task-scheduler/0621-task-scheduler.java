class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        for(char ch:tasks){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        pq.addAll(hm.values());

        Queue<int[]> waitQueue = new LinkedList<>(); 
        
        while(pq.size() > 0 || waitQueue.size() > 0){
            time++;
            if(pq.size() > 0){
                int freq = pq.poll()-1;
                if(freq > 0) waitQueue.add(new int[]{freq, time+n});
            }
            if(waitQueue.size() > 0 && waitQueue.peek()[1] == time){
                pq.add(waitQueue.poll()[0]);
            }
        }

        return time;
    }
}