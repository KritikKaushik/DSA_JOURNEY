class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            boolean ok=true;

            for(int j=0;j<n;j++){
                if(nums[(i+j)%n]!=j){
                    ok=false;
                    break;
                }
            }

            if(ok){
                ans=Math.min(ans,Math.min(i,n-i+2));
            }
        }

        for(int i=0;i<n;i++){
            boolean ok=true;

            for(int j=0;j<n;j++){
                if(nums[(i-j+n)%n]!=j){
                    ok=false;
                    break;
                }
            }

            if(ok){
                ans=Math.min(ans,Math.min(i+2,n-i));
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
