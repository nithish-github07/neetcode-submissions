class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1) return;
        int n = nums.length;
        k = k % n;
        reverseArr(nums,0,n-1);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,n-1);
    }
    public void reverseArr(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}