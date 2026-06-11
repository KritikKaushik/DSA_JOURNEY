class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int low=0;
        int high=k-1;
        int sum=0;
        int res=0;
        for(int i=low;i<=high;i++){
                sum=sum+arr[i];
            }
        while(high<arr.length){
            res=Math.max(sum,res);
            high++;
            low++;
            sum=sum-arr[low-1];
            if(high==arr.length){
                break;
            }
            sum=sum+arr[high];
        }
        return res;
    }
}
