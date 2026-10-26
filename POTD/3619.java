class Solution {
    public int countIslands(int[][] grid,int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    long sum=dfs(grid,i,j,n,m);
                    if(sum%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public long dfs(int[][] grid,int i,int j,int n,int m){
        if(i<0||j<0||i>=n||j>=m||grid[i][j]==0){
            return 0;
        }

        long sum=grid[i][j];
        grid[i][j]=0;

        sum+=dfs(grid,i+1,j,n,m);
        sum+=dfs(grid,i-1,j,n,m);
        sum+=dfs(grid,i,j+1,n,m);
        sum+=dfs(grid,i,j-1,n,m);

        return sum;
    }
}
