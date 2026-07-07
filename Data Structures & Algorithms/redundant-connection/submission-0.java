class Solution {
    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            if(!union(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }

        return new int[]{};
    }

    public int find(int n){
        if(n != parent[n]){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    } 

    public boolean union(int n1, int n2){
        int p = find(n1);
        int q = find(n2);

        if(p == q) return false;

        if(rank[p] > rank[q]){
            parent[q] = p;
            rank[p] += rank[q];
        }
        else{
            parent[p] = q;
            rank[q] += rank[p];
        }

        return true;
    } 
}
