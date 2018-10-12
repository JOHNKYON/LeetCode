import questions.leetcode353.SnakeGame;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};

        SnakeGame method= new SnakeGame(3,3, food);

        int[] input = {7,6,4,3,1};
        int[][] hits = {{1,0}, {0,0}, {2,0}};
        String[] strs  = {"a","b","c"};
        List<String> d = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };
//        System.out.print(method.numDistinct("babgbag", "bag"));
        method.move("D");
        method.move("D");
        method.move("R");
        method.move("U");
        method.move("U");
        method.move("L");
        method.move("D");
        method.move("R");
        method.move("R");
        method.move("U");
        method.move("L");
        method.move("D");
    }

}
