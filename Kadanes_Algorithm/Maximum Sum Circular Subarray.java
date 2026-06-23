class Solution {
    static public int sum(int[] a){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
    public int maxSubarraySumCircular(int[] nums) {

        int j=0;
        int max=nums[j];
        int min=nums[j];
        int res=nums[j];
        int numtotal=sum(nums);

        for(j=1;j<nums.length;j++){
            max=Math.max(max+nums[j],nums[j]);

            min=Math.min(min+nums[j],nums[j]);
            int v2=numtotal-min;//CASE 2 where elements are on edges.
            if(min==numtotal){
                res=Math.max(res,max);
            }else{
                res=Math.max(res,Math.max(max,v2));
            }

            

        }
        return res;
    }
}
