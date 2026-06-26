class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> str=new HashMap<>();
        int res=0;
        boolean odd=false;
        


        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            str.put(c,str.getOrDefault(c,0)+1);
        }
        for(char ch:str.keySet()){
            int freq=str.get(ch);
            if(freq%2==0){
                res+=freq;

            }else{
                freq=freq-1;
                res+=freq;
                odd=true;
            }
            
        }
        if(odd==false){
            return res;
        }
        return res+1;
        
        
    }
}
