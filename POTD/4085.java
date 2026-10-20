class Solution {
    public int findColoredRoot(int[][] e, String c) {
        int n=c.length();
        int[] indegree=new int[n];
        int[] outdegree=new int[n];

        for(int i=0;i<n-1;i++){
            int x=e[i][0];
            int y=e[i][1];
            char a=c.charAt(x);
            char b=c.charAt(y);
            if(a=='R' && b=='B' || a=='B' && b=='W' || a=='W' && b=='R'){
                outdegree[x]++;
                indegree[y]++;
            }
            else if(a=='B' && b=='R' || a=='W' && b=='B' || a=='R' && b=='W'){
                outdegree[y]++;
                indegree[x]++;
            }
        }

        int count=0;
        int answer=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                answer=i;
                count++;
            }
            if(outdegree[i]>=3){
                return -1;
            }
        }
        if(count!=1){
            return -1;
        }
        return answer;
    }
}
