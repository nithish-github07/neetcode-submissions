class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,visited,res,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backtrack(nums,visited,res,list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
