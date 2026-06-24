class Solution {
    public int findMaxLength(int[] nums) {
        int one=0;
        int zero=0;
        int res=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }else{
                one++;
            }
            int diff=one-zero;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;

            }
            if(!map.containsKey(diff)){
                map.put(diff,map.getOrDefault(diff,0)+i);
            }else{
                int index=map.get(diff);
                int len=i-index;
                res=Math.max(res,len);
            }
        }
        

        return res;

        
    }
}
