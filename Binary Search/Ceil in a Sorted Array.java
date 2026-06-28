class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int size=arr.length;
        int low=0;
        int high=size-1;
        int index=-1;
        
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<x){
                low=mid+1;
            }else{
                index=mid;
                high=mid-1;
                
            }
        }
        
        return index;
    }
}
