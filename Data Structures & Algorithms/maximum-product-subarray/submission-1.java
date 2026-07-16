class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            int val1 = nums[i] * currentMax;
            int val2 = nums[i] * currentMin;
            currentMax = Math.max(Math.max(val1,val2),nums[i]);
            currentMin = Math.min(Math.min(val1,val2),nums[i]);
            res = Math.max(res,currentMax);
        }
        return res;
    }
}
