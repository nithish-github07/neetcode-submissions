class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for(int i=0; i<cols; i++){
            dfs(0,i,pacific,heights[0][i],heights);
            dfs(rows-1,i,atlantic,heights[rows-1][i],heights);
        }
        for(int i=0; i<rows; i++){
            dfs(i,0,pacific,heights[i][0],heights);
            dfs(i,cols-1,atlantic,heights[i][cols-1],heights);
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }
    public void dfs(int i, int j, boolean[][] set, int prevHeight, int[][] heights){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || set[i][j] || (heights[i][j] < prevHeight)){
            return;
        }
        set[i][j] = true;
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k=0; k<4; k++){
            int ni = i + d[k][0], nj = j + d[k][1];
            dfs(ni,nj,set,heights[i][j],heights);
        }
    }
}
