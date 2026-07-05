class Solution {
    String[] map={
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

        
    public void help(String digits,int idx,StringBuilder tmp,List<String> res){
        if(idx==digits.length()){
            res.add(tmp.toString());
            return;
        }

        String letters=map[digits.charAt(idx)-'0'];

        for(int i=0;i<letters.length();i++){
            tmp.append(letters.charAt(i));
            help(digits,idx+1,tmp,res);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }


    public List<String> letterCombinations(String digits) {
    List<String> ans=new ArrayList<>();
    StringBuilder s=new StringBuilder();
    help(digits,0,s,ans);
    return ans;    
    }
}
