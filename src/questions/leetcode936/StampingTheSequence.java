package questions.leetcode936;

import java.util.ArrayList;
import java.util.List;

public class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> ans_buffer = new ArrayList<>();

        if (backStamp(stamp.toCharArray(), target.toCharArray(), 0, ans_buffer)) {
            int[] ans = new int[ans_buffer.size()];
            for (int i=0; i<ans_buffer.size(); i++) {
                ans[i] = ans_buffer.get(ans_buffer.size() - 1 - i);
            }
            return ans;
        }
        else
            return new int[0];
    }

    private boolean backStamp(char[] stamp, char[] curr, int count, List<Integer> buffer) {
        if (count > 10 * curr.length)
            return false;
        boolean done = true;
        for (int i=0; i<curr.length; i++) {
            if (curr[i] != '?') {
                done = false;
                break;
            }
        }
        if (done)
            return true;
        else {
            for (int i=0; i<=curr.length - stamp.length; i++) {
                if (valid(stamp, curr, i)) {
                    char[] temp = new char[stamp.length];
                    for (int j=0; j<stamp.length; j++) {
                        temp[j] = curr[i+j];
                        curr[i+j] = '?';
                    }
                    buffer.add(i);
                    if (backStamp(stamp, curr, count+1, buffer))
                        return true;
                    else
                        return false;
//                    buffer.remove(buffer.size()-1);
//                    for (int j=0; j<stamp.length; j++)
//                        curr[i+j] = temp[j];
                }
            }
            return false;
        }
    }

    private boolean valid(char[] stamp, char[] s, int start) {
        boolean meaningful = false;
        for (int i=0; i<stamp.length; i++) {
            if (s[i+start] != '?')
                meaningful = true;
            if (s[i+start] != '?' && s[i+start] != stamp[i])
                return false;
        }
        return true && meaningful;
    }
}
