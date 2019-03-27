package questions.leetcode71;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] commands = path.split("/");
        for (String command: commands) {
            if (command.equals(".") || command.length() == 0)
                continue;
            else if (command.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(command);
            }
        }

        return buildPath(stack);
    }

    private String buildPath(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }
}
