class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j,n,m)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid,int i,int j,int n,int m){
        if(i<0||j<0||i>=n||j>=m){
            return false;
        }

        if(grid[i][j]==1){
            return true;
        }

        grid[i][j]=1;

        boolean a=dfs(grid,i+1,j,n,m);
        boolean b=dfs(grid,i-1,j,n,m);
        boolean c=dfs(grid,i,j+1,n,m);
        boolean d=dfs(grid,i,j-1,n,m);

        return a&&b&&c&&d;
    }
}
