class Solution {
    public static int sum(int num)
    {
        int sum=0;
        while(num>0){
            int digit=num%10;
            num=num/10;
            sum=sum+(digit*digit);
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(fast!=1){
            slow=sum(slow);
            fast=sum(fast);
            fast=sum(fast);

            if(slow==fast && slow!=1){
                return false;
            }
        }
        return true;       
    }
}

