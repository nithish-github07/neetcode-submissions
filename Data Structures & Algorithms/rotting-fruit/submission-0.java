class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }
        int time = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int s=0; s<size; s++){
                int[] cell = q.poll();
                int i = cell[0], j = cell[1];
                int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
                for(int k = 0; k<4; k++){
                    int ni = i + d[k][0], nj = j + d[k][1];
                    if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] != 1){
                        continue;
                    }
                    grid[ni][nj] = 2;
                    fresh--;
                    q.offer(new int[]{ni,nj});
                }
            }
            time++;
        }
        if(fresh > 0) return -1;
        return time;
    }
}
