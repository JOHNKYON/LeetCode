package questions.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Weekly {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.sort(clips, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        if (clips.length == 0 && T != 0)
            return -1;
        if (clips[0][0] != 0)
            return -1;
        dp[0] = 1;
        for (int j = 0; j<clips.length; j++) {
            if (j != 0 && clips[j][0] == clips[j-1][0])
                continue;
            int[] clip = clips[j];
            for (int i=clip[0]; i<=clip[1] && i <=T; i++) {
                if (dp[i] == 0) {
                    dp[i] = dp[clip[0]] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == 0? -1: dp[T] - 1;
    }
}
