class Solution {
    public static int maximumEle(int ar[]){
            int maxFreq=0;
            for(int i=0;i<ar.length;i++){
                maxFreq=Math.max(maxFreq,ar[i]);

            }
            return maxFreq;
        }
    public int characterReplacement(String s, int k) {
        int low=0;
        int high=0;
        int res=0;



        int arr[] = new int[256];

        

        for(high=0;high<s.length();high++){
            char c=s.charAt(high);
            int asci=(int) c;
            arr[asci]++;
            int maxinArray=maximumEle(arr);
            int len=high-low+1;
            int diff=Math.abs(len-maxinArray);

            while(diff>k){
                c=s.charAt(low);
                asci=(int) c;
                arr[asci]--;
                low++;
                maxinArray=maximumEle(arr);
                len=high-low+1;
                diff=Math.abs(len-maxinArray);

            }
            len=high-low+1;
            res=Math.max(res,len);
        }

        return res;
    }
}
