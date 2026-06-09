class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int j,k;
        for(int i=0; i<nums.length-2; i++){
            j=i+1; k= nums.length-1;
            int sum = 0;
            while(j<k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> grp = new ArrayList<>();
                    grp.add(nums[i]); grp.add(nums[j]); grp.add(nums[k]);
                    if(!list.contains(grp)) list.add(grp);
                    j++;k--;
                }
                else{
                    if(sum < 0){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
            }
        }
        return list;

    }
}
