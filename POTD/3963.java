class Solution {
    public String[] createGrid(int m,int n) {
        String[] arr=new String[m];

        for(int i=0;i<m;i++){
            char[] ch=new char[n];
            Arrays.fill(ch,'#');

            if(i==0){
                Arrays.fill(ch,'.');
            }else{
                ch[n-1]='.';
            }

            arr[i]=new String(ch);
        }

        return arr;
    }
}
