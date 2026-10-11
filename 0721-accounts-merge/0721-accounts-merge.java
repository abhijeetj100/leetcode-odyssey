class Solution {
    public class DSU{
        int[] parent;
        int[] size;

        public DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i<n; i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int find(int a){
            if(parent[a] != a){
                parent[a] = find(parent[a]);
            }

            return parent[a];
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) return;

            if(size[rootA] < size[rootB]){
                parent[rootA] = rootB;
                size[rootB]+=size[rootA];
            }
            else{
                parent[rootB] = rootA;
                size[rootA]+=size[rootB];
            }

            return;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        HashMap<String, Integer> emailGroup = new HashMap<>();

        for(int i = 0; i<n; i++){
            int accSize = accounts.get(i).size();
            for(int j = 1; j<accSize; j++){
                String email = accounts.get(i).get(j);
                // int accName = accounts.get(i).get(0);

                if(!emailGroup.containsKey(email)){
                    emailGroup.put(email, i);
                }
                else{
                    dsu.union(i, emailGroup.get(email));
                }
            }
        }

        HashMap<Integer, List<String>> components = new HashMap<>();
        for(String email : emailGroup.keySet()){
            int group = emailGroup.get(email);
            int groupParent = dsu.find(group);

            if(!components.containsKey(groupParent)){
                components.put(groupParent, new ArrayList<>());
            }

            components.get(groupParent).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for(int i : components.keySet()){
            List<String> emails = components.get(i);
            Collections.sort(emails);
            emails.add(0, accounts.get(i).get(0));
            res.add(emails);
        }

        return res;

        


    }
}