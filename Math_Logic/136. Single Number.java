class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }
}

//Input: nums = [4,1,2,1,2]
// no xor to itself is 0 as 0^4=4;4^1=5;5^2=7;7^1=6;6^2=4 return 4 
