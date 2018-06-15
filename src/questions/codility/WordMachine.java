package questions.codility;

import java.util.Stack;
import static oracle.jrockit.jfr.events.Bits.intValue;

public class WordMachine {
    int MIN = 0, MAX = intValue(Math.pow(2, 20)-1);

    public int solution(String S){
        Stack<Integer> stack = new Stack<Integer>();

        String[] operations = S.split(" ");

        for (String operation : operations){
            if (isInteger(operation)){
                if (push(stack, Integer.parseInt(operation)) == -1){return -1;}
            } else if (operation.equals("POP")){
                if (pop(stack) == -1){return -1;}
            } else if (operation.equals("DUP")){
                if (dup(stack) == -1){return -1;}
            } else if (operation.equals("+")){
                if (plus(stack) == -1){return -1;}
            } else if (operation.equals("-")){
                if (minus(stack) == -1){return -1;}
            }
        }
        if (stack.size()==0){
            return -1;
        } else {return stack.pop();}

    }

    private int push(Stack stack, Integer a){
        // Push
        if (!boundaryCheck(a)){return -1;}
        stack.push(a);
        return 0;
    }

    private int dup(Stack stack){
        // Duplication
        if (stack.size()== 0){return -1;}
        stack.push(stack.lastElement());
        return 0;
    }

    private int pop(Stack stack){
        // Pop
        if (stack.size() == 0){return -1;}
        stack.pop();
        return 0;
    }

    private int plus(Stack<Integer> stack){
        // Plus
        if (stack.size() <= 1){return -1;}
        int temp = (stack.pop()+stack.pop());
        if (!boundaryCheck(temp)){return -1;}
        stack.push(temp);
        return 0;
    }

    private int minus(Stack<Integer> stack){
        // Minus
        if (stack.size() <= 1){return -1;}
        int temp = (stack.pop()-stack.pop());
        if (!boundaryCheck(temp)){return -1;}
        stack.push(temp);
        return 0;
    }

    private boolean boundaryCheck(int a){
        // Check for boundary validation.
        return (a >= MIN && a <= MAX);
    }

    private boolean isInteger( String input )
    {
        try
        {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e)
        {
            return false;
        }
    }
}
