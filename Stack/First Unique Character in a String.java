class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);

        }
        for(int j=0;j<s.length();j++){
            char k=s.charAt(j);
            if(map.get(k)==1){
                return j;
            }
        }
        return -1;
    }
}
