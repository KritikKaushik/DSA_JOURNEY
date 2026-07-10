class Solution {
    static int[][]dp;
    static boolean haveSubset(int arr[], int sum,int index){
        if(sum==0){
            return true;
        }
        if(sum<0 || index<0){
            return false;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum] ==1;
        }
        
        //pick
        boolean ans=haveSubset(arr,sum,index-1) || haveSubset(arr,sum-arr[index],index-1); 
        
        //notpick
        dp[index][sum]=ans ? 1 : 0;
        return ans;
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
         dp=new int[arr.length][sum+1];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
         
         
        return haveSubset(arr,sum,arr.length-1);
        
    }
}
