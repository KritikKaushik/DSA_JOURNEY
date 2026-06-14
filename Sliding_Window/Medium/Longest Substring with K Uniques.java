class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int low=0;
        int high=0;
        
        int res=0;
        
        HashMap<Character,Integer> f=new HashMap<>();
        
        for(high=0;high<s.length();high++){
            int len=high-low+1;
            
            f.put(s.charAt(high),f.getOrDefault(s.charAt(high),0)+1);
            
            while(f.size()>k){
                
                
                f.put(s.charAt(low),f.get(s.charAt(low))-1);
                if(f.get(s.charAt(low))==0){
                    f.remove(s.charAt(low));
                }
                
                
                low++;
            }
            len=high-low+1;
            res=Math.max(res,len);
        }
        if(f.size()==k){
                return res;
             
        }
        return -1;
    }
}
