class Solution {
    public int rob(int[] nums) {
        int a = 0, b = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        return b;
    }
}
