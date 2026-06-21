class Solution {
    public int maxProduct(int[] nums) {
        int i=0;
        int best=nums[i];
        int negbest=nums[i];
        int ans=nums[i];
       


        for(i=1;i<nums.length;i++){
            int ch1=best*nums[i];
            int ch2=nums[i];

           int ch3=negbest*nums[i];
           

        

            negbest=Math.min(ch1,Math.min(ch2,ch3));
            best=Math.max(ch1,Math.max(ch3,ch2));

           ans=Math.max(ans,Math.max(negbest,best));
            
        }
        return ans;
    }
}
