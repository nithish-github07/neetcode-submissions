class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res = 0;
        for(int num: nums){
            int count = 0;
            if(!set.contains(num-1)){
                count++;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
            }
            if(count > res) res = count;
        }
        return res;
    }
}
