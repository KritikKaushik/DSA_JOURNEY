class Solution {
    public boolean checkString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }else if(map.containsKey(s.charAt(i)) && s.charAt(i)=='a'){
                map.put(s.charAt(i),i);
            }
        }

        Integer lasta=map.get('a');
        Integer firstb=map.get('b');
        if(map.get('a')==null){
            return true;
        }
        if(map.get('b')==null){
            return true;
        }

        return lasta<firstb;
    }
}
