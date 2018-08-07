package questions.leetcode338;

public class CountingBits {
    public int[] countBits(int num) {
        if (num < 0)    return null;

        int[] res = new int[num+1];

        int pow = 1;
        for(int i=1; i<=num; i++){
            if (i==pow*2)
                pow *= 2;
            res[i] = res[i-pow]+1;
        }
        return res;
    }
}
