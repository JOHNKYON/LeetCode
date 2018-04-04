package questions.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOHNKYON on 2018/4/4.
 * This is a solution to LeetCode Questions.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int up = 0, down = 0, left = 0, right = 0;
        if (matrix.length == 0){return list;}

        int n = matrix.length, m = matrix[0].length;
        int dir = 0;

        while ((up + down) != n && (left + right) != m){
            if (0 == dir){
                for (int i = left; i < m - right; i++){
                    list.add(matrix[up][i]);
                }
                up += 1;
                dir = 1;
            } else if (1 == dir){
                for (int i = up; i < n - down; i++){
                    list.add(matrix[i][m - right - 1]);
                }
                right += 1;
                dir = 2;
            } else if (2 == dir){
                for (int i = right; i < m - left; i++){
                    list.add(matrix[n - down - 1][m - i - 1]);
                }
                down += 1;
                dir = 3;
            } else if (3 == dir){
                for (int i = down; i < n - up; i++){
                    list.add(matrix[n - i - 1][left]);
                }
                left += 1;
                dir = 0;
            }
        }
        return list;
    }
}
