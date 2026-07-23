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
    //reverse the string and check if they are equal.
    
}//optimised only in one pass without any extra soace
{
int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
