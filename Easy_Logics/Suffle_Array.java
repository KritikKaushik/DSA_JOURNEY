class Solution {
    public int[] shuffle(int[] nums, int n) {
        int leng = n * 2;
        int ret[] = new int[leng];
        int evencount = 0;
        int oddcount = n;

        for (int i = 0; i < leng; i++) {
            if(i%2==0){
                ret[i]=nums[evencount++];
            }else{
                ret[i]=nums[oddcount++];
            }
        }

        return ret;
    }
}
//Main problem done while solving thought of 2 pointers, used preincrement instead of normal post increment;
