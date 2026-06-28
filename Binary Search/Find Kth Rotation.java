class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int size=arr.length-1;
        int low=0;
        int high=size;
        int res=0;
        
        while(low<=high){
            int guess=low+(high-low)/2;
            
            if(arr[guess]>arr[size]){
                low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
        
    }
}
