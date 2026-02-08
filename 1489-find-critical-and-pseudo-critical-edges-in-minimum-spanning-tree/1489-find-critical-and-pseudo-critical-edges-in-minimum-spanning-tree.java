class Solution {
    static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        // List<Integer> acceptedEdges = new ArrayList<>();

        DisjointSet(int n){
            for(int i = 0; i<n; i++){
                size.add(1);
                parent.add(i);
            }
        }

        public boolean isMST(){
            for(int i = 0; i<parent.size()-1; i++){
                if(this.findPar(i) != this.findPar(i+1)) return false;
            }
            return true;
        }

        // public boolean isEdgeAccepted(int[] edge){
        //     return acceptedEdges.contains(edge[3]);
        // }

        public int findPar(int node){
            if(node == parent.get(node)) return node;
            parent.set(node, findPar(parent.get(node)));
            return parent.get(node);
        }

        public int union(int[] edge){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(u == v) return 0;

            int pu = findPar(u);
            int pv = findPar(v);

            if(pu == pv) return 0;

            // acceptedEdges.add(edge[3]);

            if(size.get(pu) < size.get(pv)){
                parent.set(pu, pv);
                size.set(pv, size.get(pv) + size.get(pu));
            }
            else{
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
            return w;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    // boolean[] visited;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int[][] edgesWithIndex = new int[edges.length][4];
        for(int i = 0; i<edges.length; i++){
            edgesWithIndex[i][0] = edges[i][0];
            edgesWithIndex[i][1] = edges[i][1];
            edgesWithIndex[i][2] = edges[i][2];
            edgesWithIndex[i][3] = i;
        }
        
        int cost = 0;
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        Arrays.sort(edgesWithIndex, (a, b) -> a[2]-b[2]);

        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i<edges.length; i++){
            cost += ds.union(edgesWithIndex[i]);
        }

        // critical edges
        for(int i = 0; i<edges.length; i++){
            DisjointSet dst = new DisjointSet(n);
            int costt = 0;

            for(int j = 0; j<edges.length; j++){
                if(j == i) continue;

                costt += dst.union(edgesWithIndex[j]);
            }

            if(costt > cost || !dst.isMST()) res.get(0).add(edgesWithIndex[i][3]);
        }

        //non-critical
        for(int i = 0; i<edges.length; i++){
            // if(ds.isEdgeAccepted(edgesWithIndex[i])) continue;
            if(res.get(0).contains(edgesWithIndex[i][3])) continue;
            DisjointSet dst = new DisjointSet(n);
            int costt = 0;
            costt += dst.union(edgesWithIndex[i]);

            for(int j = 0; j<edges.length; j++){
                if(j == i) continue;

                costt += dst.union(edgesWithIndex[j]);
            }

            if(costt == cost && dst.isMST()) res.get(1).add(edgesWithIndex[i][3]);
        }

        return res;
        
    }
}