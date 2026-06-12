class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxL = height[0];
        int maxR = height[n-1];
        int left = 0, right = n-1;
        int count = 0;
        while(left < right){
            if(maxL <= maxR){
                left++;
                int val = maxL - height[left];
                if(val > 0){
                    count += val;
                }
                if(height[left] > maxL) maxL = height[left];
            }
            else if(maxR < maxL){
                right--;
                int val = maxR - height[right];
                if(val > 0){
                    count += val;
                }
                if(height[right] > maxR) maxR = height[right];
            }
        }
        return count;
    }
}
