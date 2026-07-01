class MedianFinder {
    PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(!minheap.isEmpty() && (num > minheap.peek())){
            minheap.offer(num);
        }
        else{
            maxheap.offer(num);
        }

        int n1 = minheap.size();
        int n2 = maxheap.size();

        if(Math.abs(n1-n2) > 1){
            if(n1 > n2){
                maxheap.offer(minheap.poll());
            }
            else{
                minheap.offer(maxheap.poll());
            }
        }
        
    }
    
    public double findMedian() {
        int n1 = minheap.size();
        int n2 = maxheap.size();
        if(n1 == n2){
            return (double)((minheap.peek() + maxheap.peek()) / 2.0);
        }
        else if(n1 > n2){
            return (double)(minheap.peek());
        }
        else{
            return (double)(maxheap.peek());
        }
    }
}
