package questions.leetcode913;

import java.util.Arrays;

public class CatAndMouse {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][n];

        for (int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);

        for (int i=0; i<n; i++) {
            dp[0][i] = 1;
            dp[i][i] = 2;
        }

        return helper(graph, dp, 1, 2);
    }

    private int helper(int[][] graph, int[][] dp, int mouse, int cat) {
        if (dp[mouse][cat] != -1)
            return dp[mouse][cat];

        dp[mouse][cat] = 0;
        int mouseDefault = 2;
        int[] mouseGoList = graph[mouse], catGoList = graph[cat];

        for (int mouseGo: mouseGoList) {
            if (mouseGo == cat)
                continue;

            int catDefault = 1;
            for (int catGo: catGoList) {
                if (catGo == 0)
                    continue;
                int next = helper(graph, dp, mouseGo, catGo);
                if (next == 2) {
                    catDefault = 2;
                    break;
                }
                if (next == 0) {
                    catDefault = 0;
                }
            }
            if (catDefault == 1) {
                mouseDefault = 1;
                break;
            } if (catDefault == 0) {
                mouseDefault = 0;
            }
        }

        dp[mouse][cat] = mouseDefault;
        return mouseDefault;
    }
}
