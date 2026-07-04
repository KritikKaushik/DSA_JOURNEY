class Solution {
    boolean comp(String s,int low,int high){
        int len=high-low+1;
        if(len==0||len==1){
            return true;
        }
        if(s.charAt(low)!=s.charAt(high)){
            return false;
        }
        return comp(s,low+1,high-1);
    }
    boolean isPalindrome(String s) {
        // code here
        int low=0;
        int high=s.length()-1;
        return comp(s,low,high);
    }
}
