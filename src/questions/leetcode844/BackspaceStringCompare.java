package questions.leetcode844;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int ptr_s = S.length()-1;
        int ptr_t = T.length()-1;

        int count_s = 0;
        int count_t = 0;

        while (ptr_s >= 0 && ptr_t >= 0) {
            if (S.charAt(ptr_s) == '#') {
                count_s++;
                ptr_s--;
                while (ptr_s >= 0 && (count_s > 0 || S.charAt(ptr_s) == '#')) {
                    if (S.charAt(ptr_s) == '#')
                        count_s++;
                    else
                        count_s--;
                    ptr_s--;
                }
            }
            if (T.charAt(ptr_t) == '#') {
                count_t++;
                ptr_t--;
                while (ptr_t >= 0 && (count_t > 0 || T.charAt(ptr_t) == '#')) {
                    if (T.charAt(ptr_t) == '#')
                        count_t++;
                    else
                        count_t--;
                    ptr_t--;
                }
            }
            if (ptr_s < 0 || ptr_t < 0)
                break;
            if (S.charAt(ptr_s) != T.charAt(ptr_t))
                return false;
            ptr_s--;
            ptr_t--;
        }

        while (ptr_s >= 0) {
            if (S.charAt(ptr_s) == '#') {
                count_s++;
                ptr_s--;
                while (ptr_s >= 0 && (count_s > 0 || S.charAt(ptr_s) == '#')) {
                    if (S.charAt(ptr_s) == '#')
                        count_s++;
                    else
                        count_s--;
                    ptr_s--;
                }
            }
            else
                return false;
            ptr_s--;
        }
        while (ptr_t >= 0) {
            if (T.charAt(ptr_t) == '#') {
                count_t++;
                ptr_t--;
                while (ptr_t >= 0 && (count_t > 0 || T.charAt(ptr_t) == '#')) {
                    if (T.charAt(ptr_t) == '#')
                        count_t++;
                    else
                        count_t--;
                    ptr_t--;
                }
            }
            else
                return false;
            ptr_t--;
        }
        return true;
    }
}
