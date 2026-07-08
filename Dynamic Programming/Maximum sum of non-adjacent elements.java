import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		if(n==1){
			return nums.get(0);
		}
		if(n==2){
			return Math.max(nums.get(0),nums.get(1));
		}

		int[] dp=new int[n];
		dp[0]=nums.get(0);
		dp[1]=Math.max(nums.get(0),nums.get(1));

		for(int i=2;i<n;i++){
			dp[i]=Math.max(nums.get(i)+dp[i-2],dp[i-1]);
		}
		return dp[n-1];
	}
}
