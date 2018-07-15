package questions.leetcode85;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n==0)   return 0;
        int m = matrix[0].length;
        int max=0;

        int[] len=new int[m];

        for(int j=0; j<m; j++){
            len[j] = matrix[0][j]-'0';
        }
        max = maxBar(len);

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if (matrix[i][j] == '0'){
                    len[j] = 0;
                } else {
                    len[j] += 1;
                }
            }
            int curr = maxBar(len);
            max = (max>curr)? max:curr;
        }

        return max;
    }

    private int maxBar(int[] bars){
        int max=0;
        Stack<Integer> stack = new Stack<>();
        int n=bars.length;

        int i=0;
        while(i<n){
            if(stack.isEmpty() || bars[i]>bars[stack.peek()]){
                stack.push(i++);
            } else {
                int temp=stack.pop();

                int curr = (bars[temp]) * ((stack.isEmpty())? i: i-stack.peek()-1);
                max = (max > curr)? max:curr;
            }
        }
        while(!stack.isEmpty()){
            int temp=stack.pop();

            int curr = (bars[temp]) * ((stack.isEmpty())? i: i-stack.peek()-1);
            max = (max > curr)? max:curr;
        }
        return max;
    }
}
