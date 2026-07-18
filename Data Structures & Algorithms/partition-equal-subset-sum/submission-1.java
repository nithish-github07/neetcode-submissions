//Tabulation - Bottom Up DP
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;

        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i=nums.length-1; i>=0; i--){
            HashSet<Integer> nextDp = new HashSet<>();
            for(int j: dp){
                if(nums[i] + j == target) return true;
                nextDp.add(nums[i] + j);
                nextDp.add(j);
            }
            dp = nextDp;
        }
        return dp.contains(target);
    }
}
