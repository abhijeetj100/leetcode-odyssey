class Solution {
    public void dfs(int[][] graph, int node, boolean[] visited){
        visited[node] = true;

        for(int i = 0; i<graph.length; i++){
            if(visited[i] == true || graph[node][i] == 0) continue;
            dfs(graph, i, visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);
        int count = 0;

        for(int i = 0; i<size; i++){
            if(visited[i] == false){
                count++;
                dfs(isConnected, i, visited);
            }
        }

        return count;
    }
}