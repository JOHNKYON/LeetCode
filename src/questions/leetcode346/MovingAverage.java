package questions.leetcode346;

public class MovingAverage {
    int len;
    int curr;
    double[] window;
    double average;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        len = 0;
        curr = 0;
        average = 0;
        window = new double[size];
    }

    public double next(int val) {
        if (len < window.length) {
            len++;
            average = average * (len-1) / len;
        } else {
            average -= window[curr] / len;
        }
        window[curr] = val;
        average += window[curr] / len;
        curr = (curr + 1) % window.length;
        return average;
    }
}
