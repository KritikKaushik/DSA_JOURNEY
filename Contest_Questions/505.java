class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        //abs(n-x)<=k
        //(n & x)==0
        //return sum of all compatible integers
        int sum=0;
        for(int x=1;x<=10000;x++){
            if(Math.abs(n-x)<=k && ((n & x)==0)){
                sum+=x;
            }
        }return sum;
    }
}
