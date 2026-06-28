class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int size=arr.length-1;
        int low=0;
        int high=size;
        int start=0;
        int end=0;
        
        while(low<=high){
        int mid=low+(high-low)/2;
            if(arr[mid]==target){
                start=mid;
                high=mid-1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        low=0;
        high=size;
        
        while(low<=high){
        int mid=low+(high-low)/2;
            if(arr[mid]==target){
                
                end=mid;
                low=mid+1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(end==0 && start==0){
            return (end-start);
            
        }
        
        return (end-start)+1;
    }
}
