class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        for(int i=0; i< n; i++){
            if(i == 0 || i == n-1){
                newNums[i] = 1;
                continue;
            }
            newNums[i] = nums[i-1];
        }
        int[][] cache = new int[n][n];
        for(int[] row: cache){
            Arrays.fill(row,-1);
        }
        return dfs(1,n-2,newNums,cache);
    }
    public int dfs(int l, int r, int[] nums, int[][] cache){
        if(l > r){
            return 0;
        }
        if(cache[l][r] != -1){
            return cache[l][r];
        }
        int maxCount = 0;
        for(int i=l; i<=r; i++){
            int count = nums[l-1] * nums[i] * nums[r+1];
            count += dfs(l,i-1,nums,cache) + dfs(i+1,r,nums,cache);
            maxCount = Math.max(maxCount,count);
        }
        cache[l][r] = maxCount;
        return maxCount;

    }
}
