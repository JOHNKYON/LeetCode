package questions.leetcode273;

public class IntegertoEnglishWords {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int bill = num / 1000000000;
        int mill = num / 1000000 - bill * 1000;
        int thousand = num / 1000 - mill * 1000 - bill * 1000000;
        int rest = num % 1000;

        String ans = "";
        if (bill != 0)
            ans += threeDigits(bill) + " Billion";
        if (mill != 0) {
            if (ans.length() != 0)
                ans += " ";
            ans += threeDigits(mill) + " Million";
        }
        if (thousand != 0) {
            if (ans.length() != 0)
                ans += " ";
            ans += threeDigits(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (ans.length() != 0)
                ans += " ";
            ans += threeDigits(rest);
        }
        return ans;
    }

    private String ones(int n) {
        switch(n) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private String lessThanTwenty(int n) {
        switch(n) {
            case 10:    return "Ten";
            case 11:    return "Eleven";
            case 12:    return "Twelve";
            case 13:    return "Thirteen";
            case 14:    return "Fourteen";
            case 15:    return "Fifteen";
            case 16:    return "Sixteen";
            case 17:    return "Seventeen";
            case 18:    return "Eighteen";
            case 19:    return "Nineteen";
        }
        return "";
    }

    private String tens(int n) {
        switch(n) {
            case 2:    return "Twenty";
            case 3:    return "Thirty";
            case 4:    return "Forty";
            case 5:    return "Fifty";
            case 6:    return "Sixty";
            case 7:    return "Seventy";
            case 8:    return "Eighty";
            case 9:    return "Ninety";
        }
        return "";
    }

    private String twoDigits(int n) {
        if (n == 0)
            return "";
        if (n < 10)
            return ones(n);
        if (n < 20)
            return lessThanTwenty(n);
        else {
            int ten = n/10;
            int one = n - 10 * ten;
            if (one == 0) {
                return tens(ten);
            } else {
                return tens(ten) + " " + ones(one);
            }
        }
    }

    private String threeDigits(int n) {
        int hundred = n/100;
        int two_digits = n - 100 * hundred;
        String res = "";
        if (hundred != 0 && two_digits != 0)
            res = ones(hundred) + " Hundred " + twoDigits(two_digits);

        else if (hundred != 0)
            res += ones(hundred) + " Hundred";
        else if (two_digits != 0)
            res += twoDigits(two_digits);
        return res;
    }
}
