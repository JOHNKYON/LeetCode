package questions.leetcode733;

public class FloodFill {
    final static int[][] moves = {{0, 1}, {0, -1}, {1,0}, {-1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length <= sr || image[0].length <= sc || image[sr][sc] == newColor)
            return image;
        draw(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void draw(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length)
            return;

        if (image[r][c] != oldColor)
            return;

        image[r][c] = newColor;
        for (int[] move: moves) {
            draw(image, r+move[0], c+move[1], oldColor, newColor);
        }
    }
}
