class KthLargest {
    PriorityQueue<Integer> q;
    int size;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        size = k;
        for(int i: nums){
            add(i);
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size() > size) q.poll();
        return q.peek();
    }
}
