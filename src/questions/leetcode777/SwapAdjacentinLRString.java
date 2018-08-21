package questions.leetcode777;

public class SwapAdjacentinLRString {
    public boolean canTransform(String start, String end) {
        int len = start.length();
        if (len != end.length())    return false;

        int p1=0, p2=0;
        while(p1 < len || p2 < len){
            while (p1 < len && start.charAt(p1) == 'X')
                p1++;
            while (p2 < len && end.charAt(p2) == 'X')
                p2++;
            if (p1 == len && p2 == len)
                return true;
            if (p1 == len || p2 == len)
                return false;
            if (start.charAt(p1) != end.charAt(p2))
                return false;
            if (start.charAt(p1) == 'L' && p1 < p2)
                return false;
            if (start.charAt(p1) == 'R' && p1 > p2)
                return false;
            p1++;
            p2++;
        }
        return true;
    }
}
