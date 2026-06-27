class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(nums,res,new ArrayList<>(),0);
        return res;
    }
    public void findSubsets(int[] nums, List<List<Integer>> res, List<Integer> list, int ind){
        res.add(new ArrayList<>(list));
        for(int i=ind; i<nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            findSubsets(nums,res,list,i+1);
            list.remove(list.size() - 1);
        }
    }
}
