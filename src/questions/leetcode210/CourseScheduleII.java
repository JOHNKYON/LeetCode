package questions.leetcode210;

public class CourseScheduleII {
    int[] norm;
    int[] pre_count;
    int[] ans;
    int curr;
    public int[] findOrder(int n, int[][] prerequisites) {
        norm = new int[n];
        pre_count = new int[n];
        curr = n-1;
        ans = new int[n];

        for (int[] pair: prerequisites) {
            pre_count[pair[0]]++;
        }

        for (int i=0; i<n; i++) {
            if (pre_count[i] == 0)
                dfs(i, prerequisites);
        }

        if (curr != -1)
            return new int[0];

        for (int[] pair: prerequisites) {
            if (norm[pair[0]] < norm[pair[1]])
                return new int[0];
        }

        return ans;
    }

    private void dfs(int i, int[][] prer) {
        for (int[] pair: prer) {
            if (pair[1] == i && norm[pair[0]] == 0) {
                norm[pair[0]] = -1;
                dfs(pair[0], prer);
            }
        }
        ans[curr] = i;
        norm[i] = curr--;

    }
}
