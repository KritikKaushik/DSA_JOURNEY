class Solution {
    public static boolean checkEven(int x){
        int count=0;
        while(x>0){
            int digit=x%10;
            x=x/10;
            count++;
        }
        if(count%2==0){
            return true;
        }
        return false;
    }
    public int findNumbers(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(checkEven(nums[i])==true){
                res++;

            }
        }
        return res;
    }
}
