class Solution {
    public static int sumarr(int[] arr){
        int sum=0;
        for(int n=0;n<arr.length;n++){
            sum+=arr[n];
        }
        return sum;
    }
    public int pivotIndex(int[] nums) {
        int sumval=sumarr(nums);
        int left=0;

        for(int i=0;i<nums.length;i++){
            
            int right=sumval-left-nums[i];
            if(left==right){
                return i;
            }
            left+=nums[i];
            
        }

        return -1;
    }
}
