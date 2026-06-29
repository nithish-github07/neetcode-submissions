class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> 
            Integer.compare((a[0] * a[0] + a[1] * a[1]), (b[0] * b[0] + b[1] * b[1]))
        );
        for(int[] i: points){
            q.offer(i);
        }
        
        for(int i=0; i<k; i++){
            res[i] = q.poll();
        }
        return res;
    }
}
