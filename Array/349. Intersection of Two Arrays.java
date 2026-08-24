class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        List<Integer> ans=new ArrayList<>();
        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i],true);
            }

            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) ) {
                    if(map.get(nums2[i])!=false){
                        ans.add(nums2[i]);
                        map.remove(nums2[i]);
                    }
                    
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i],true);
            }

            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i]) ) {
                    if(map.get(nums1[i])!=false){
                        ans.add(nums1[i]);
                        map.remove(nums1[i]);
                    }
                    
                }
            }
        }

        int res[]=new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }

        return res;

    }
}
