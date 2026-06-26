class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }

        HashMap<Character,Integer> have=new HashMap<>();
        HashMap<Character,Integer> need=new HashMap<>();
        
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);

        }
        for(int j=0;j<magazine.length();j++){
            char ch=magazine.charAt(j);
            have.put(ch,have.getOrDefault(ch,0)+1);

        }

        for(int k=0;k<ransomNote.length();k++){
            char m=ransomNote.charAt(k);
            if(!have.containsKey(m)){
                return false;
            }
            if(need.get(m)>have.get(m)){
                return false;

            }
        }
        return true;

    }
}
