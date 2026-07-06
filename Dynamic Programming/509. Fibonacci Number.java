//Recusion
class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }       
        return fib(n-1)+fib(n-2);
    }
}


//Top down approach
class Solution {

    public int fibb(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibb(n - 1, dp) + fibb(n - 2, dp);

    }

    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibb(n, dp);
    }

}

//Bottom Up

import java.util.Arrays;

class Solution {

    public int fibb(int n, int[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        return fibb(n, dp);
    }
}


//Optimised code with DP space complexity o(3)



class Solution {

    public int fibb(int n, int[] dp) {
        for (int i = 3; i <= n; i++) {
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=dp[0]+dp[1];
        }
        
        return dp[2];
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2]=1;

        return fibb(n, dp);
    }
}
