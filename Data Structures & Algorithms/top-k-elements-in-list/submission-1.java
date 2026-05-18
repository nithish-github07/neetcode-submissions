class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> freq.get(b)-freq.get(a));
        for(int i: set){
            queue.add(i);
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
