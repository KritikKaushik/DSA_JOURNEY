class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();

        Arrays.sort(intervals,(x,y) -> Integer.compare(x[0],y[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=0;i<intervals.length;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];

            if(end>=s){
                end=Math.max(end,e);
            }else{
                ans.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][] );
    }
}
