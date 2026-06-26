class Pair{
    char ch;
    int count;

    Pair(char ch,int count){
        this.count=count;
        this.ch=ch;
    }


}
class Solution {
    public String removeDuplicates(String s, int k) {
        int size=s.length();
        StringBuilder ans=new StringBuilder();

        Stack<Pair> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(c,1));
                continue;
            }
            Pair p=st.peek();
            if(p.ch!=c){
                st.push(new Pair(c,1));
                continue;
            }
            
            if((p.count<k-1) && (c==p.ch)){
                Pair t=st.pop();
                t.count++;
                st.push(t);
                continue;
            }
            st.pop();

        }
        while(!st.isEmpty()){
            Pair x=st.pop();
            int l=0;
            while(l<x.count){
                ans.append(x.ch);
                l++;
            }
        }
        return ans.reverse().toString();


    }
}
