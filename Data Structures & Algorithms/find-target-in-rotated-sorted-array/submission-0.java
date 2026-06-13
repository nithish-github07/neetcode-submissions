class Solution {
    public int findDeflection(int[] nums){
        int res = 0;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] < nums[right]){
                if(nums[left] < nums[res]) res = left;
                break;
            }
            int mid = (left + right) / 2;
            if(nums[mid] < nums[res]) res = mid;
            if(nums[mid] >= nums[left]) left = mid + 1;
            else right = mid - 1;
        }
        return res;
    }
    public int binarySearch(int[] nums, int left, int right,int target){
        if(right < 0) return -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int res = findDeflection(nums);
        int ind = binarySearch(nums,0,res-1,target); 
        if(ind != -1){
            return ind;
        }
        ind = binarySearch(nums,res,nums.length-1,target);
        return ind;
    }
}
