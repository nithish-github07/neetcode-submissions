class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(freq.get(a),freq.get(b)));

        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0) + 1);
        }

        for(int i: freq.keySet()){
            minHeap.offer(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
            
        }

        int[] res = new int[k];
        int j = 0;

        for(int i: minHeap){
            res[j++] = i;
        } 
        
        return res;
    }
}
