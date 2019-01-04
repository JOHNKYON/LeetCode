package questions.leetcode93;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> candi = new ArrayList<>();
        validation(s, res, 0, candi);
        return res;
    }

    private void validation(String s, List<String> res, int stage, List<String> candi) {
        if (s.length() > (4-stage) * 3 || s.length() < (4-stage))
            return;

        if (stage != 3) {
            for (int i=0; i<3 && i<s.length(); i++) {
                if (s.charAt(0) == '0' && i>0)
                    return;

                if (Integer.parseInt(s.substring(0, i+1)) > 255)
                    continue;
                candi.add(s.substring(0, i+1));
                validation(s.substring(i+1, s.length()), res, stage+1, candi);
                candi.remove(candi.size()-1);
            }
        } else {
            if (s.length() > 1 && s.charAt(0) == '0')
                return;

            if (Integer.parseInt(s) > 255)
                return;
            else {
                StringBuilder sb = new StringBuilder();
                for (String str: candi) {
                    sb.append(str);
                    sb.append('.');
                }
                sb.append(s);
                res.add(sb.toString());
            }
        }
    }
}
