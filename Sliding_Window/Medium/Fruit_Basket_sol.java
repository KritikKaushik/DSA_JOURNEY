class Solution {
    public int totalFruit(int[] fruits) {
        int high=0;
        int low=0;
        int len=high-low+1;
        int res=0;

        HashMap<Integer,Integer> f=new HashMap<>();

        for(high=0;high<fruits.length;high++){
            f.put(fruits[high],f.getOrDefault(fruits[high],0)+1);

            while(f.size()>2){
                f.put(fruits[low],f.get(fruits[low])-1);
                if(f.get(fruits[low])==0){
                    f.remove(fruits[low]);
                }
                low++;
            }
            len=high-low+1;
            res=Math.max(res,len);
        }
        if((f.size()==2) || (f.size()<2)){
            return res;
        }
        return -1;
    }
}
