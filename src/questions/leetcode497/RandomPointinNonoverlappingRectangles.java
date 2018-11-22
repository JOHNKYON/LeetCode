package questions.leetcode497;

import java.util.Random;

public class RandomPointinNonoverlappingRectangles {
    int[][] rectangles;
    int[] spaces;
    int space_sum;
    Random random;

    public RandomPointinNonoverlappingRectangles(int[][] rects) {
        int n = rects.length;
        space_sum = 0;
        random = new Random();
        rectangles = new int[n][4];
        spaces = new int[n];
        for (int i=0; i<n; i++) {
            rectangles[i] = rects[i];
            spaces[i] = (rects[i][3] - rects[i][1]) * (rects[i][2] - rects[i][0]);
            space_sum += spaces[i];
        }
    }

    public int[] pick() {
        int[] res = new int[2];
        if (spaces.length == 0)
            return res;
        int seed = random.nextInt(space_sum);
        int i = 0;
        int curr = spaces[0];
        while (curr < seed) {
            curr += spaces[i];
            i++;
        }
        res[0] = random.nextInt(rectangles[i][2] - rectangles[i][0]) + rectangles[i][0];
        res[1] = random.nextInt(rectangles[i][3] - rectangles[i][1]) + rectangles[i][1];

        return res;
    }
}
