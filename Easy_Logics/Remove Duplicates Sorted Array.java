class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        
        if(arr.length==0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                continue;
            }else{
                ans.add(arr[i]);
            }
        }
        return ans;
    }
}
