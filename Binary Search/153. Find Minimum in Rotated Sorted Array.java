class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int n=nums.length-1;
        int high=n;
        int res=0;


        while(low<=high){
            int guess=low+(high-low)/2;
            if(nums[guess]>nums[n]){
                low=guess+1;
            }else {
                res=nums[guess];
                high=guess-1;
            }
        }
        return res;
    }
}
