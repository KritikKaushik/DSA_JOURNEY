class Solution {
    public boolean help(int[] arr,int i,int n){
        if(i==n||i==n-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return help(arr,i+1,n);
    }
    public boolean isSorted(int[] arr) {
        // code here
        return help(arr,0,arr.length);
    }
}
