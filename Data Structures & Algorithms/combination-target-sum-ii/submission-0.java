class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,res,new ArrayList<>(),0,0);
        return res;
    }
    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int sum, int ind){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind; i<candidates.length; i++){
            if(i > ind && candidates[i-1] == candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates,target,res,list,sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
