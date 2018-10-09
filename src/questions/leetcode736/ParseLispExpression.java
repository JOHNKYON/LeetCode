package questions.leetcode736;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {
    private int pointer = 0; // points to the current character under processing
    public int evaluate(String expression) {
        pointer = 0;
        List<Map<String, Integer>> stack = new ArrayList<>();
        return evaluate(expression, stack);
    }

    /*
     * Parse the variable name and move the pointer
     */
    private String parseVar(String expression) {
        int endIdx=pointer+1;
        while(expression.charAt(endIdx)!=' ' && expression.charAt(endIdx)!=')') {
            endIdx++;
        }
        String var = expression.substring(pointer, endIdx);

        pointer = endIdx;
        return var;
    }

    /*
     * Parse an integer and move the pointer
     */
    private int parseInt(String expression) {
        int endIdx=pointer+1;
        while(expression.charAt(endIdx)!=' ' && expression.charAt(endIdx)!=')') {
            endIdx++;
        }
        int value = Integer.valueOf(expression.substring(pointer, endIdx));
        pointer = endIdx;
        return value;
    }

    /*
     * Evaluate a variable and by looking its value in the stack
     */
    private int evaluateVar(String var, List<Map<String, Integer>> stack) {
        for(int i=stack.size()-1; i>=0; i--) {
            if (stack.get(i).get(var)!=null) {
                return stack.get(i).get(var);
            }
        }
        throw new RuntimeException("Can't find variable in scope");
    }

    /*
     * The recursive method to evaluate a variable, an integer, or an expression
     */
    public int evaluate(String expression, List<Map<String, Integer>> stack) {
        // if it's a variable, get its value from the stack
        if (Character.isLetter(expression.charAt(pointer))) {
            String var = parseVar(expression);
            return evaluateVar(var, stack);
        }

        // if it's a positive number
        if (Character.isDigit(expression.charAt(pointer))) {
            return parseInt(expression);
        }

        // if it's a negative number
        if (expression.charAt(pointer) == '-') {
            advancePointer();
            return parseInt(expression)*(-1);
        }

        // if it's a let, add, or mult expression, i.e. starts with (
        int result=0;
        switch(expression.charAt(pointer+1)) {
            case 'l':
                result = processLet(expression, stack);
                break;
            case 'a':
                result = processAdd(expression, stack);
                break;
            case 'm':
                result = processMult(expression, stack);
                break;
        }
        advancePointer();
        return result;
    }

    private int processAdd(String expression, List<Map<String, Integer>> stack) {
        pointer += 5;
        int left = evaluate(expression, stack);
        advancePointer();
        int right = evaluate(expression, stack);
        return left+right;
    }

    private int processMult(String expression, List<Map<String, Integer>> stack) {
        pointer+=6;
        int left = evaluate(expression, stack);
        advancePointer();
        int right = evaluate(expression, stack);
        return left*right;
    }

    private int processLet(String expression, List<Map<String, Integer>> stack) {
        Map<String, Integer> scope = new HashMap<>(); // we only need to add stack when it's a let expression
        String var;
        int value;
        pointer += 5;
        var = parseVar(expression);
        advancePointer();
        value = evaluate(expression, stack);
        scope.put(var, value);
        stack.add(scope);
        advancePointer();
        // here is how I tell when we reach the last expression of a let expression. The last expression can be a variable
        // so if after the first pair of var and value, we see another expression, then we check if it's followed by an closing
        // parenthesis, if it is, then this is the last expression, otherwise it's another pair of variable and value. If after
        // pair of vairiable and value, we see an integer or another expression, then it's the last expression.
        while (Character.isLetter(expression.charAt(pointer))) {
            var = parseVar(expression);
            if (expression.charAt(pointer) == ')' ) {
                int result = evaluateVar(var, stack);
                stack.remove(stack.size()-1); // before we finsh the evaluation remove the top stack
                return result;
            } else {
                advancePointer();
                value = evaluate(expression, stack);
                scope.put(var, value);
            }
            advancePointer();
        }

        int result = evaluate(expression, stack);
        stack.remove(stack.size()-1); // before we finsh the evaluation remove the top stack
        return result;
    }

    /*
     * Uses to move pointer when it currently points to a space
     */
    private void advancePointer() {
        pointer++;
    }
}
