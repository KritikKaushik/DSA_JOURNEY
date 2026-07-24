class Solution {
    public int[] sortedSquares(int[] nums) {
        int size=nums.length;
        int right=size-1;
        int left=0;
        int ans[]=new int[size];
        int anspt=size-1;

        while(left<=right){
            if((nums[left]*nums[left])>(nums[right]*nums[right])){
                ans[anspt]=nums[left]*nums[left];
                left++;
                anspt--;
            }
            else if((nums[left]*nums[left])<(nums[right]*nums[right])){
                ans[anspt]=nums[right]*nums[right];
                right--;
                anspt--;
            }else{
                 ans[anspt]=nums[right]*nums[right];
                right--;
                anspt--;
            }
        }
        return ans;
        
    }
    //SC-O(N)
    //TC-O(N)
}
