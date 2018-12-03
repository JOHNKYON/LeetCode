package questions.leetcode858;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int[] divider = getDivider(p, q);
        if ((divider[0] & 1) == 0)
            return 0;
        else if ((divider[1] & 1) == 0)
            return 2;
        else
            return 1;
    }

    private int[] getDivider(int p, int q) {
        int[] divider = new int[2];
        int px = 1;
        int qx = 1;
        while (p * px != q * qx) {
            if (p * px < q * qx)
                px++;
            else
                qx++;
        }
        divider[0] = px;
        divider[1] = qx;
        return divider;
    }
}
