class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int n = nums.length;
        int k = 0;
        for(int j=0; j<n; j++){
            if(nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;k++;
            }
        }
        return k;
    }
}