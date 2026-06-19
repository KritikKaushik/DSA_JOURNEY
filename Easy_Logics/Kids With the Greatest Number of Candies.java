class Solution {
    public static int findMax(int[] arr, int extraCan) {
        int maxi = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            maxi = Math.max(maxi, sum);
        }

        return maxi;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> op = new ArrayList<Boolean>();
        int low = findMax(candies, extraCandies);

        for (int j = 0; j < candies.length; j++) {
            if (candies[j] + extraCandies >= low) {
                op.add(true);
            } else {a
                op.add(false);
            }
        }

        return op;
    }
}

// Found max of array if its less tha max then false else its true;
