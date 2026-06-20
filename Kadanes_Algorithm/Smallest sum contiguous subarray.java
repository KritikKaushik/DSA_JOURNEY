class Solution {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int i=0;
        int best=a[i];
        int ans=best;
        
        for(i=1;i<size;i++){
            int ch1=best+a[i];
            
            int ch2=a[i];
            best=Math.min(ch1,ch2);
            ans=Math.min(ans,best);
            
        }
        return ans;
    }
}
// simple in kadane we have 2 choice for each i we check the best for i . also kadane handles -ve values.
