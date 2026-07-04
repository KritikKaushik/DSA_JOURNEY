class Solution {
    static int help(int n){
        if(n==0){
            return 0;
        }
        int d=n%10;
        int ans=help(n/10);
        return d+ans;
    }
    static int sumOfDigits(int n) {
        // code here
        return help(n);
        
    }
}
