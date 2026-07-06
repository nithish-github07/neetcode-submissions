class Solution {
    HashSet<Integer> visited,cycle;
    int[] res;
    int ind;
    public int[] findOrder(int numCourses, int[][] prereq) {
        visited = new HashSet<>();
        cycle = new HashSet<>();
        res = new int[numCourses];
        ind = 0;

        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<prereq.length; i++){
            adj.computeIfAbsent(prereq[i][0], k -> new ArrayList<>()).add(prereq[i][1]);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(adj,i)){
                return new int[]{};
            }
        }
        return res;
    }
    public boolean dfs(HashMap<Integer,ArrayList<Integer>> adj, int key){
        if(visited.contains(key)){
            return true;
        }
        if(cycle.contains(key)){
            return false;
        }
        cycle.add(key);
        if(adj.containsKey(key)){
            for(int i: adj.get(key)){
                if(!dfs(adj,i)){
                    return false;
                }
            }
        }
        cycle.remove(key);
        visited.add(key);
        res[ind++] = key;
        return true;
    }
}
