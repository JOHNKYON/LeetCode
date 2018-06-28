package questions.codility;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public double solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        // write your code in Java SE 8
        double res = 0;
        double dis = Math.sqrt((Math.pow(x2-x1, 2) + (Math.pow(y2-y1, 2))));

        // Disjoint
        if (dis >= (r1 + r2)) return res;

            // C1 contains C2
        else if (dis <= (r1 - r2)) {
            res = Math.PI * (Math.pow(r2, 2));
        }
        // C2 contains C1
        else if (dis <= (r1 - r2)) {
            res = Math.PI * (Math.pow(r1, 2));
        }
        else {
            // Intersection
            double angle1 = Math.acos( (Math.pow(r1,2) + Math.pow(dis, 2) - Math.pow(r2, 2)) /
                    (2 * r1 * dis));
        }

        return res;
    }
}