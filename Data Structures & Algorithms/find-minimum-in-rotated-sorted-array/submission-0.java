class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        int left = 0, right = nums.length-1;
        while(left <= right){
            if(nums[left] < nums[right]){
                res = Math.min(res,nums[left]);
                break;
            }
            int mid = (left + right)/2;
            res = Math.min(res,nums[mid]);
            if(nums[mid] >= nums[left]){
                left = left + 1;
            }
            else{
                right = right - 1;
            }
        }
        return res;
    }
}
