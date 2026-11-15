class Solution {
    static final long MOD = 1_000_000_007L;
    public int numOfSubarrays(int[] arr) {
        long ans=0;

        int even=1;
        int odd=0;

        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            if(sum%2==0){
                ans=(ans+odd)%MOD;
                even++;
            }else{
                
                ans=(ans+even)%MOD;
                odd++;
            }
        }
        return (int)ans;
    }
}
