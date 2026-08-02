/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{

	static int findMaxSubArrayLen(int ar[], int k) {
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		//HashMap for storing Number and their indexes.
		
		for(int i = 0; i<ar.length ; i++){
	//Loop to find if there is any number present if first occurance create an adjacency list for it
		   map.putIfAbsent(ar[i], new ArrayList<>());
           map.get(ar[i]).add(i);
			
		}
		int res = 0;
		//Final length of longest subarray(same number)
		for(List<Integer> AdjacencyList : map.values()) {
			
			int left = 0;
			int right = 0;
			
			for(right = 0; right < AdjacencyList.size(); right ++){
				
				while((AdjacencyList.get(right) - right - (AdjacencyList.get(left)
				- left) > k)) {
	//check if list left value-right value(index) and numbers in between >k or not (variable sliding window)
				 	left ++;
				 }
				 int len=right - left + 1;
				 res = Math.max(res, len);
				 //if subarray size is greater then update it
			}
			
		}
		return res;
		
		
	}
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		 int[] ar={1,1,2,2,2,1,1,4,4,4,5,5,5,5,5,6,6};
		 int k=2;
        
        System.out.println(findMaxSubArrayLen(ar, k));
        
        
        

	}
}
