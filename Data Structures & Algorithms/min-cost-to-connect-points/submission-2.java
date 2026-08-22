class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        int n = points.length;

        for(int i=0; i<n; i++){ //all points are connected to all other points
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j<n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{dist,i});
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0])); //minheap
        q.offer(new int[]{0,0});
        int res = 0;

        while(visited.size() < n){
            int[] p = q.poll();
            int dist = p[0];
            int pt = p[1];

            if(visited.contains(pt)){
                continue;
            }
            res += dist;
            visited.add(pt);

            if(!adj.containsKey(pt)) continue;

            for(int[] nei: adj.get(pt)){
                if(!visited.contains(nei[1])){
                    q.offer(nei);
                }
            }
        } 

        return res;
    }
}
