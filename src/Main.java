import questions.leetcode20.ValidParentheses;

public class Main {
    public static void main(String[] args){
        ValidParentheses method = new ValidParentheses();
        String s = "({[{}]})";

        System.out.print(method.isValid(s));
    }

}
