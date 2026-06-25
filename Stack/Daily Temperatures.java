class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length-1;
        int days[]=new int[temperatures.length];
        days[len]=0;


        Stack<Integer> st=new Stack<>();
        st.push(len);
        for(int i=len-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();                
            }
            if(!st.isEmpty()){
              days[i]=st.peek()-i;
            }else{  
                days[i]=0;
            }            
            st.push(i);           
        }
        return days;
    }
}
