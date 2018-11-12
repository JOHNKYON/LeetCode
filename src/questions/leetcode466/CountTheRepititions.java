package questions.leetcode466;

public class CountTheRepititions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1.length() * n1 < s2.length() * n2)
            return 0;

        int ptr1 = 0, ptr2 = 0;
        int count1 = 1;
        while (ptr2 < s2.length()) {
            if (ptr1 == s1.length()) {
                ptr1 = 0;
                count1++;
            }
            if (count1 > n1)
                return 0;
            if (s1.charAt(ptr1) == s2.charAt(ptr2))
                ptr2++;
            ptr1++;
        }
        int loop = count1 * n2;
        return n1/loop;
    }
}
