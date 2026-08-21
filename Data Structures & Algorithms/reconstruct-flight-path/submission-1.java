class Solution {
    HashMap<String,PriorityQueue<String>> adj;
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        res = new ArrayList<>();

        for(List<String> t: tickets){
            adj.computeIfAbsent(t.get(0), k->new PriorityQueue<>()).offer(t.get(1));
        }

        dfs("JFK");

        return res;
    }
    public void dfs(String node){
        PriorityQueue<String> pq = adj.get(node);

        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }

        res.addFirst(node); //reverse adding elements
    }
}
