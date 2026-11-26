class Solution {
    public boolean canAliceWin(int n) {
        boolean alice=true;//alice win if its false then
        //bob wins 
        boolean bob=false;
        if(n<10){
            return false;
        }
        for(int i=10;i>0;i--){
            if(n<0 || n<i){
                break;
            }else if(i%2==0){//alice
            alice=true;
            bob=false;
            n-=i;
            }else{
                alice=false;
                bob=true;
                n-=i;
            }
        }
        if(alice==true){
            return true;
        }else{
            return false;
        }
    }
}
