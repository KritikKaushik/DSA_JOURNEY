class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int size = r *c;
        int low = 0;
        int high = size - 1;



        while (low <= high) {
            int guess = low + (high - low) / 2;
            int row = guess / c;
            int col = guess % c;

            if (matrix[row][col] < target) {
                low = guess + 1;
            } else if (matrix[row][col] == target) {
                return true;
            } else {
                high = guess - 1;
            }

        }
        return false;

    }
}
