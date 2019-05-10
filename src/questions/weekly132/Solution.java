package questions.weekly132;

import questions.dataStructure.TreeNode;

import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int ptr1 = s.length()-1, ptr2 = t.length() - 1;
        int count1 = 0, count2 = 0;
        while (ptr1 >=0 && ptr2 >= 0) {
            while (ptr1 >= 0 && (s.charAt(ptr1) == '#' || count1 > 0)) {
                if (s.charAt(ptr1) == '#') {
                    count1++;
                } else {
                    count1--;
                }
                ptr1--;
            }
            while (ptr2 >= 0 && (t.charAt(ptr2) == '#' || count2 > 0)) {
                if (t.charAt(ptr2) == '#') {
                    count2++;
                } else {
                    count2--;
                }
                ptr2--;
            }
            if ((ptr1 < 0) ^ (ptr2 < 0)) {
                return false;
            }
            if (ptr1 >= 0 && (s.charAt(ptr1) != t.charAt(ptr2))) {
                return false;
            }
            ptr1--;
            ptr2--;
        }
        return ptr1 < 0 && ptr2 < 0;
    }
}
