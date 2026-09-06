class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num: nums){
            count[num]++;
        }
        int i=0;
        int k = 0;
        while(i < 3){
            if(count[i] == 0){
                i++;
            }
            else{
                nums[k++] = i;
                count[i]--;
            }
        }
    }
}