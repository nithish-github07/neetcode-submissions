class Solution {
    public int BinarySearch(int[] arr, int target, int low, int high){
        if(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                return BinarySearch(arr,target,mid+1,high);
            }
            else{
                return BinarySearch(arr,target,low,mid-1);
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return BinarySearch(nums,target,0,nums.length-1);
    }
}
