//QuickSelect Solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,nums.length - k,0,nums.length-1);
    }
    public int quickSelect(int[] nums, int ind, int low, int high){
        if(low <= high){
            int pivot = partition(nums,low,high);

            if(pivot < ind){
                return quickSelect(nums,ind,pivot+1,high);
            }
            else if(pivot > ind){
                return quickSelect(nums,ind,low,pivot-1);
            }
            else{
                return nums[pivot];
            }
        }
        return -1; 
    }
    public int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i = low - 1;
        for(int j=low; j<high; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }
    public void swap(int[] nums, int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
