package questions.leetcode251;

public class Flatten2DVector {
    int i;
    int j;
    int[][] v;

    public Flatten2DVector(int[][] v) {
        this.v = v;
        i = 0;
        j = -1;
    }

    public int next() {
        if (hasNext()) {
            j++;
            while(j == v[i].length) {
                j = 0;
                i++;
            }
        }
        return v[i][j];
    }

    public boolean hasNext() {
        int ni = i, nj = j+1;
        while(ni < v.length && nj == v[ni].length) {
            nj=0;
            ni++;
        }
        return ni != v.length;
    }
}
