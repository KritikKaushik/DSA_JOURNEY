class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        if (arr.length==1){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);//element,frequency
        }
        for(int i=0;i<arr.length;i++){
            int req=target-arr[i];
            if(map.containsKey(req)){
                int index=map.get(req);
                if(index!=i){
                    return true;
                }
            }
        }
        return false;
    }
}
