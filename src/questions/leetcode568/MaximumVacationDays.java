package questions.leetcode568;

public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (days.length == 0)
            return 0;

        int[][] dp = new int[flights.length][days[0].length];

        for (int j=days[0].length-1; j>=0; j--) {
            for (int i=0; i<flights.length; i++) {
                int temp = 0;

                if (j == days[0].length-1) {
                    for (int x=0; x<flights.length; x++) {
                        if (flights[i][x] == 1 || i == x) {
                            temp = Math.max(temp, days[x][j]);
                        }
                    }
                    dp[i][j] = temp;
                } else {
                    for (int x=0; x<flights.length; x++) {
                        if (flights[i][x] == 1 || i == x) {
                            temp = Math.max(temp, days[x][j] + dp[x][j+1]);
                        }
                    }
                    dp[i][j] = temp;
                }
            }
        }
        return dp[0][0];
    }
}
