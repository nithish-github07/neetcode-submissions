class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;
        for(int j=0; j<n; j++){
            if(nums[j] != val){
                nums[k++] = nums[j];
            }
        }
        return k;
    }
}