class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    makeZero(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void makeZero(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k=0; k<4; k++){
            int ni = i + dir[k][0], nj = j + dir[k][1];
            makeZero(grid,ni,nj);
        }
    }
}
