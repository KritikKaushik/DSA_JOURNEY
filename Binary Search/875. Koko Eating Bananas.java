class Solution {
    public long retHours(int[] pile,int len,int guess){
        long hours=0;
        for(int i=0;i<len;i++){
            hours=hours+pile[i]/guess;
            if(pile[i]%guess!=0){
               hours++;
            }
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int len=piles.length;
        Arrays.sort(piles);
        int low=1;
        int high=piles[len-1];
        int res=0;


        while(low<=high){
            int guess=low+(high-low)/2;
            long val=retHours(piles,len,guess);
            if(val>h){
                low=guess+1;
            }else {
                res=guess;
                high=guess-1;
                
            }
        }
        return res;

        
    }
}
