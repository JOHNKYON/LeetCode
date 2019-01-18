package questions.leetcode282;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public ArrayList<String> answer;
    public String digits;
    public long target;

    /*
       index: The index in the digits string that we are processing.
       value: current value of the expression.
       ops: Represents the actual expression.
       previousValue: Previous operand of the expression along with the appropriate sign.
    */
    public void recurse(int index, long value, StringBuilder ops, long previousValue) {
        String nums = this.digits;

        // Base case. Time = O(N)
        if (index == nums.length()) {
            if (value == this.target) {
                this.answer.add(ops.toString());
            }
            return;
        }

        long current_val = 0;
        String current_val_rep = null;
        int length = nums.length();

        // Consider all operands
        for (int i = index; i < length; i++) {

            // Operand
            current_val = current_val * 10 + Character.getNumericValue(nums.charAt(i));
            current_val_rep = Long.toString(current_val);

            // If this is the first index, simply recurse.
            if (index == 0) {
                this.recurse(
                        i + 1,
                        current_val,
                        new StringBuilder(ops.toString()).append(current_val_rep),
                        current_val);
            } else {

                long v = value - previousValue;

                // Constructing a new String builder takes O(1) and the append takes ammortized O(1).
                // MULTIPLY
                this.recurse(
                        i + 1,
                        v + (previousValue * current_val),
                        new StringBuilder(ops.toString()).append('*').append(current_val_rep),
                        previousValue * current_val);

                // ADD
                this.recurse(
                        i + 1,
                        value + current_val,
                        new StringBuilder(ops.toString()).append('+').append(current_val_rep),
                        current_val);

                // SUBTRACT
                this.recurse(
                        i + 1,
                        value - current_val,
                        new StringBuilder(ops.toString()).append('-').append(current_val_rep),
                        -current_val);
            }

            // Avoid operands like 025. If the current index is 0, it should be an operand in itself.
            if (nums.charAt(index) == '0') {
                break;
            }
        }
    }

    public List<String> addOperators(String num, int target) {

        if (num.length() == 0) {
            return new ArrayList<String>();
        }

        this.target = target;
        this.digits = num;
        this.answer = new ArrayList<String>();
        this.recurse(0, 0, new StringBuilder(), 0);
        return this.answer;
    }
}
