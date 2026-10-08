class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int r =0; r<n; r++){
            if(set.contains(nums[r])){
                return true;
            }

            set.add(nums[r]);

            if(r - l >= k){
                set.remove(nums[l]);
                l++;
            }
        }

        return false;
    }
}