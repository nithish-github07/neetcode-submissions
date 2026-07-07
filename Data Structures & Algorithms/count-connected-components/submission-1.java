class Solution {
    HashMap<Integer,ArrayList<Integer>> adj;
    HashSet<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            adj.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        visited = new HashSet<>();
        for(int i=0; i<n; i++){
            if(visited.contains(i)) continue;
            dfs(i);
            count++;
        }
        return count;
    }
    public void dfs(int key){
        if(visited.contains(key)) return;
        visited.add(key);
        if(adj.containsKey(key)){
            for(int i: adj.get(key)){
                dfs(i);
            }
        }
        
        return;
    }
}
