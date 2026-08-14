class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0, r=n-1, t=0, b=m-1;
        List<Integer> res = new ArrayList<>();
        while(l <= r && t <= b){
            for(int i=l; i<=r; i++){
                res.add(matrix[t][i]);
            }
            t++;

            for(int i=t; i<=b; i++){
                res.add(matrix[i][r]);
            }
            r--;

            if(t <= b){
                for(int i=r; i>=l; i--){
                    res.add(matrix[b][i]);
                }
                b--;
            }           
            

            if(l <= r){
                for(int i=b; i>=t; i--){
                    res.add(matrix[i][l]);
                }
                l++;
            }
        }

        return res;
    }
}
