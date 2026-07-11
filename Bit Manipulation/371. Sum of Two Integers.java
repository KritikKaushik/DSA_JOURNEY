class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int temp=(a&b)<<1;// it will store carry and left shift it
            a=a^b;// 100^010=110
            b=temp;//
        }
        return a;
    }
}

