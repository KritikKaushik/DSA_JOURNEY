class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a1 = Integer.parseInt(arriveAlice.substring(0, 2)) * 100
               + Integer.parseInt(arriveAlice.substring(3));
        int a2 = Integer.parseInt(leaveAlice.substring(0, 2)) * 100
               + Integer.parseInt(leaveAlice.substring(3));
        int b1 = Integer.parseInt(arriveBob.substring(0, 2)) * 100
               + Integer.parseInt(arriveBob.substring(3));
        int b2 = Integer.parseInt(leaveBob.substring(0, 2)) * 100
               + Integer.parseInt(leaveBob.substring(3));

        int start = Math.max(a1, b1);
        int end = Math.min(a2, b2);

        if (start > end) {
            return 0;
        }

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return countDays(end, days) - countDays(start - 1, days);
    }

    private int countDays(int date, int[] days) {
        int month = date / 100;
        int day = date % 100;
        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }
}
