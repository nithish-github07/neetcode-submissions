class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(res,new ArrayList<>(),0,nums);
        return res;
    }
    public void findSubsets(List<List<Integer>> res, List<Integer> list, int ind, int[] nums){
        res.add(new ArrayList<>(list));
        for(int i=ind; i<nums.length; i++){
            list.add(nums[i]);
            findSubsets(res,list,i+1,nums);
            list.remove(list.size()-1);
        }
    }
}
