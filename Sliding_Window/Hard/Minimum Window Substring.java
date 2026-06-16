class Solution {
    //Function to map all the string values to hashmap(frequency)
    public static void fnMap(HashMap<Character, Integer> retmap, String j) {

        for (int i = 0; i < j.length(); i++) {
            char c = j.charAt(i);
            retmap.put(c, retmap.getOrDefault(c, 0) + 1);

        }

    }

    //Function to compare the Hashmap Frequency
    public static Boolean comHash(HashMap<Character, Integer> tmap, HashMap<Character, Integer> smap) {
        for (char c : tmap.keySet()) {
            if (!smap.containsKey(c)) {
                return false;

            }
            if (tmap.get(c) > smap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int retlen = 100000;
        String retu = "";
        int low = 0;
        int high = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        fnMap(tmap, t);
        if (s.length() < t.length()) {
            return "";
        }

        for (high = 0; high < s.length(); high++) {
            char c = s.charAt(high);
            smap.put(c, smap.getOrDefault(c, 0) + 1);

            while (comHash(tmap, smap)) {
                int len = high - low + 1;
                
                if (len < retlen) {
                    retlen=len;
                    retu = s.substring(low, high + 1);

                }
                char x = s.charAt(low);

                smap.put(x, smap.get(x) - 1);
                if (smap.get(x) == 0) {
                    smap.remove(x);
                }

                low++;

            }

        }
        return retu;

    }
}
