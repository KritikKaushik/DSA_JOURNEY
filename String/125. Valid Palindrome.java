class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=Character.toLowerCase(s.charAt(i));
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }
        }
        String an=ans.toString();
        String rev=ans.reverse().toString();
        
        if(an.equals(rev)){
            return true;
        }
        return false;

        
    }
}
