class Solution {
    public int maximumSum(int[] arr) {
        int nodelete = arr[0];
        int onedelete = 0;a
        int best = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = nodelete;

            nodelete = Math.max(arr[i], nodelete + arr[i]);

            onedelete = Math.max(
                onedelete + arr[i], 
                prevNoDelete        
            );

            best = Math.max(best, Math.max(nodelete, onedelete));
        }

        return best;
    }
}
