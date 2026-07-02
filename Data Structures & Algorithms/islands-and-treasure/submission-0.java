class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{0,i,j});
                    visited[i][j] = true;
                }
            }
        }
        int max = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int val = arr[0], i = arr[1], j = arr[2];
            int[][] d = {{-1,0},{1,0},{0,1},{0,-1}};
            for(int k=0; k<4; k++){
                int ni = i + d[k][0], nj = j + d[k][1];
                if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || visited[ni][nj] || grid[ni][nj] != max){
                    continue;
                }
                grid[ni][nj] = val + 1;
                visited[ni][nj] = true;
                q.offer(new int[]{val+1,ni,nj});
            }

        }
    }
}
