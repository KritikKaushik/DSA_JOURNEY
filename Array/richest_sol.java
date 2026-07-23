class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int res=0;
        for(int[] acc : accounts){
            int sum=0;
            for(int money : acc){
                sum+=money;
                res=Math.max(res,sum);
            }
        }
        return res;
    }
}

//directly see the richesr customer
