class Solution {
    public int helper(int[][] mat,int guess){
        int count=0;
        int row=mat.length;
        int col=mat[0].length;

        int r=row-1;
        int c=0;

        while(r>=0 && c<col){
            if(mat[r][c]<=guess){
                count+=r+1;
                c++;
            }else{
                r--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {

        int row=matrix.length;
        int col=matrix[0].length;


        int low=matrix[0][0];
        int high=matrix[row-1][col-1];
        int res=0;

        while(low<=high){
            int guess=low+(high-low)/2;
            if(helper(matrix,guess)>=k){
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
        
    }
}
