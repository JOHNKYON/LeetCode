package questions.leetcode388;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> level_stack = new Stack<>();
        Stack<Integer> length_stack = new Stack<>();

        String[] dirs = input.split("\\n");
        int res = 0;

        for (String dir: dirs){
            int level = countLevel(dir);
            int length = dir.length() - level;

            while (!level_stack.isEmpty() && level != level_stack.peek()+1){
                level_stack.pop();
                length_stack.pop();
            }

            if (level != 0)
                length = length_stack.peek()+length;
            level_stack.push(level);
            length_stack.push(length+1);
            if (dir.contains("."))
                res = Math.max(res, length);
        }
        return res;
    }

    private int countLevel(String dir){
        int count = 0;
        int i = 0;
        char[] str = dir.toCharArray();

        while (i < dir.length()){
            if (str[i] == '\t'){
                i++;
                count++;
            } else
                break;
        }

        return count;
    }
}
