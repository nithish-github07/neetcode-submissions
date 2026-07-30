class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        int l = 0;
        int r;
        for(r = 0; r < k ; r++){
            q.offer(new int[]{nums[r],r});
        }
        r = k-1;
        int ind = 0;
        while(r < n){
            while(!q.isEmpty() && (q.peek()[1] < l)){
                q.poll();
            }
            res[ind++] = q.peek()[0];
            l++;
            r++;
            if(r < n) q.offer(new int[]{nums[r],r});
        }
        return res;
        
    }
}
