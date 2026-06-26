class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> have=new HashMap<>();

        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            have.put(c,have.getOrDefault(c,0)+1);
        }

        HashMap<Character,Integer> need=new HashMap<>();

        //balloon;
        need.put('b',need.getOrDefault('b',1));
        need.put('a',need.getOrDefault('a',1));
        need.put('l',need.getOrDefault('l',2));
        need.put('o',need.getOrDefault('o',2));
        need.put('n',need.getOrDefault('n',1));
        int res=Integer.MAX_VALUE;

        for(char ch:need.keySet()){
            if(have.get(ch)==null){
                return 0;
            }
            int hval=have.get(ch);
            int nval=need.get(ch);
            int time=hval/nval;
            res=Math.min(res,time);
        }
        return res;
    }
}
