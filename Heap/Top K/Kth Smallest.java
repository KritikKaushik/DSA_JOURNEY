class Solution {
	public int kthSmallest(int[] arr, int k) {
		// Code here
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
		int size=arr.length;
		for(int i=0;i<k;i++){
		    pq.add(arr[i]);
		}
		for(int j=k;j<size;j++){
		    if(pq.peek()>arr[j]){
		        pq.poll();
		        pq.add(arr[j]);
		    }
		}
		return pq.peek();
	}
}
