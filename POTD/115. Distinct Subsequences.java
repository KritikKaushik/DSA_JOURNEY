class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        long dp[][]=new long[m+1][n+1];

        //dp[m][0]=1
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }

        //dp[][n]=0
        for(int i=1;i<=n;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return(int) dp[m][n];
    }
}

/* The problem have 2 steps :
   if we compare character by character then there are 2 possiblity
   1. character matches
   if match then we want to check how many character matches i,i+1,i+2.......
   +check for next character i+1,j+1 where i is s string pointer and j is t string pointer
   
   2.character doesnt match
   then move the i++ and check when the string character matches
   itr1:
   i
   aabsjbd
   
   jbd
   itr2:
    i
   aabsjbd
   
   jbd
   itr5
       i
   aabsjbd
   jbd
   matches...... now this is case 1.



   Base case:
   if we iterated fully over the t string then we found one permutation
   if we iterated fully over s string then no valid permutation is found.
   */
