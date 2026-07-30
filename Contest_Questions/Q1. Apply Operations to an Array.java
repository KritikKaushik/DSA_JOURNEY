class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                nums[i-1]*=2;
                nums[i]=0;
            }
        }
        int nonZero=0;
      int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                
                ans[ansIndex]=nums[i];
                ansIndex++;
            }
        }
        return ans;
    }
}
