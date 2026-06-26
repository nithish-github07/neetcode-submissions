class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinationSum(nums,target,res,new ArrayList<>(),0,0);
        return res;
    }
    public void findCombinationSum(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int ind, int sum){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind; i<nums.length; i++){
            list.add(nums[i]);
            findCombinationSum(nums,target,res,list,i,sum + nums[i]);
            list.remove(list.size() - 1);
        }
        return;
    }
}
