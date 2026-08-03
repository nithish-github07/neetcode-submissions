class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        int goal = n-1;
        for(int i = n-2; i>=0; i--){
            for(int j=1; j<=nums[i]; j++){
                if(i + j == goal){
                    goal = i;
                    break;
                }
            }
        }
        return ((goal == 0) ? true : false);
    }
}
