//3-way partitioning and random sel of pivot
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int low, int high){
        if(low >= high){
            return;
        }
        
        int randInd = low + (int)(Math.random() * (high - low + 1));
        int pivot = nums[randInd];

        int i=0,j=0,k=high;
        while(j <= k){
            if(nums[j] < pivot){
                swap(nums,i,j);
                i++; j++;
            }
            else if(nums[j] > pivot){
                swap(nums,j,k);
                k--;
            }
            else{
                j++;
            }
        }

        quickSort(nums,low,i-1);
        quickSort(nums,k+1,high);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}