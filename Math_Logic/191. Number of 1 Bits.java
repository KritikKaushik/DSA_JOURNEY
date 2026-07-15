class Solution {
    public int hammingWeight(int n) {

        StringBuilder binary=new StringBuilder();

        while(n>0){
            int rem=n%2;
            binary.insert(0,rem);
            n=n/2;
        }
        int count=0;
        
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                count++;
            }
        }
        
        return count;
    }
}
