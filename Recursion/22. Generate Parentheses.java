class Solution {
    public List<String> help(int open,int close,int n,StringBuilder tmp,List<String> res){
        if(open==n && close==n){
            res.add(tmp.toString());
            return res;
        }
        //open
        if(open<n){
            tmp.append("(");
            help(open+1,close,n,tmp,res);
            tmp.deleteCharAt(tmp.length()-1);
        }
        //close
        if(close<open){
            tmp.append(")");
            help(open,close+1,n,tmp,res);
            tmp.deleteCharAt(tmp.length()-1);

        }
        return res;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        help(0,0,n,new StringBuilder(),ans);
        return ans;
    }
}
