package questions.stringToInteger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JOHNKYON on 2018/3/23.
 * This is a solution to LeetCode Questions.
 */
public class StringToInteger {
    public int myAtoi(String str){
        int restult = 0;
        int i = 0;
        boolean negative = false;
        boolean firstValidSymbolSet = false;
        List<Character> validSet = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        if (0 == str.length()){return 0;}
        if (i >= str.length()){return 0;}

        while (i < str.length()){
            if ('+'== str.charAt(i) && !firstValidSymbolSet) {negative = false; firstValidSymbolSet= true; i++; continue;}
            if ('-'== str.charAt(i) && !firstValidSymbolSet) {negative = true; firstValidSymbolSet= true; i++; continue;}

            if (!validSet.contains(str.charAt(i))){
                if (' ' == str.charAt(i) && !firstValidSymbolSet){i++; continue;}
                break;
            }
            firstValidSymbolSet = true;
            int digit = str.charAt(i) - '0';
            int newResuilt = restult * 10 + digit;

            if ( restult > (Integer.MAX_VALUE / 10) || restult == (Integer.MAX_VALUE/10) && digit > 7){           //Over int boundary
                if (negative){return -2147483648;}
                else {return 2147483647;}
            }
            restult = newResuilt;
            i++;
        }
        if (negative){return 0 - restult;}
        return restult;
    }
}
