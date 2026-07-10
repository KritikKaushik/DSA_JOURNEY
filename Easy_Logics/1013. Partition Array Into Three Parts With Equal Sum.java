class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        if(totalSum%3!=0){
            return false;
        }
        int target=totalSum/3;
        int count=0;
        int runSum=0;
        
        for(int num : arr){
            runSum+=num;
            if(runSum==target){
                count++;
                runSum=0;
            }
        }
        return count>=3;
        
    }
}
