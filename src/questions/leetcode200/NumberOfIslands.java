package questions.leetcode200;

public class NumberOfIslands {

    public int numberOfIslands(char[][] grid){
        if (grid.length == 0) {return 0;}

        int length = grid.length;
        int width = grid[0].length;

        int result = 0;

        for (int i=0; i<length; i++){
            for (int j=0; j<width; j++){
                result += count(i, j, grid, length, width);
            }
        }

        return result;

    }

    private int count(int a, int b, char[][] grid, int length, int width){


        if (grid[a][b] == '0'){
            return 0;
        }
        else {
            set(a, b, grid, length, width);
            return 1;
        }
    }

    private int set(int a, int b, char[][] grid, int length, int width){
        if (grid[a][b] == '0'){
            return 0;
        } else {
            grid[a][b] = '0';
            if (a != 0 && grid[a-1][b] != '0') {set(a-1, b, grid, length, width);}
            if (a != length-1 && grid[a+1][b] != '0') {set(a+1, b, grid, length, width);}
            if (b != 0 && grid[a][b-1] != '0') {set(a, b-1, grid, length, width);}
            if (b != width-1 && grid[a][b+1] != '0') {set(a, b+1, grid, length, width);}
        }
        return 0;
    }
}
