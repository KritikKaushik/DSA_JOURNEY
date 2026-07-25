class Solution {
    public boolean checkOnesSegment(String s) {
        for(int i=1;i<s.length();i++){
            char prev=s.charAt(i-1);
            char curr=s.charAt(i);
            if(prev=='0' && curr=='1'){
                return false;
            }
        }
        return true;
    }
}
