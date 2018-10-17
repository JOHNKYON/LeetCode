package questions.leetcode809;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word: words) {
            count += expressive(S, word);
        }
        return count;
    }

    int expressive(String s, String w) {
        int n1 = s.length();
        int n2 = w.length();

        if (n1 < n2)    return 0;

        int ptr1 = 0, ptr2 = 0, count1 = 0, count2 = 0;
        char c1=' ', c2=' ';
        while (ptr1 <= n1) {
            if (ptr1 == 0)
                c1 = s.charAt(ptr1);
            if (ptr2 == 0)
                c2 = w.charAt(ptr2);

            if (c1 != c2)
                return 0;

            if (ptr1 == n1 || s.charAt(ptr1) != c1){
                while (ptr2 != n2 && w.charAt(ptr2) == c2) {
                    count2++;
                    ptr2++;
                }

                if (count1 < count2 || (count1 != count2 && count1 < 3))
                    return 0;

                if (ptr1 != n1)
                    c1 = s.charAt(ptr1);
                if (ptr2 != n2)
                    c2 = w.charAt(ptr2);
                count1=1;
                count2=0;
            } else {
                count1++;
            }
            ptr1++;
        }
        return (ptr2 == n2)? 1: 0;
    }
}
