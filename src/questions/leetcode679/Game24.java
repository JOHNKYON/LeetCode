package questions.leetcode679;

import java.util.ArrayList;

public class Game24 {
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> list = new ArrayList<>();
        for (int v: nums)
            list.add((double)v);
        return solve(list);
    }

    private boolean solve(ArrayList<Double> list) {
        if (list.size() == 0)   return false;
        if (list.size() == 1)   return Math.abs(list.get(0) - 24) < 1e-6;

        for (int i=0; i<list.size(); i++) {
            for (int j=0; j<list.size(); j++) {
                if (i!=j) {
                    ArrayList<Double> list2 = new ArrayList<>();
                    for (int k=0; k<list.size(); k++)
                        if (k !=i && k != j) {
                            list2.add(list.get(k));
                        }
                    for (int k=0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) list2.add(list.get(i) + list.get(j));
                        if (k == 1) list2.add(list.get(i) * list.get(j));
                        if (k == 2) list2.add(list.get(i) - list.get(j));
                        if (k == 3) {
                            if (list.get(j) != 0)
                                list2.add(list.get(i) / list.get(j));
                            else
                                continue;
                        }
                        if (solve(list2))   return true;
                        list2.remove(list2.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
