class Solution {
    public int titleToNumber(String columnTitle) {
        int size=columnTitle.length();
        int ans=0;
        
        for(int i=0;i<size;i++){
            char ch=columnTitle.charAt(i);
            ans=ans*26+(ch-'A'+1);
        }
        return ans;
        
    }
}
