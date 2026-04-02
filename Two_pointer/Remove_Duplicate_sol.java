class Solution {
    public int removeDuplicates(int[] nums) {
        int low=0;
        int high=1;
        int unq=1;
        while(high<nums.length){
            if(nums[low]==nums[high]){
                high++;
                continue;
            }
            else{
                nums[low+1]=nums[high];
                low++;
                high++;
                unq++;
            }
        }
        return unq;
    }
}
