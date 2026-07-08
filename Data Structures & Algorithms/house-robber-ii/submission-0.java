class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(dp(Arrays.copyOfRange(nums,1,nums.length)), dp(Arrays.copyOfRange(nums,0,nums.length-1)));
    }
    public int dp(int[] nums){
        int a=0, b=nums[0]; 
        for(int i=1; i<nums.length; i++){
            int temp = b;
            b = Math.max(b,(a + nums[i]));
            a = temp;
        }
        return b;
    }
}
