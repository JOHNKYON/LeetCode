package questions.leetcode640;

import java.util.ArrayList;
import java.util.List;

public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] equals = equation.split("=");
        int coe = 0, constant = 0;
        for (String s : breakIt(equals[0])){
            if (s.contains("x")) {
                coe += Integer.parseInt(coeff(s));
            } else
                constant -= Integer.parseInt(s);
        }
        for (String s: breakIt(equals[1])) {
            if (s.contains("x"))
                coe -= Integer.parseInt(coeff(s));
            else
                constant += Integer.parseInt(s);
        }
        if (coe == 0) {
            if (constant == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x="+ (constant / coe);
    }

    private List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder r = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0)
                    res.add(r.toString());
                r = new StringBuilder("" + s.charAt(i));
            } else
                r.append(s.charAt(i));
        }
        res.add(r.toString());
        return res;
    }

    private String coeff(String s) {
        if (s.length() > 1 && s.charAt(s.length()-2) - '0' >= 0 && s.charAt(s.length()-2) - '0' <= 9)
            return s.replace("x", "");
        else
            return s.replace("x", "1");
    }
}
