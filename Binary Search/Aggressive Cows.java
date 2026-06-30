class Solution {
    public static boolean poss(int[] arr,int guess,int n,int k){
        int count=1;
        int prevCow=arr[0];
        
        for(int i=0;i<n;i++){
            int dist=arr[i]-prevCow;
            if(dist<guess){
                continue;
            }
            count++;
            prevCow=arr[i];
        }
        if(count>=k){
            return true;
        }
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int size=stalls.length;
        int low=1;
        int high=stalls[size-1]-stalls[0];
        int res=-1;
        
        while(low<=high){
            int guess=low+(high-low)/2;
            
            
            if(poss(stalls,guess,size,k)){
                res=guess;
                low=guess+1;
            }else{
                high=guess-1;
            }
            
        }
        return res;
        
    }
}
