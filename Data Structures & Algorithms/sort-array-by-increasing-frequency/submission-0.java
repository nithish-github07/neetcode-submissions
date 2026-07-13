class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0) + 1);
        }
        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a,b) -> {
            if(freq.get(a) == freq.get(b)){
                return Integer.compare(b,a);
            }
            return Integer.compare(freq.get(a),freq.get(b));
        });
        for(int i=0; i<arr.length; i++){
            nums[i] = arr[i];
        }
        return nums;
    }
}