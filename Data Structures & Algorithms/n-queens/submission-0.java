class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        nqueens(n,res,new int[n],0);
        return res;
    }
    public void nqueens(int n, List<List<String>> res, int[] pos, int Q){
        if(Q == n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(j == pos[i]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for(int i=0; i<n; i++){
            if(place(i,Q,pos)){
                pos[Q] = i;
                nqueens(n,res,pos,Q+1);
                pos[Q] = -1;
            }
        }
        
    }

    public boolean place(int k, int Q, int[] pos){
        for(int i=0; i<Q; i++){
            if(pos[i] == k) return false;
            else if(Math.abs(i - Q) == Math.abs(pos[i] - k)) return false;
        }
        return true;
    }
}
