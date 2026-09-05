//sorting solution
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i+1 < n && nums[i] == nums[i+1]){
                count++;
            }else{
                count++;
                if(count > (n / 2)){
                    return nums[i]; 
                }
                count = 0;
            }
        }
        return -1;
    }
}