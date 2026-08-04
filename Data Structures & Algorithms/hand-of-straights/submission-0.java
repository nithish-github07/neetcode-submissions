//Using freq count(hashmap) and priority queue
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i: hand){
            if(!freq.containsKey(i)){
                freq.put(i,1);
                minheap.offer(i);
            }
            else{
                freq.put(i,freq.get(i) + 1);
            }
        }
        while(!minheap.isEmpty()){
            int first = minheap.peek();
            for(int i=first; i<(first + groupSize); i++){
                if(!freq.containsKey(i)){
                    return false;
                }
                freq.put(i,freq.get(i) - 1);
                if(freq.get(i) == 0){
                    if(minheap.peek() != i){
                        return false;
                    }
                    minheap.poll();
                }
            }
        }

        return true;
    }
}
