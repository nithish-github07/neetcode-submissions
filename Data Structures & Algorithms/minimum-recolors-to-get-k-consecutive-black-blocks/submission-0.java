class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countB = 0;
        int l=0, r=0;
        while(r < k){
            if(blocks.charAt(r) == 'B'){
                countB++;
            }
            r++;
        }
        r = r - 1;
        int min = k - countB;
        while(r < blocks.length()){
            if(blocks.charAt(l) == 'B') countB--;
            l++; r++;
            if(r < blocks.length() && blocks.charAt(r) == 'B') countB++;
            min = Math.min(min,(k-countB));
        }
        return min;
    }
}