class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest=-1;
        int secondLargest=-1;
        
        for(int number:arr){
            if(number>largest){
                secondLargest=largest;
                largest=number;
            }else if(number<largest && number>secondLargest){
                secondLargest=number;
            }
        }
        return secondLargest;
    }
}
