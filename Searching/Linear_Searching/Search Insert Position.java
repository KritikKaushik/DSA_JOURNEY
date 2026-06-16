class Solution {
    public int searchInsert(int[] nums, int target) {
        int ret=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                ret=i;
                break;
            }
            if(i==(nums.length-1)){
                return ret=++i;
            }
        }
        return ret;
    }
}
