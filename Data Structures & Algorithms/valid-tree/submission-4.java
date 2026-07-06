class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            adj.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        return (dfs(adj,0,-1,visited) && visited.size() == n);
    }
    public boolean dfs(HashMap<Integer,ArrayList<Integer>> adj, int key, int prev, HashSet<Integer> visited){
        if(visited.contains(key)) return false;
        visited.add(key);
        if(adj.containsKey(key)){
            for(int i: adj.get(key)){
                if(i == prev) continue;
                if(!dfs(adj,i,key,visited)){
                    return false;
                }
            }
        }
        
        return true;
    }
}
