class Solution {
    public boolean checkPerfectNumber(int num) {
        int prod=0;
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                prod+=i;
            }
        }
        if(prod==num){
            return true;
        }
        return false;
    }
}
