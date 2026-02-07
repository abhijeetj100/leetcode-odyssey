class Solution {
    static class Pair{
        int cost;
        int node;

        Pair(int n, int c){
            node = n;
            cost = c;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int cost = 0;

        PriorityQueue<Pair> mh = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        mh.add(new Pair(0, 0));

        while(!mh.isEmpty()){
            Pair p = mh.poll();

            if(visited[p.node]) continue;

            visited[p.node] = true;
            cost += p.cost;

            for(int i = 0; i<n; i++){
                if(visited[i]) continue;

                int dist = Math.abs(points[i][0] - points[p.node][0]) + Math.abs(points[i][1] - points[p.node][1]);
                mh.add(new Pair(i, dist));
            }
        }

        return cost;
        
    }
}