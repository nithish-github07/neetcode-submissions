class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<prereq.length; i++){
            adj.computeIfAbsent(prereq[i][0], k -> new ArrayList<>()).add(prereq[i][1]);
        }
        boolean flag = true;
        for(int key: adj.keySet()){
            flag = dfs(adj,key,new HashSet<>());
            if(!flag) break;
        }
        return flag;
    }
    public boolean dfs(HashMap<Integer,ArrayList<Integer>> adj, int key, HashSet<Integer> visited){
        if(visited.contains(key)){
            return false;
        }
        if(!adj.containsKey(key)) return true;
        visited.add(key);
        boolean flag = true;
        for(int i: adj.get(key)){
            flag = dfs(adj,i,visited);
            if(!flag) break;
        }
        visited.remove(key);
        return flag;
    }
}
