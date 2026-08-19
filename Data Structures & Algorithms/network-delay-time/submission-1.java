class Edge{
    int node;
    int weight;
    Edge(int weight, int node){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<Edge>> adj = new HashMap<>();
        for(int[] edge: times){
            Edge e = new Edge(edge[2],edge[1]);
            adj.computeIfAbsent(edge[0],key -> new ArrayList<>()).add(e);
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
        HashSet<Integer> visited = new HashSet<>();

        q.offer(new Edge(0,k));
        int res = -1;
        while(!q.isEmpty()){
            Edge e = q.poll();
            int v = e.node;
            int w = e.weight;
            if(visited.contains(v)){
                continue;
            }
            res = Math.max(res,w);
            visited.add(v);
            if(adj.containsKey(v)){
                for(Edge edge: adj.get(v)){
                    if(!visited.contains(edge.node)){
                        q.offer(new Edge(w + edge.weight, edge.node));
                    }
                }
            }
            
        }

        return (visited.size() == n) ? res : -1;
    }
}
