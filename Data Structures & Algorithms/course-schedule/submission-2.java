class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<prereq.length; i++){
            adj.computeIfAbsent(prereq[i][0], k -> new ArrayList<>()).add(prereq[i][1]);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(adj,i,new HashSet<>())){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(HashMap<Integer,ArrayList<Integer>> adj, int key, HashSet<Integer> visited){
        if(visited.contains(key)){
            return false;
        }
        if(!adj.containsKey(key)) return true;
        visited.add(key);
        for(int i: adj.get(key)){
            if(!dfs(adj,i,visited)){
                return false;
            }
        }
        visited.remove(key);
        return true;
    }
}
