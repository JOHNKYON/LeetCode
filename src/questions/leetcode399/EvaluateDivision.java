package questions.leetcode399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    HashMap<String, List<String>> pairs;
    HashMap<String, List<Double>> vals;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        pairs = new HashMap<>();
        vals = new HashMap<>();

        for (int i=0; i<values.length; i++){
            String[] equation = equations[i];
            double value = values[i];

            if (!pairs.containsKey(equation[0])){
                pairs.put(equation[0], new ArrayList<>());
                vals.put(equation[0], new ArrayList<>());
            }
            if (!pairs.containsKey(equation[1])){
                pairs.put(equation[1], new ArrayList<>());
                vals.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            vals.get(equation[0]).add(value);
            vals.get(equation[1]).add(1/value);
        }

        double[] res = new double[queries.length];
        for (int i=0; i<queries.length; i++){
            String[] query = queries[i];
            double temp = dfs(query[0], query[1], new HashSet<>(), 1.0);
            res[i] = (temp == 0.0)? -1.0: temp;
        }
        return res;
    }

    private double dfs(String start, String end, HashSet<String> set, double val){
        // Back to begining;
        if (set.contains(start))    return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end))  return val;
        set.add(start);

        List<String> strList = pairs.get(start);
        List<Double> valueList = vals.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, set, val*valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}
